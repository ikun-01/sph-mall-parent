package com.jing.mall.feignclients.item;

import com.jing.mall.common.result.Result;
import com.jing.mall.item.vo.SkuDetailVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("service-item")
@RequestMapping("/api/inner/rpc/item")
public interface SkuDetailFeignClient {
    @GetMapping("/{skuId}")
    Result<SkuDetailVo> getSkuDetail(@PathVariable("skuId") Long skuId);
}
