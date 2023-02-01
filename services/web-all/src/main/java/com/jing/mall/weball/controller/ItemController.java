package com.jing.mall.weball.controller;

import com.jing.mall.feignclients.item.SkuDetailFeignClient;
import com.jing.mall.item.vo.SkuDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ItemController {


    @Autowired
    private SkuDetailFeignClient skuDetailFeignClient;

    @GetMapping("/{skuId}.html")
    public String item(@PathVariable("skuId") Long skuId, Model model){

        SkuDetailVo skuDetailVo = skuDetailFeignClient.getSkuDetail(skuId).getData();

        model.addAttribute("categoryView",skuDetailVo.getCategoryView());
        model.addAttribute("skuInfo",skuDetailVo.getSkuInfo());
        model.addAttribute("price",skuDetailVo.getPrice());
        model.addAttribute("spuSaleAttrList",skuDetailVo.getSpuSaleAttrList());
        model.addAttribute("valuesSkuJson",skuDetailVo.getValuesSkuJson());
        return "item/index";
    }
}
