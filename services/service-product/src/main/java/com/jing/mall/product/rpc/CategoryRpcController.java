package com.jing.mall.product.rpc;

import com.jing.mall.common.result.Result;
import com.jing.mall.product.service.BaseCategory1Service;
import com.jing.mall.weball.vo.CategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/inner/rpc/product")
public class CategoryRpcController {

    @Autowired
    private BaseCategory1Service baseCategory1Service;

    /**
     * 获取所有的商品分类信息树  包含 一级二级三级分类
     * @return
     */
    @GetMapping("/getCategoryTree")
    public Result<List<CategoryVo>> getCategoryTree(){
        List<CategoryVo> categoryVos = baseCategory1Service.getCategoryTree();
        return Result.ok(categoryVos);
    }


}
