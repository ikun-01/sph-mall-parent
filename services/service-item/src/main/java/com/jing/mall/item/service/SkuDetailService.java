package com.jing.mall.item.service;

import com.jing.mall.item.vo.SkuDetailVo;

public interface SkuDetailService {
    /**
     * 获取商品详情页面的信息
     * @param skuId
     * @return
     */
    SkuDetailVo getSkuDetail(Long skuId);
}
