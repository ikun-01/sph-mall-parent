package com.jing.mall.weball.vo;

import lombok.Data;

import java.util.List;

@Data
public class CategoryVo {
    private Long categoryId;
    private String categoryName;
    List<CategoryVo> categoryChild;
}
