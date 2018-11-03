package com.dulp.xyz.serivce.impl;


import com.dulp.xyz.common.storage.QiniuStorage;
import com.dulp.xyz.common.util.TailPage;
import com.dulp.xyz.mapper.TConstsSiteCarouselMapper;
import com.dulp.xyz.pojo.TConstsSiteCarousel;
import com.dulp.xyz.serivce.TConstsSiteCarouselService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TConstsSiteCarouselServiceImpl implements TConstsSiteCarouselService {

	@Autowired
	private TConstsSiteCarouselMapper entityDao;


	@Override
	public List<TConstsSiteCarousel> queryCarousels() {
		List<TConstsSiteCarousel> resultList = entityDao.queryCarousels();
		//处理为七牛图片链接
		for(TConstsSiteCarousel item : resultList){
			item.setPicture(QiniuStorage.getUrl(item.getPicture()));
		}
		return resultList;
	}
}

