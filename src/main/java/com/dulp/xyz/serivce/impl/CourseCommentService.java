package com.dulp.xyz.serivce.impl;

import com.dulp.xyz.mapper.CourseCommentMapper;
import com.dulp.xyz.pojo.CourseComment;
import com.dulp.xyz.pojo.VO.CourseCommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseCommentService {
    @Autowired
    CourseCommentMapper courseCommentMapper;

    public List<CourseCommentVO> query(CourseComment queryEntity) {
        return courseCommentMapper.query(queryEntity);
    }

    public void createSelectivity(CourseComment entity) {
        courseCommentMapper.insertSelective(entity);
    }

    public CourseComment getById(Integer refId) {
        return courseCommentMapper.selectByPrimaryKey(refId);
    }
}
