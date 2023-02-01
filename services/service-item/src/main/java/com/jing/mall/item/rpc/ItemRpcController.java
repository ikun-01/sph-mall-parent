package com.jing.mall.item.rpc;

import com.jing.mall.common.result.Result;
import com.jing.mall.item.service.SkuDetailService;
import com.jing.mall.item.vo.SkuDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inner/rpc/item")
public class ItemRpcController {

    @Autowired
    private SkuDetailService skuDetailService;


    @GetMapping("/{skuId}")
    public Result<SkuDetailVo> getSkuDetail(@PathVariable("skuId") Long skuId){
        SkuDetailVo skuDetailVo = skuDetailService.getSkuDetail(skuId);
        return Result.ok(skuDetailVo);
    }
}
