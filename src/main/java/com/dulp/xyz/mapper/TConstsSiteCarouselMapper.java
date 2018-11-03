package com.dulp.xyz.mapper;

import com.dulp.xyz.pojo.TConstsSiteCarousel;
import com.dulp.xyz.utils.MyMapper;

import java.util.List;

public interface TConstsSiteCarouselMapper extends MyMapper<TConstsSiteCarousel> {
    /**
     * 获取轮播
     */
    public List<TConstsSiteCarousel> queryCarousels();
}