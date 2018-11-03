package com.dulp.xyz.serivce;

import com.dulp.xyz.pojo.VO.ConstsClassifyVO;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public interface IPortalBusiness {
    /**
     * 获取所有分类
     */
    Map<String,ConstsClassifyVO> queryAllClassifyMap();
}
