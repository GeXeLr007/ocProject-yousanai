package com.dulp.xyz.serivce.impl;

import com.dulp.xyz.common.util.TailPage;
import com.dulp.xyz.mapper.TCourseCommentMapper;
import com.dulp.xyz.pojo.TCourseComment;
import com.dulp.xyz.serivce.TCourseCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
@Service
public class TCourseCommentServiceImpl implements TCourseCommentService {
    @Autowired
    TCourseCommentMapper entityDao;

    @Override
    public List<TCourseComment> queryAll(TCourseComment queryEntity){
        return entityDao.queryAll(queryEntity);
    }

    @Override
    public TailPage<TCourseComment> queryPage(TCourseComment queryEntity, TailPage<TCourseComment> page) {
        Integer itemsTotalCount = entityDao.getTotalItemsCount(queryEntity);
        TailPage<TCourseComment> items = entityDao.queryPage(queryEntity,page);
        page.setItemsTotalCount(itemsTotalCount);
        page.setItems((Collection<TCourseComment>) items);
        return page;
    }
}
