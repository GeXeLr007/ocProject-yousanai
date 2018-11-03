package com.dulp.xyz.serivce.impl;

import com.dulp.xyz.pojo.CourseQueryDto;
import com.dulp.xyz.pojo.TCourseSection;
import com.dulp.xyz.pojo.VO.CourseSectionVO;
import com.dulp.xyz.serivce.ICourseBusiness;
import com.dulp.xyz.serivce.ICourseSectionService;
import io.swagger.models.auth.In;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ICourseBusinessImpl implements ICourseBusiness {
    @Autowired
    private ICourseSectionService courseSectionService;


    @Override
    public List<CourseSectionVO> queryCourseSection(Integer courseId) {
        List<CourseSectionVO> resultList = new ArrayList<CourseSectionVO>();
        TCourseSection queryEntity = new TCourseSection();
        queryEntity.setCourseId(courseId);
        queryEntity.setOnsale(true);
        Map<Integer,CourseSectionVO> tmpMap = new LinkedHashMap<Integer, CourseSectionVO>();
        Iterator<TCourseSection> it = courseSectionService.queryAll(queryEntity).iterator();
        while(it.hasNext()){
            TCourseSection item = it.next();
            if(Integer.valueOf(0).equals(item.getParentId())){//章
                CourseSectionVO vo = new CourseSectionVO();
                BeanUtils.copyProperties(item, vo);
                tmpMap.put(vo.getId(), vo);
            }else{
                tmpMap.get(item.getParentId()).getSections().add(item);//小节添加到大章中
            }
        }
        for(CourseSectionVO vo : tmpMap.values()){
            resultList.add(vo);
        }
        return resultList;
    }
}
