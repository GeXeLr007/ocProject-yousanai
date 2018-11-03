package com.dulp.xyz.serivce.impl;

import com.dulp.xyz.common.storage.QiniuStorage;
import com.dulp.xyz.mapper.TCourseMapper;
import com.dulp.xyz.pojo.CourseQueryDto;
import com.dulp.xyz.pojo.TCourse;
import com.dulp.xyz.serivce.TCourseService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TCourseServiceImpl implements TCourseService {
    @Autowired
    private TCourseMapper tCourseMapper;

    @Override
    public TCourse getById(Integer id){
        TCourse course = tCourseMapper.getById(id);
        prepareCoursePicture(course);
        return course;
    }
    @Override
    public List<TCourse> queryList(CourseQueryDto queryEntity) {

        return tCourseMapper.queryList(queryEntity);
    }

    @Override
    public List<TCourse> freeQueryList(TCourse queryEntity) {
        if(null==queryEntity.getOnsale()){
            queryEntity.setOnsale(false);
        }
        return tCourseMapper.freeQueryList(queryEntity);
    }

    @Override
    public List<TCourse> actualQueryList(CourseQueryDto queryEntity) {
        return tCourseMapper.actualQueryList(queryEntity);
    }
    private void prepareCoursePicture(TCourse course){
        if(null != course && StringUtils.isNotEmpty(course.getPicture())){
            course.setPicture(QiniuStorage.getUrl(course.getPicture()));
        }
    }
}
