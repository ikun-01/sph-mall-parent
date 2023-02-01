package com.jing.mall.product.service;

import com.jing.mall.product.entity.SkuInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jing.mall.product.vo.SkuInfoVo;

import java.math.BigDecimal;

/**
* @author Jing
* @description 针对表【sku_info(库存单元表)】的数据库操作Service
* @createDate 2023-01-14 22:14:26
*/
public interface SkuInfoService extends IService<SkuInfo> {

    /**
     * 新增skuinfo信息
     * @param skuInfoVo
     */
    void saveSkuInfo(SkuInfoVo skuInfoVo);

    /**
     * 上架商品
     * @param skuId
     */
    void onSale(Long skuId);

    /**
     * 下架商品
     * @param skuId
     */
    void cancelSale(Long skuId);


    /**
     * 获取商品的最新价格
     * @param skuId
     * @return
     */
    BigDecimal getRealPrice(Long skuId);
}
