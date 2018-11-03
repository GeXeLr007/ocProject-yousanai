package com.dulp.xyz.mapper;

import com.dulp.xyz.common.util.TailPage;
import com.dulp.xyz.pojo.TCourseComment;
import com.dulp.xyz.utils.MyMapper;

import java.util.List;

public interface TCourseCommentMapper extends MyMapper<TCourseComment> {
    /**
     *分页获取
     **/
    public TailPage<TCourseComment> queryPage(TCourseComment queryEntity , TailPage<TCourseComment> page);
    /**
     *获取所有
     **/
    public List<TCourseComment> queryAll(TCourseComment queryEntity);
    /**
     *获取总数量
     **/
    public Integer getTotalItemsCount(TCourseComment queryEntity);
}