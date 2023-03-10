package com.jing.mall.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jing.mall.item.vo.CategoryView;
import com.jing.mall.product.entity.BaseCategory1;
import com.jing.mall.product.service.BaseCategory1Service;
import com.jing.mall.product.mapper.BaseCategory1Mapper;
import com.jing.mall.weball.vo.CategoryVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Jing
* @description 针对表【base_category1(一级分类表)】的数据库操作Service实现
* @createDate 2023-01-14 22:14:26
*/
@Service
public class BaseCategory1ServiceImpl extends ServiceImpl<BaseCategory1Mapper, BaseCategory1>
    implements BaseCategory1Service{

    @Override
    public List<CategoryVo> getCategoryTree() {
        return baseMapper.getCategoryTree();
    }

    @Override
    public CategoryView getCategoryView(Long category3Id) {
        return baseMapper.getCategoryView(category3Id);
    }
}




