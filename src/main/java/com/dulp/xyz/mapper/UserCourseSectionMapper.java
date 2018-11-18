package com.dulp.xyz.mapper;

import com.dulp.xyz.pojo.UserCourseSection;
import com.dulp.xyz.pojo.VO.UserCourseSectionVO;

import java.util.List;

public interface UserCourseSectionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserCourseSection record);

    int insertSelective(UserCourseSection record);

    UserCourseSection selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserCourseSection record);

    int updateByPrimaryKey(UserCourseSection record);
    
    List<UserCourseSectionVO> queryPage(UserCourseSection record);
}