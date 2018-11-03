package com.dulp.xyz.serivce.impl;

import com.dulp.xyz.mapper.TCourseSectionMapper;
import com.dulp.xyz.pojo.TCourseSection;
import com.dulp.xyz.pojo.VO.CourseSectionVO;
import com.dulp.xyz.serivce.ICourseSectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ICourseSectionServiceImpl implements ICourseSectionService {
    @Autowired
    private TCourseSectionMapper tCourseSectionMapper;

    @Override
    public List<TCourseSection> queryAll(TCourseSection queryEntity) {
        return tCourseSectionMapper.queryAll(queryEntity);
    }

    @Override
    public TCourseSection getById(Integer id) {
        return tCourseSectionMapper.getById(id);
    }
}
