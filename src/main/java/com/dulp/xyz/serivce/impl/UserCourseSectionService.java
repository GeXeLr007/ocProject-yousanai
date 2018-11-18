package com.dulp.xyz.serivce.impl;

import com.dulp.xyz.common.enums.CourseEnum;
import com.dulp.xyz.mapper.UserCourseSectionMapper;
import com.dulp.xyz.pojo.User;
import com.dulp.xyz.pojo.UserCourseSection;
import com.dulp.xyz.pojo.VO.UserCourseSectionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCourseSectionService {
    @Autowired
    UserCourseSectionMapper userCourseSectionMapper;

    public List<UserCourseSectionVO> selectVOByUserId(UserCourseSection queryEntity) {
        List<UserCourseSectionVO> items = userCourseSectionMapper.selectVOByUserId(queryEntity);
        return items;
    }

    public Integer insertOrUpdateUserCourseSection(User user, Integer courseId, Integer sectionId, Double currentTime) {
        UserCourseSection userCourseSection = userCourseSectionMapper.selectByUserIdAndOtherId(user.getId(), courseId, sectionId);
        if (userCourseSection != null) {
            if (currentTime != null) {
                userCourseSection.setRate(currentTime.intValue());
                userCourseSectionMapper.updateByPrimaryKeySelective(userCourseSection);
            }
        } else {
            userCourseSection = new UserCourseSection();
            userCourseSection.setUserId(user.getId());
            userCourseSection.setCourseId(courseId);
            userCourseSection.setSectionId(sectionId);
            userCourseSectionMapper.insertSelective(userCourseSection);
        }
        return userCourseSection.getRate();
    }

    public void endUserCourseSection(User user, Integer courseId, Integer sectionId) {
        UserCourseSection userCourseSection = userCourseSectionMapper.selectByUserIdAndOtherId(user.getId(), courseId, sectionId);
        userCourseSection.setStatus(CourseEnum.SECTION_END.value());
        userCourseSectionMapper.updateByPrimaryKeySelective(userCourseSection);
    }
}
