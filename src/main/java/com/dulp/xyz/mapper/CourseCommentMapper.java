package com.dulp.xyz.mapper;

import com.dulp.xyz.pojo.CourseComment;
import com.dulp.xyz.pojo.VO.CourseCommentVO;

import java.util.List;

public interface CourseCommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CourseComment record);

    int insertSelective(CourseComment record);

    CourseComment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CourseComment record);

    int updateByPrimaryKey(CourseComment record);

    List<CourseCommentVO> query(CourseComment record);
}