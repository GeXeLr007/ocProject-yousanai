package com.dulp.xyz.controller;

import com.dulp.xyz.common.access.AccessLimit;
import com.dulp.xyz.common.util.IMoocJSONResult;
import com.dulp.xyz.pojo.CourseQueryDto;
import com.dulp.xyz.pojo.TAuthUser;
import com.dulp.xyz.pojo.TCourse;
import com.dulp.xyz.pojo.User;
import com.dulp.xyz.pojo.VO.CourseSectionVO;
import com.dulp.xyz.serivce.*;
import com.dulp.xyz.serivce.impl.UserCourseSectionService;
import io.swagger.annotations.Api;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "课程详情相关业务接口", tags = {"课程详情相关业务的controller"})
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private ICourseBusiness courseBusiness;

    @Autowired
    private TCourseService courseService;

    @Autowired
    private TAuthUserService authUserService;

    @Autowired
    private ICourseSectionService courseSectionService;

    @Autowired
    private UserCourseSectionService userCourseSectionService;

    /**
     * 插入或更新用户学习记录
     *
     * @return
     */
    @RequestMapping("/insertOrUpdateUserCourseSection")
    @AccessLimit
    public IMoocJSONResult insertOrUpdateUserCourseSection(User user, Integer courseId, Integer sectionId,Double currentTime) {
        Integer rate = userCourseSectionService.insertOrUpdateUserCourseSection(user, courseId, sectionId, currentTime);
        return IMoocJSONResult.ok(rate);
    }

    /**
     * 用户学习记录修改为结束
     *
     * @return
     */
    @RequestMapping("/endUserCourseSection")
    @AccessLimit
    public IMoocJSONResult endUserCourseSection(User user, Integer courseId, Integer sectionId) {
        userCourseSectionService.endUserCourseSection(user, courseId, sectionId);
        return IMoocJSONResult.ok();
    }

    /**
     * 课程章节页面
     *
     * @return
     */
    @PostMapping("/learn/{courseId}")
    public IMoocJSONResult learn(@PathVariable Integer courseId) {
        if (null == courseId) {
            return IMoocJSONResult.errorMsg("不好意思课程不存在");
        }
        TCourse tCourse = courseService.getById(courseId);
        if (null == tCourse) {
            return IMoocJSONResult.errorMsg("不好意思课程不存在");
        }
        return IMoocJSONResult.ok(tCourse);
    }

    @PostMapping("/learn/class/{courseId}")
    public IMoocJSONResult learnClass(@PathVariable Integer courseId) {
        if (null == courseId) {
            return IMoocJSONResult.errorMsg("不好意思课程不存在");
        }
        List<CourseSectionVO> chaptSections = this.courseBusiness.queryCourseSection(courseId);
        return IMoocJSONResult.ok(chaptSections);
    }

    @PostMapping("/learn/tcher/{courseId}")
    public IMoocJSONResult learnTcher(@PathVariable Integer courseId) {
        TCourse tCourse = courseService.getById(courseId);
        //获取讲师
        TAuthUser courseTeacher = this.authUserService.getByUsername(tCourse.getUsername());
        if (null != courseTeacher && StringUtils.isNotEmpty(courseTeacher.getHeader())) {
            courseTeacher.setHeader(courseTeacher.getHeader());
        }
        return IMoocJSONResult.ok(courseTeacher);
    }

    @PostMapping("/learn/classRd/{courseId}")
    public IMoocJSONResult classRd(@PathVariable Integer courseId) {
        TCourse tCourse = courseService.getById(courseId);
        CourseQueryDto queryEntity = new CourseQueryDto();
        queryEntity.descSortField("weight");
        queryEntity.setCount(4);//4门推荐课程
        queryEntity.setSubClassify(tCourse.getSubClassify());
        List<TCourse> recomdCourseList = this.courseService.queryList(queryEntity);

        return IMoocJSONResult.ok(recomdCourseList);
    }
}
