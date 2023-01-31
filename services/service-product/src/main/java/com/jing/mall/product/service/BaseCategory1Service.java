package com.jing.mall.product.service;

import com.jing.mall.product.entity.BaseCategory1;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jing.mall.weball.vo.CategoryVo;

import java.util.List;

/**
* @author Jing
* @description 针对表【base_category1(一级分类表)】的数据库操作Service
* @createDate 2023-01-14 22:14:26
*/
public interface BaseCategory1Service extends IService<BaseCategory1> {

    /**
     * 获取所有商品分类树状信息
     * @return
     */
    List<CategoryVo> getCategoryTree();
}
