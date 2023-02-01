package com.jing.mall.product.mapper;

import com.jing.mall.product.entity.SpuSaleAttr;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jing.mall.product.vo.SkuAttrValueVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Jing
* @description 针对表【spu_sale_attr(spu销售属性)】的数据库操作Mapper
* @createDate 2023-01-14 22:14:26
* @Entity com.jing.mall.product.entity.SpuSaleAttr
*/
public interface SpuSaleAttrMapper extends BaseMapper<SpuSaleAttr> {

    List<SpuSaleAttr> getSpuSaleAttrList(@Param("spuId") Long spuId);

    List<SpuSaleAttr> getSpuSaleAttrAndValue(@Param("spuId") Long spuId, @Param("skuId") Long skuId);

    List<SkuAttrValueVo> getSpuSaleAttrJsonStr(@Param("spuId") Long spuId);
}




