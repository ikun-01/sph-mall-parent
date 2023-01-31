package com.jing.mall.weball.controller;

import com.jing.mall.feignclients.product.CategoryFeignClient;
import com.jing.mall.weball.vo.CategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 商城前台首页
 */
@Controller
public class IndexPageController {

    @Autowired
    private CategoryFeignClient categoryFeignClient;

    @GetMapping({"index.html","/"})
    public String index(Model model){
        List<CategoryVo> categoryTree = categoryFeignClient.getCategoryTree().getData();
        model.addAttribute("list",categoryTree);
        return "index/index";
    }
}
