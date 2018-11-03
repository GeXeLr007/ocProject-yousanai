package com.dulp.xyz.controller;


import com.dulp.xyz.common.util.IMoocJSONResult;
import com.dulp.xyz.common.util.TailPage;
import com.dulp.xyz.pojo.TCourseComment;
import com.dulp.xyz.serivce.TCourseCommentService;
import io.swagger.annotations.Api;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value="课程评论相关业务接口",tags = {"课程评论相关业务的controller"})
@RequestMapping("/courseComment")
public class CourseCommentController {
    @Autowired
    private TCourseCommentService courseCommentService;

    /**
     * 加载评论&答疑
     * sectionId：章节id
     * courseId ：课程id
     * type : 类型
     * @return
     */
    @PostMapping("/segment")
    public IMoocJSONResult segment(TCourseComment queryEntity , TailPage<TCourseComment> page){
        if(null == queryEntity.getCourseId() || queryEntity.getType() == null){
            return IMoocJSONResult.errorMsg("不好意思不存在此评论");
        }

        TailPage<TCourseComment> commentPage = this.courseCommentService.queryPage(queryEntity, page);

        //处理用户头像
        for(TCourseComment item : commentPage.getItems()){
            if(StringUtils.isNotEmpty(item.getHeader())){
                item.setHeader(item.getHeader());
            }
        }

       return IMoocJSONResult.ok(commentPage);
    }

}
