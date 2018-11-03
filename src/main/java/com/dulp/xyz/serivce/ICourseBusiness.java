package com.dulp.xyz.serivce;

import com.dulp.xyz.pojo.VO.CourseSectionVO;

import java.util.List;

public interface ICourseBusiness {
    /**
     * 获取课程章节
     */
    List<CourseSectionVO> queryCourseSection(Integer courseId);
}
