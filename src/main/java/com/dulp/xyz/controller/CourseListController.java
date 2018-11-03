package com.dulp.xyz.controller;


import com.dulp.xyz.common.util.IMoocJSONResult;
import com.dulp.xyz.common.util.TailPage;
import com.dulp.xyz.pojo.CourseQueryDto;
import com.dulp.xyz.pojo.TConstsClassify;
import com.dulp.xyz.pojo.TCourse;
import com.dulp.xyz.pojo.VO.ConstsClassifyVO;
import com.dulp.xyz.serivce.IConstsClassifyService;
import com.dulp.xyz.serivce.IPortalBusiness;
import com.dulp.xyz.serivce.TCourseService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
//需要修改
@RestController
@Api(value="课程分类相关业务接口",tags = {"课程分类相关业务的controller"})
@RequestMapping("/courseList")
public class CourseListController {
    @Autowired
    private IConstsClassifyService constsClassifyService;

    @Autowired
    private IPortalBusiness portalBusiness;

    @Autowired
    private TCourseService courseService;
    String curCode = "-1";//当前方向code
    String curSubCode = "-2";//当前分类code



    @PostMapping("/listOne")
    public IMoocJSONResult listOne(){
        //所有一级分类
        List<ConstsClassifyVO> classifysList = new ArrayList<ConstsClassifyVO>();
        Map<String,ConstsClassifyVO> classifyVOMap= portalBusiness.queryAllClassifyMap();
        for(ConstsClassifyVO vo:classifyVOMap.values()){
            classifysList.add(vo);
        }
        return IMoocJSONResult.ok(classifysList);
    }
    @PostMapping("/listTwo")
    public IMoocJSONResult listTwo(String c, String sort, TailPage<TCourse> page){





        //当前分类
        TConstsClassify curClassify = constsClassifyService.getByCode(c);
        Map<String,ConstsClassifyVO> classifyVOMap= portalBusiness.queryAllClassifyMap();
        if(null==curClassify){
            //没有此分类
            List<TConstsClassify> subClassifys = new ArrayList<TConstsClassify>();
            for(ConstsClassifyVO vo : classifyVOMap.values()){
                subClassifys.addAll(vo.getSubClassifyList());
            }
            IMoocJSONResult.ok(subClassifys);
        }else {
            if(!"0".endsWith(curClassify.getParentCode())){//当前是二级分类
                curSubCode = curClassify.getCode();
                curCode = curClassify.getParentCode();
               Object  object = classifyVOMap.get(curClassify.getParentCode()).getSubClassifyList();
                IMoocJSONResult.ok(object);//此分类平级的二级分类
            }else{//当前是一级分类
                curCode = curClassify.getCode();
                Object  object = classifyVOMap.get(curClassify.getCode()).getSubClassifyList();
               IMoocJSONResult.ok(object);
            }

        }

        CourseQueryDto queryEntity;
        queryEntity = new CourseQueryDto();
        if(!"-1".equals(curCode)){
            queryEntity.setClassify(curCode);
        }
        if(!"-2".equals(curSubCode)){
            queryEntity.setSubClassify(curSubCode);
        }
        List<TCourse> actionCourseList =this.courseService.queryList(queryEntity);
        return  IMoocJSONResult.ok(actionCourseList);


    }
}
