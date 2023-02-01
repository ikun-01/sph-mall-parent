package com.jing.mall.item.service.impl;

import com.jing.mall.feignclients.product.SkuFeignClient;
import com.jing.mall.item.service.SkuDetailService;
import com.jing.mall.item.vo.CategoryView;
import com.jing.mall.item.vo.SkuDetailVo;
import com.jing.mall.product.entity.SkuImage;
import com.jing.mall.product.entity.SkuInfo;
import com.jing.mall.product.entity.SpuSaleAttr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SkuDetailServiceImpl implements SkuDetailService {


    @Autowired
    private SkuFeignClient skuFeignClient;

    @Override
    public SkuDetailVo getSkuDetail(Long skuId) {
        SkuDetailVo skuDetailVo = new SkuDetailVo();
        // 获取商品的SkuInfo信息   包含对应的所有图片列表
        SkuInfo skuInfo = skuFeignClient.getSkuInfo(skuId).getData();
        skuDetailVo.setSkuInfo(skuInfo);
        // 获取商品对应的图片列表
        List<SkuImage> skuImages = skuFeignClient.getSkuImages(skuId).getData();
        skuInfo.setSkuImageList(skuImages);
        // 获取商品对应的分类信息
        CategoryView categoryView = skuFeignClient.getCategoryView(skuInfo.getCategory3Id()).getData();
        skuDetailVo.setCategoryView(categoryView);
        // 获取商品的实时价格
        BigDecimal realPrice = skuFeignClient.getRealPrice(skuId).getData();
        skuDetailVo.setPrice(realPrice);
        // 获取商品的对应spu销售属性列表
        List<SpuSaleAttr> spuSaleAttrList = skuFeignClient.getSpuSaleAttrAndValue(skuInfo.getSpuId(), skuId).getData();
        skuDetailVo.setSpuSaleAttrList(spuSaleAttrList);
        // 获取商品对应的 字符串
        String json = skuFeignClient.getSpuAttrJsonStr(skuInfo.getSpuId()).getData();
        skuDetailVo.setValuesSkuJson(json);
        return skuDetailVo;
    }
}
