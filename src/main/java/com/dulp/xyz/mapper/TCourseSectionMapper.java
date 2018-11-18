package com.dulp.xyz.mapper;

import com.dulp.xyz.pojo.CourseSection;
import com.dulp.xyz.utils.MyMapper;

import java.util.List;

public interface TCourseSectionMapper extends MyMapper<CourseSection> {
    List<CourseSection> queryAll(CourseSection queryEntity);
    /**
     *根据id获取
     **/
    public CourseSection getById(Integer id);
}