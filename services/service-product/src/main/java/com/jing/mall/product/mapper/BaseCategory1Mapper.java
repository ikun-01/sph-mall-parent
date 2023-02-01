package com.jing.mall.product.mapper;

import com.jing.mall.item.vo.CategoryView;
import com.jing.mall.product.entity.BaseCategory1;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jing.mall.weball.vo.CategoryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Jing
* @description 针对表【base_category1(一级分类表)】的数据库操作Mapper
* @createDate 2023-01-14 22:14:26
* @Entity com.jing.mall.product.entity.BaseCategory1
*/
public interface BaseCategory1Mapper extends BaseMapper<BaseCategory1> {


    List<CategoryVo> getCategoryTree();

    CategoryView getCategoryView(@Param("category3Id") Long category3Id);
}




