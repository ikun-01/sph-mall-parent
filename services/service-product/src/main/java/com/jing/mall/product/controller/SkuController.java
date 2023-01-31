package com.jing.mall.product.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jing.mall.common.result.Result;
import com.jing.mall.product.entity.SkuInfo;
import com.jing.mall.product.service.SkuInfoService;
import com.jing.mall.product.vo.SkuInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/product")
public class SkuController {

    @Autowired
    private SkuInfoService skuInfoService;


    /**
     * 保存skuInfo信息
     * @param skuInfoVo
     * @return
     */
    @PostMapping("/saveSkuInfo")
    public Result saveSkuInfo(@RequestBody SkuInfoVo skuInfoVo){
        skuInfoService.saveSkuInfo(skuInfoVo);
        return Result.ok();
    }


    /**
     * 分页获取skuInfo列表
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/list/{page}/{limit}")
    public Result list(@PathVariable("page") Integer page,@PathVariable("limit") Integer limit){
        Page<SkuInfo> skuInfoPage = skuInfoService.page(new Page<>(page, limit));
        return Result.ok(skuInfoPage);
    }


    /**
     * 上架商品
     * @param skuId
     * @return
     */
    @GetMapping("/onSale/{skuId}")
    public Result onSale(@PathVariable("skuId") Long skuId){
        skuInfoService.onSale(skuId);
        return Result.ok();
    }


    /**
     * 下架商品
     * @param skuId
     * @return
     */
    @GetMapping("/cancelSale/{skuId}")
    public Result cancelSale(@PathVariable("skuId") Long skuId){
        skuInfoService.cancelSale(skuId);
       return Result.ok();
    }
}
