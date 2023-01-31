package com.jing.mall.product.controller;

import com.jing.mall.common.result.Result;
import com.jing.mall.product.entity.BaseSaleAttr;
import com.jing.mall.product.entity.SpuSaleAttr;
import com.jing.mall.product.service.BaseSaleAttrService;
import com.jing.mall.product.service.SpuSaleAttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/product")
public class SaleAttrController {

    @Autowired
    private BaseSaleAttrService baseSaleAttrService;

    @Autowired
    private SpuSaleAttrService spuSaleAttrService;

    /**
     * 获取销售属性
     * @return
     */
    @GetMapping("/baseSaleAttrList")
    public Result getBaseSaleAttrList(){
        List<BaseSaleAttr> list = baseSaleAttrService.list();
        return Result.ok(list);
    }


    /**
     * 获取对应spuId的销售属性列表
     * @param spuId
     * @return
     */
    @GetMapping("/spuSaleAttrList/{spuId}")
    public Result spuSaleAttrList(@PathVariable("spuId") Long spuId){
        List<SpuSaleAttr> list = spuSaleAttrService.getSpuSaleAttrList(spuId);
        return Result.ok(list);
    }
}
