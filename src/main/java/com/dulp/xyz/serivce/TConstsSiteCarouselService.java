package com.dulp.xyz.serivce;

import com.dulp.xyz.common.util.TailPage;
import com.dulp.xyz.pojo.TConstsSiteCarousel;

import java.util.List;

public interface TConstsSiteCarouselService {
    /**
     *获取所有
     **/
    public List<TConstsSiteCarousel> queryCarousels();

}
