package com.dulp.xyz.serivce;

import com.dulp.xyz.pojo.UserCollections;
import com.dulp.xyz.pojo.VO.UserCollectionsVO;

import java.util.List;

public interface IUserCollectionsService {

    List<UserCollections> queryAll(UserCollections queryEntity);

    void delete(UserCollections entity);

    void createSelectivity(UserCollections entity);

    List<UserCollectionsVO> queryPage(UserCollections queryEntity);
}
