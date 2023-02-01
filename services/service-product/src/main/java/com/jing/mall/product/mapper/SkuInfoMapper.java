package com.jing.mall.product.mapper;

import com.jing.mall.product.entity.SkuInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
* @author Jing
* @description 针对表【sku_info(库存单元表)】的数据库操作Mapper
* @createDate 2023-01-14 22:14:26
* @Entity com.jing.mall.product.entity.SkuInfo
*/
public interface SkuInfoMapper extends BaseMapper<SkuInfo> {

    BigDecimal getRealPrice(@Param("skuId") Long skuId);
}




