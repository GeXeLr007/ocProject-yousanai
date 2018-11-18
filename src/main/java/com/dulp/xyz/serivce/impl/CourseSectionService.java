package com.dulp.xyz.serivce.impl;

import com.dulp.xyz.mapper.TCourseSectionMapper;
import com.dulp.xyz.pojo.CourseSection;
import com.dulp.xyz.serivce.ICourseSectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseSectionService implements ICourseSectionService {
    @Autowired
    private TCourseSectionMapper tCourseSectionMapper;

    @Override
    public List<CourseSection> queryAll(CourseSection queryEntity) {
        return tCourseSectionMapper.queryAll(queryEntity);
    }

    @Override
    public CourseSection getById(Integer id) {
        return tCourseSectionMapper.getById(id);
    }
}
