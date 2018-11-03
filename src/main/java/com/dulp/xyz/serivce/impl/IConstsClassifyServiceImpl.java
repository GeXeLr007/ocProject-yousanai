package com.dulp.xyz.serivce.impl;

import com.dulp.xyz.mapper.TConstsClassifyMapper;
import com.dulp.xyz.pojo.TConstsClassify;
import com.dulp.xyz.serivce.IConstsClassifyService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IConstsClassifyServiceImpl implements IConstsClassifyService {
    @Autowired
    private TConstsClassifyMapper tConstsClassifyMapper;

    @Override
    public List<TConstsClassify> queryAll() {

        return tConstsClassifyMapper.queryAll();
    }

    @Override
    public TConstsClassify getByCode(String code) {
        if(StringUtils.isEmpty(code))
            return null;
        TConstsClassify queryEntity = new TConstsClassify();
        queryEntity.setCode(code);
        List<TConstsClassify> list = tConstsClassifyMapper.queryByCondition(queryEntity);
        if(CollectionUtils.isNotEmpty(list))
            return list.get(0);
        return null;
    }
}
