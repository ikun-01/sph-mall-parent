package com.jing.mall.product.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jing.mall.common.result.Result;
import com.jing.mall.product.entity.BaseAttrInfo;
import com.jing.mall.product.entity.BaseAttrValue;
import com.jing.mall.product.service.BaseAttrInfoService;
import com.jing.mall.product.service.BaseAttrValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/product")
public class AttrInfoController {

    @Autowired
    private BaseAttrInfoService baseAttrInfoService;
    @Autowired
    private BaseAttrValueService baseAttrValueService;

    /**
     * 返回对应分类商品的平台属性信息
     * @return
     */
    @GetMapping("/attrInfoList/{category1Id}/{category2Id}/{category3Id}")
    public Result getAttrInfoList(@PathVariable("category1Id") Long category1Id,
                                  @PathVariable("category2Id") Long category2Id,
                                  @PathVariable("category3Id")Long category3Id){
        List<BaseAttrInfo> list = baseAttrInfoService.attrInfoList(category1Id,category2Id,category3Id);
        return Result.ok(list);
    }


    /**
     * 保存平台属性信息
     * @param baseAttrInfo
     * @return
     */
    @PostMapping("/saveAttrInfo")
    public Result saveAttrInfo(@RequestBody BaseAttrInfo baseAttrInfo){
        baseAttrInfoService.saveAttrInfo(baseAttrInfo);
        return Result.ok();
    }


    /**
     * 根据平台属性信息获取对应的值列表
     * @param attrId
     * @return
     */
    @GetMapping("/getAttrValueList/{attrId}")
    public Result getAttrValueListByAttrId(@PathVariable("attrId") Long attrId){
        List<BaseAttrValue> attrValueList = baseAttrValueService.list(new LambdaQueryWrapper<BaseAttrValue>().eq(BaseAttrValue::getAttrId, attrId));
        return Result.ok(attrValueList);
    }
}
