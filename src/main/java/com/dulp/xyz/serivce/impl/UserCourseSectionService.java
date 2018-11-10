package com.dulp.xyz.serivce.impl;

import com.dulp.xyz.mapper.UserCourseSectionMapper;
import com.dulp.xyz.pojo.UserCollections;
import com.dulp.xyz.pojo.UserCourseSection;
import com.dulp.xyz.pojo.VO.UserCourseSectionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCourseSectionService {
    @Autowired
    UserCourseSectionMapper userCourseSectionMapper;
    
    public List<UserCourseSectionVo> queryPage(UserCourseSection queryEntity){
        List<UserCourseSectionVo> items = userCourseSectionMapper.queryPage(queryEntity);
        return items;
    }
    
}
