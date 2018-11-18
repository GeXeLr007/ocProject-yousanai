package com.dulp.xyz.serivce.impl;

import com.dulp.xyz.mapper.UserCollectionsMapper;
import com.dulp.xyz.pojo.UserCollections;
import com.dulp.xyz.pojo.VO.UserCollectionsVO;
import com.dulp.xyz.serivce.IUserCollectionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCollectionsService implements IUserCollectionsService {

    @Autowired
    UserCollectionsMapper userCollectionsMapper;
    
    @Override
    public List<UserCollections> queryAll(UserCollections queryEntity) {
        return userCollectionsMapper.queryAll(queryEntity);
    }

    @Override
    public void delete(UserCollections entity) {
        userCollectionsMapper.deleteByPrimaryKey(entity.getId());
    }

    @Override
    public void createSelectivity(UserCollections entity) {
        userCollectionsMapper.insertSelective(entity);
    }

    @Override
    public List<UserCollectionsVO> queryPage(UserCollections queryEntity) {
        return userCollectionsMapper.queryPage(queryEntity);
    }
}
