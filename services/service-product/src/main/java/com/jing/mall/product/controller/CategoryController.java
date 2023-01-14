package com.jing.mall.product.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jing.mall.common.result.Result;
import com.jing.mall.product.entity.BaseCategory1;
import com.jing.mall.product.entity.BaseCategory2;
import com.jing.mall.product.entity.BaseCategory3;
import com.jing.mall.product.service.BaseCategory1Service;
import com.jing.mall.product.service.BaseCategory2Service;
import com.jing.mall.product.service.BaseCategory3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/product")
public class CategoryController {
    @Autowired
    private BaseCategory1Service baseCategory1Service;
    @Autowired
    private BaseCategory2Service baseCategory2Service;
    @Autowired
    private BaseCategory3Service baseCategory3Service;

    /**
     * 返回商品一级分类信息
     * @return
     */
    @GetMapping("/getCategory1")
    public Result getCategory1(){
        List<BaseCategory1> list = baseCategory1Service.list();
        return Result.ok(list);
    }

    /**
     * 返回商品一级分类下的所有二级分类信息
     * @return
     */
    @GetMapping("/getCategory2/{category1Id}")
    public Result getCategory2(@PathVariable("category1Id") Long category1Id){
        List<BaseCategory2> list = baseCategory2Service.list(
                new LambdaQueryWrapper<BaseCategory2>()
                        .eq(BaseCategory2::getCategory1Id, category1Id));
        return Result.ok(list);
    }

    /**
     * 返回商品二级分类下的所有三级分类信息
     * @return
     */
    @GetMapping("/getCategory3/{category2Id}")
    public Result getCategory3(@PathVariable("category2Id") Long category2Id){
        List<BaseCategory3> list = baseCategory3Service.list(
                new LambdaQueryWrapper<BaseCategory3>()
                        .eq(BaseCategory3::getCategory2Id, category2Id));
        return Result.ok(list);
    }
}
