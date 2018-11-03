package com.dulp.xyz.mapper;

import com.dulp.xyz.pojo.CourseQueryDto;
import com.dulp.xyz.pojo.TCourse;
import com.dulp.xyz.utils.MyMapper;

import java.util.List;

public interface TCourseMapper extends MyMapper<TCourse> {
    /**
     *根据条件获取所有，
     *queryEntity：查询条件；
     **//**
     *根据id获取
     **/
    public TCourse getById(Integer id);
    public List<TCourse> queryList(CourseQueryDto queryEntity);
    public List<TCourse> freeQueryList(TCourse queryEntity);
    public List<TCourse> actualQueryList(CourseQueryDto queryEntity);
}