package com.dulp.xyz.serivce;

import com.dulp.xyz.pojo.TConstsClassify;

import java.util.List;

public interface IConstsClassifyService {
    /**
     *获取所有
     **/
    public List<TConstsClassify> queryAll();
    /**
     * 根据code获取
     */
    public TConstsClassify getByCode(String code);
}
