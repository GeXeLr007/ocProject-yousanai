package com.dulp.xyz.controller;

import com.dulp.xyz.common.storage.QiniuStorage;
import com.dulp.xyz.common.util.IMoocJSONResult;
import com.dulp.xyz.pojo.CourseComment;
import com.dulp.xyz.pojo.CourseSection;
import com.dulp.xyz.pojo.User;
import com.dulp.xyz.pojo.VO.CourseCommentVO;
import com.dulp.xyz.serivce.ICourseSectionService;
import com.dulp.xyz.serivce.impl.CourseCommentService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * 课程评论管理
 */
@Controller
@RequestMapping("/courseComment")
public class CourseCommentController {

    @Autowired
    private CourseCommentService courseCommentService;

    @Autowired
    private ICourseSectionService courseSectionService;

    /**
     * 加载评论&答疑
     * sectionId：章节id
     * courseId ：课程id
     * type : 类型
     *
     * @return
     */
    @RequestMapping("/segment")
    public IMoocJSONResult segment(@Valid CourseComment queryEntity) {
        List<CourseCommentVO> comments = courseCommentService.query(queryEntity);
        //处理用户头像
        for (CourseCommentVO item : comments) {
            if (StringUtils.isNotEmpty(item.getHeader())) {
                item.setHeader(QiniuStorage.getUrl(item.getHeader()));
            }
        }
        return IMoocJSONResult.ok(comments);
    }

    /**
     * 发表评论
     *
     * @param entity
     * @return
     */
    @RequestMapping(value = "/doComment")
    @ResponseBody
    public IMoocJSONResult doComment(@Valid CourseComment entity, User user) {

        //验证码判断
//        if (null == indeityCode ||
//                (indeityCode != null && !indeityCode.equalsIgnoreCase(SessionContext.getIdentifyCode(request)))) {
//            return new JsonView(2).toString();//验证码错误
//        }

        //文字太长
        if (entity.getContent().trim().length() > 200 || entity.getContent().trim().length() == 0) {
            return IMoocJSONResult.errorMsg("文字太长或者为空");//文字太长或者为空
        }

        if (null != entity.getRefId()) {//来自于个人中心评论
            CourseComment refComment = courseCommentService.getById(entity.getRefId());
            if (null != refComment) {
                CourseSection courseSection = courseSectionService.getById(refComment.getSectionId());
                if (null != courseSection) {
                    entity.setRefContent(refComment.getContent());
                    entity.setRefId(entity.getRefId());
                    entity.setCourseId(refComment.getCourseId());
                    entity.setSectionId(refComment.getSectionId());
                    entity.setSectionTitle(courseSection.getName());

                    entity.setToUsername(refComment.getUsername());//引用的评论的username
                    entity.setUsername(user.getUsername());
                    entity.setCreateTime(new Date());
                    entity.setCreateUser(user.getUsername());
                    entity.setUpdateTime(new Date());
                    entity.setUpdateUser(user.getUsername());

                    courseCommentService.createSelectivity(entity);
                    return IMoocJSONResult.ok();
                }
            }
        } else {
            CourseSection courseSection = courseSectionService.getById(entity.getSectionId());
            if (null != courseSection) {
                entity.setSectionTitle(courseSection.getName());
                entity.setToUsername(entity.getCreateUser());//toUsername可以作为页面入参
                entity.setUsername(user.getUsername());
                entity.setCreateTime(new Date());
                entity.setCreateUser(user.getUsername());
                entity.setUpdateTime(new Date());
                entity.setUpdateUser(user.getUsername());

                courseCommentService.createSelectivity(entity);
                return IMoocJSONResult.ok();
            }
        }
        return IMoocJSONResult.errorMsg("创建评论失败");
    }

}

