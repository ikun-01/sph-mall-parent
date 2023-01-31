package com.jing.mall.product.service;

import com.jing.mall.product.entity.SpuSaleAttr;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Jing
* @description 针对表【spu_sale_attr(spu销售属性)】的数据库操作Service
* @createDate 2023-01-14 22:14:26
*/
public interface SpuSaleAttrService extends IService<SpuSaleAttr> {

    /**
     * 获取对应spuId的销售属性列表
     * @param spuId
     * @return
     */
    List<SpuSaleAttr> getSpuSaleAttrList(Long spuId);
}
