package com.jing.mall.item.vo;

import com.jing.mall.product.entity.SkuInfo;
import com.jing.mall.product.entity.SpuSaleAttr;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 商品详情页面数据Vo
 */
@Data
public class SkuDetailVo {
    /**
     * 商品所属的分类信息
     */
    private CategoryView categoryView;

    /**
     * 商品的基本信息 默认图片等
     */
    private SkuInfo skuInfo;

    /**
     * 商品对应的价格
     */
    private BigDecimal price;


    /**
     * sku对应的spu销售属性列表
     */
    private List<SpuSaleAttr> spuSaleAttrList;


    /**
     * json 字符串
     */
    private String valuesSkuJson;


}
