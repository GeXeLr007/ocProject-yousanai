package com.dulp.xyz.controller;

import com.dulp.xyz.common.util.IMoocJSONResult;
import com.dulp.xyz.pojo.CourseQueryDto;
import com.dulp.xyz.pojo.TCourse;
import com.dulp.xyz.serivce.TCourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value="免费课程相关业务接口",tags = {"免费课程相关业务接口controller"})
@RequestMapping("/free")
public class freeController {
    @Autowired
    private TCourseService tCourseService;
    @ApiOperation(value="免费课程推荐页面",notes = "免费课程推荐")
    @PostMapping(value = "/class")
    public IMoocJSONResult freeClass(){
        TCourse queryEntity = new TCourse();
        queryEntity.setFree(true);
        List<TCourse> actionCourseList =this.tCourseService.freeQueryList(queryEntity);
        return IMoocJSONResult.ok(actionCourseList);
    }
}
