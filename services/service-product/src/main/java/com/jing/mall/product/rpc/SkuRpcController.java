package com.jing.mall.product.rpc;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jing.mall.common.result.Result;
import com.jing.mall.item.vo.CategoryView;
import com.jing.mall.product.entity.SkuImage;
import com.jing.mall.product.entity.SkuInfo;
import com.jing.mall.product.entity.SpuSaleAttr;
import com.jing.mall.product.service.BaseCategory1Service;
import com.jing.mall.product.service.SkuImageService;
import com.jing.mall.product.service.SkuInfoService;
import com.jing.mall.product.service.SpuSaleAttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/inner/rpc/product")
public class SkuRpcController {

    @Autowired
    private BaseCategory1Service baseCategory1Service;

    @Autowired
    private SkuInfoService skuInfoService;

    @Autowired
    private SkuImageService skuImageService;

    @Autowired
    private SpuSaleAttrService spuSaleAttrService;

    /**
     * 获取对应skuId的商品的所属分类信息
     * @param category3Id
     * @return
     */
    @GetMapping("/skuInfo/categoryView/{category3Id}")
    public Result<CategoryView> getCategoryView(@PathVariable("category3Id") Long category3Id){
        CategoryView categoryView = baseCategory1Service.getCategoryView(category3Id);
        return Result.ok(categoryView);
    }

    /**
     * 获取 商品的详细信息
     * @param skuId
     * @return
     */
    @GetMapping("/skuInfo/getSkuInfo/{skuId}")
    public Result<SkuInfo> getSkuInfo(@PathVariable("skuId") Long skuId){
        SkuInfo skuInfo = skuInfoService.getById(skuId);
        return Result.ok(skuInfo);
    }

    /**
     * 获取商品的实时价格
     * @param skuId
     * @return
     */
    @GetMapping("/skuInfo/getRealPrice/{skuId}")
    public Result<BigDecimal> getRealPrice(@PathVariable("skuId") Long skuId) {
        BigDecimal realPrice = skuInfoService.getRealPrice(skuId);
        return Result.ok(realPrice);
    }

    /**
     * 获取商品的 spu 销售属性列表和所有的值
     * @param spuId
     * @param skuId
     * @return
     */
    @GetMapping("/skuInfo/getSpuSaleAttrAndValue/{spuId}/{skuId}")
    public Result<List<SpuSaleAttr>> getSpuSaleAttrAndValue(@PathVariable("spuId") Long spuId,
                                                     @PathVariable("skuId") Long skuId) {
        List<SpuSaleAttr> spuSaleAttrList = spuSaleAttrService.getSpuSaleAttrAndValue(spuId,skuId);
        return Result.ok(spuSaleAttrList);
    }

    /**
     * 获取商品对应的所有的图片列表信息
     * @param skuId
     * @return
     */
    @GetMapping("/skuInfo/getSkuImages/{skuId}")
    public Result<List<SkuImage>> getSkuImages(@PathVariable("skuId") Long skuId){
        List<SkuImage> skuImages = skuImageService.list(new LambdaQueryWrapper<SkuImage>().eq(SkuImage::getSkuId, skuId));
        return Result.ok(skuImages);
    }


    /**
     * 获取该商品对应的同一个spu下的所有sku的组合
     * @param spuId
     * @return
     */
    @GetMapping("/skuInfo/getSpuAttrJsonStr/{spuId}")
    public Result<String> getSpuAttrJsonStr(@PathVariable("spuId") Long spuId){
        String json = spuSaleAttrService.getSpuSaleAttrJsonStr(spuId);
        return Result.ok(json);
    }
}
