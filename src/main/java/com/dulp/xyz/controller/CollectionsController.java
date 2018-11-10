package com.dulp.xyz.controller;

import com.dulp.xyz.common.access.AccessLimit;
import com.dulp.xyz.common.enums.CourseEnum;
import com.dulp.xyz.common.util.IMoocJSONResult;
import com.dulp.xyz.pojo.User;
import com.dulp.xyz.pojo.UserCollections;
import com.dulp.xyz.serivce.IUserCollectionsService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * 用户收藏
 */
@RestController
@RequestMapping("/collections")
public class CollectionsController{

    @Autowired
    private IUserCollectionsService userCollectionsService;

    @RequestMapping(value = "/doCollection")
    @AccessLimit
    public IMoocJSONResult doCollection(Integer courseId, User user){
        //获取当前用户
        String curUserId = user.getId();
        UserCollections userCollections = new UserCollections();

        userCollections.setUserId(curUserId);
        userCollections.setObjectId(courseId);
        List<UserCollections> list = userCollectionsService.queryAll(userCollections);

        if(CollectionUtils.isNotEmpty(list)){
            userCollectionsService.delete(list.get(0));
            return IMoocJSONResult.ok(CourseEnum.COLLECTION_NO.value());
        }else{
            userCollections.setCreateTime(new Date());
            userCollectionsService.createSelectivity(userCollections);
            return IMoocJSONResult.ok(CourseEnum.COLLECTION_YES.value());//已经收藏
        }
    }

    /**
     * 是否已经收藏
     * @param courseId
     * @return
     */
    @RequestMapping(value = "/isCollection")
    @AccessLimit
    public IMoocJSONResult isCollection(Integer courseId, User user){
        //获取当前用户
        String curUserId = user.getId();
        UserCollections userCollections = new UserCollections();

        userCollections.setUserId(curUserId);
        userCollections.setObjectId(courseId);
        List<UserCollections> list = userCollectionsService.queryAll(userCollections);

        if(CollectionUtils.isNotEmpty(list)){//已经收藏
            return IMoocJSONResult.ok(CourseEnum.COLLECTION_YES.value());
        }else{
            return IMoocJSONResult.ok(CourseEnum.COLLECTION_NO.value());
        }
    }

}
