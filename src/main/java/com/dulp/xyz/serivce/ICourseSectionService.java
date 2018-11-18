package com.dulp.xyz.serivce;

import com.dulp.xyz.pojo.CourseSection;

import java.util.List;

public interface ICourseSectionService {
    /**
     *获取所有
     **/
    public List<CourseSection> queryAll(CourseSection queryEntity);
    /**
     *根据id获取
     **/
    public CourseSection getById(Integer id);
}
