package com.dulp.xyz.serivce;

import com.dulp.xyz.common.util.TailPage;
import com.dulp.xyz.pojo.TCourseComment;

import java.util.List;

public interface TCourseCommentService {
    /**
     *分页获取
     **/
    public TailPage<TCourseComment> queryPage(TCourseComment queryEntity , TailPage<TCourseComment> page);
    /**
     *获取所有
     **/
    public List<TCourseComment> queryAll(TCourseComment queryEntity);
}
