package com.dulp.xyz.mapper;

import com.dulp.xyz.pojo.TCourseSection;
import com.dulp.xyz.utils.MyMapper;

import java.util.List;

public interface TCourseSectionMapper extends MyMapper<TCourseSection> {
    List<TCourseSection> queryAll(TCourseSection queryEntity);
    /**
     *根据id获取
     **/
    public TCourseSection getById(Integer id);
}