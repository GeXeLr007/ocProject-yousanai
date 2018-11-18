package com.dulp.xyz.mapper;

import com.dulp.xyz.pojo.UserCourseSection;
import com.dulp.xyz.pojo.VO.UserCourseSectionVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserCourseSectionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserCourseSection record);

    int insertSelective(UserCourseSection record);

    UserCourseSection selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserCourseSection record);

    int updateByPrimaryKey(UserCourseSection record);

    List<UserCourseSectionVO> selectVOByUserId(UserCourseSection record);

    UserCourseSection selectByUserIdAndOtherId(@Param("userId") String userId, @Param("courseId") Integer courseId, @Param("sectionId") Integer sectionId);
}