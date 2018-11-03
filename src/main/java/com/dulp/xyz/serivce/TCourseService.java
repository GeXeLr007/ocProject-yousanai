package com.dulp.xyz.serivce;

import com.dulp.xyz.pojo.CourseQueryDto;
import com.dulp.xyz.pojo.TCourse;

import java.util.List;

public interface TCourseService {
    /**
     *根据id获取
     **/
    public TCourse getById(Integer id);

    /**
     *获取所有
     **/
    public List<TCourse> queryList(CourseQueryDto queryEntity);
    /**
     *获取免费
     **/
    public List<TCourse> freeQueryList(TCourse queryEntity);
    /**
     *获取实战
     **/
    public List<TCourse> actualQueryList(CourseQueryDto queryEntity);
}
