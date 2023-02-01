package com.jing.mall.feignclients.product;

import com.jing.mall.common.result.Result;
import com.jing.mall.item.vo.CategoryView;
import com.jing.mall.product.entity.SkuImage;
import com.jing.mall.product.entity.SkuInfo;
import com.jing.mall.product.entity.SpuSaleAttr;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.List;

@FeignClient("service-product")
@RequestMapping("/api/inner/rpc/product")
public interface SkuFeignClient {
    /**
     * 获取对应skuId的商品的所属分类信息
     * @param category3Id
     * @return
     */
    @GetMapping("/skuInfo/categoryView/{category3Id}")
    Result<CategoryView> getCategoryView(@PathVariable("category3Id") Long category3Id);

    /**
     * 获取 商品的详细信息
     * @param skuId
     * @return
     */
    @GetMapping("/skuInfo/getSkuInfo/{skuId}")
    Result<SkuInfo> getSkuInfo(@PathVariable("skuId") Long skuId);

    /**
     * 获取商品的实时价格
     * @param skuId
     * @return
     */
    @GetMapping("/skuInfo/getRealPrice/{skuId}")
    Result<BigDecimal> getRealPrice(@PathVariable("skuId") Long skuId);

    /**
     * 获取商品的 spu 销售属性列表和所有的值
     * @param spuId
     * @param skuId
     * @return
     */
    @GetMapping("/skuInfo/getSpuSaleAttrAndValue/{spuId}/{skuId}")
    Result<List<SpuSaleAttr>> getSpuSaleAttrAndValue(@PathVariable("spuId") Long spuId,
                                                     @PathVariable("skuId") Long skuId);

    /**
     * 获取商品对应的所有的图片列表信息
     * @param skuId
     * @return
     */
    @GetMapping("/skuInfo/getSkuImages/{skuId}")
    Result<List<SkuImage>> getSkuImages(@PathVariable("skuId") Long skuId);

    /**
     * 获取该商品对应的同一个spu下的所有sku的组合
     * @param spuId
     * @return
     */
    @GetMapping("/skuInfo/getSpuAttrJsonStr/{spuId}")
    Result<String> getSpuAttrJsonStr(@PathVariable("spuId") Long spuId);
}
