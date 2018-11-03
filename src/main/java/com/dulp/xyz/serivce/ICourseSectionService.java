package com.dulp.xyz.serivce;

import com.dulp.xyz.pojo.TCourseSection;
import com.sun.xml.internal.xsom.XSComponent;
import com.sun.xml.internal.xsom.impl.scd.Axis;

import java.util.List;

public interface ICourseSectionService {
    /**
     *获取所有
     **/
    public List<TCourseSection> queryAll(TCourseSection queryEntity);
    /**
     *根据id获取
     **/
    public TCourseSection getById(Integer id);
}
