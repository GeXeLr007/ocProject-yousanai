package com.dulp.xyz.serivce.impl;

import com.dulp.xyz.common.enums.CourseEnum;
import com.dulp.xyz.mapper.UserCourseSectionMapper;
import com.dulp.xyz.pojo.User;
import com.dulp.xyz.pojo.UserCourseSection;
import com.dulp.xyz.pojo.VO.UserCourseSectionVO;
import com.dulp.xyz.serivce.ICourseSectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class UserCourseSectionService {
    @Autowired
    UserCourseSectionMapper userCourseSectionMapper;

    @Autowired
    ICourseSectionService courseSectionService;

    public List<UserCourseSectionVO> selectVOByUserId(UserCourseSection queryEntity) {
        List<UserCourseSectionVO> items = userCourseSectionMapper.selectVOByUserId(queryEntity);
        HashMap<Integer, UserCourseSectionVO> map = new HashMap<>();
        HashMap<Integer, Integer> curSectionCount = new HashMap<>();
        //统计每个课程已经学习的小节数目
        for (UserCourseSectionVO item :
                items) {
            if (!curSectionCount.containsKey(item.getCourseId())) {
                curSectionCount.put(item.getCourseId(), 0);
                if (item.getStatus().equals(CourseEnum.SECTION_END.value())) {
                    curSectionCount.put(item.getCourseId(), curSectionCount.get(item.getCourseId()) + 1);
                }
            } else {
                if (item.getStatus().equals(CourseEnum.SECTION_END.value())) {
                    curSectionCount.put(item.getCourseId(), curSectionCount.get(item.getCourseId()) + 1);
                }
            }
        }
        //构造每个课程只有最新的小节存在于list中
        for (UserCourseSectionVO item :
                items) {
            if (!map.containsKey(item.getCourseId())) {
                map.put(item.getCourseId(), item);
                Integer sectionCount = courseSectionService.selectCountByCourseId(item.getCourseId());
                item.setStudyPercent((int) ((curSectionCount.get(item.getCourseId()).doubleValue() / sectionCount.doubleValue()) * 100));
            }
        }
        Collection<UserCourseSectionVO> values = map.values();
        items.clear();
        items.addAll(values);
        return items;
    }

    public Integer insertOrUpdateUserCourseSection(User user, Integer courseId, Integer sectionId, Double currentTime) {
        UserCourseSection userCourseSection = userCourseSectionMapper.selectByUserIdAndOtherId(user.getId(), courseId, sectionId);
        if (userCourseSection != null) {
            if (currentTime != null) {
                userCourseSection.setRate(currentTime.intValue());
                userCourseSection.setUpdateTime(new Date());
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
