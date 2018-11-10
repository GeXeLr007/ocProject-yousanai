package com.dulp.xyz.mapper;

import com.dulp.xyz.pojo.UserCollections;
import com.dulp.xyz.pojo.VO.UserCollectionsVo;

import java.util.List;

public interface UserCollectionsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserCollections record);

    int insertSelective(UserCollections record);

    UserCollections selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserCollections record);

    int updateByPrimaryKey(UserCollections record);

    List<UserCollections> queryAll(UserCollections queryEntity);

    List<UserCollectionsVo> queryPage(UserCollections queryEntity);
}