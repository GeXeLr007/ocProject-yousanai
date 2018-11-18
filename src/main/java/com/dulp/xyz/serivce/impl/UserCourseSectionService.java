package com.dulp.xyz.serivce.impl;

import com.dulp.xyz.mapper.UserCourseSectionMapper;
import com.dulp.xyz.pojo.UserCourseSection;
import com.dulp.xyz.pojo.VO.UserCourseSectionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCourseSectionService {
    @Autowired
    UserCourseSectionMapper userCourseSectionMapper;
    
    public List<UserCourseSectionVO> queryPage(UserCourseSection queryEntity){
        List<UserCourseSectionVO> items = userCourseSectionMapper.queryPage(queryEntity);
        return items;
    }
    
}
