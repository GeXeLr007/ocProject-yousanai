package com.dulp.xyz.mapper;

import com.dulp.xyz.pojo.TConstsClassify;
import com.dulp.xyz.pojo.TConstsCollege;
import com.dulp.xyz.utils.MyMapper;

import java.util.List;

public interface TConstsClassifyMapper extends MyMapper<TConstsClassify> {
    /**
     *获取所有
     **/
    public List<TConstsClassify> queryAll();
    /**
     * 根据条件动态获取
     * @param queryEntity
     * @return
     */
    public List<TConstsClassify> queryByCondition(TConstsClassify queryEntity);
}