package com.dulp.xyz.controller;


import com.dulp.xyz.common.access.AccessLimit;
import com.dulp.xyz.common.util.IMoocJSONResult;
import com.dulp.xyz.pojo.CourseQueryDto;
import com.dulp.xyz.pojo.TAuthUser;
import com.dulp.xyz.pojo.TConstsSiteCarousel;
import com.dulp.xyz.pojo.TCourse;
import com.dulp.xyz.serivce.TAuthUserService;
import com.dulp.xyz.serivce.TConstsSiteCarouselService;
import com.dulp.xyz.serivce.TCourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value="首页相关业务接口",tags = {"首页相关业务的controller"})
@RequestMapping("/index")
public class PoralController {
    @Autowired
    TConstsSiteCarouselService constsSiteCarouselService;
    @Autowired
    private TCourseService tCourseService;
    @Autowired
    private TAuthUserService tAuthUserService;


    @ApiOperation(value = "轮播区接口接口",notes = "轮播区接口的接口")
    @PostMapping(value = "/info")
    @AccessLimit(needLogin = true)
    public IMoocJSONResult info(Integer count){
        List<TConstsSiteCarousel> carouselList =constsSiteCarouselService.queryCarousels();

        return IMoocJSONResult.ok(carouselList);
    }
    @ApiOperation(value="免费课程推荐页面",notes = "免费课程推荐")
    @PostMapping(value = "/free")
    public IMoocJSONResult freeClass(){
        //获取5门实战课推荐，根据权重（weight）进行排序
        CourseQueryDto queryEntity = new CourseQueryDto();
        queryEntity.setCount(4);//4门
        queryEntity.setFree(true);
        queryEntity.descSortField("weight");//按照weight降序排列
        List<TCourse> actionCourseList =this.tCourseService.queryList(queryEntity);
        return IMoocJSONResult.ok(actionCourseList);
    }
    @ApiOperation(value="实战课程推荐页面",notes = "实战课程推荐")
    @PostMapping(value = "/actual")
    public IMoocJSONResult actualClass(){
        //获取5门实战课推荐，根据权重（weight）进行排序
        CourseQueryDto queryEntity = new CourseQueryDto();
        queryEntity.setCount(4);//4门
        queryEntity.setFree(false);
        queryEntity.descSortField("weight");//按照weight降序排列
        List<TCourse> actionCourseList =this.tCourseService.queryList(queryEntity);
        return IMoocJSONResult.ok(actionCourseList);
    }

    @ApiOperation(value = "名师推荐页面",notes = "名师推荐页面")
    @PostMapping(value = "RTchrList")
    public IMoocJSONResult RTchrList(){
        List<TAuthUser> recomdTeacherList = tAuthUserService.queryRecomd();

        return IMoocJSONResult.ok(recomdTeacherList);
    }
}
