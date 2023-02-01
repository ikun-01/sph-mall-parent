package com.jing.mall.feignclients.product;

import com.jing.mall.common.result.Result;
import com.jing.mall.weball.vo.CategoryVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("service-product")
@RequestMapping("/api/inner/rpc/product")
public interface CategoryFeignClient {

    /**
     * 获取所有的商品分类信息树  包含 一级二级三级分类
     * @return
     */
    @GetMapping("/getCategoryTree")
    Result<List<CategoryVo>> getCategoryTree();

}
