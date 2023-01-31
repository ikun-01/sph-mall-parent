package com.jing.mall.product.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jing.mall.common.result.Result;
import com.jing.mall.product.entity.SpuImage;
import com.jing.mall.product.entity.SpuInfo;
import com.jing.mall.product.service.SpuImageService;
import com.jing.mall.product.service.SpuInfoService;
import com.jing.mall.product.vo.SpuInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/product")
public class SpuInfoController {

    @Autowired
    private SpuInfoService spuInfoService;

    @Autowired
    private SpuImageService spuImageService;


    /**
     * 分页获取spu列表
     * @param page
     * @param limit
     * @param category3Id
     * @return
     */
    @GetMapping("/{page}/{limit}")
    public Result getSpuInfoList(@PathVariable("page") Integer page,
                             @PathVariable("limit") Integer limit,
                             @RequestParam("category3Id") Long category3Id){
        Page<SpuInfo> records = spuInfoService.page(new Page<>(page, limit), new LambdaQueryWrapper<SpuInfo>().eq(SpuInfo::getCategory3Id, category3Id));
        return Result.ok(records);
    }


    /**
     * 添加spu信息
     * @return
     */
    @PostMapping("/saveSpuInfo")
    public Result saveSpuInfo(@RequestBody SpuInfoVo spuInfoVo){
        spuInfoService.saveSpuInfo(spuInfoVo);
        return Result.ok();
    }


    /**
     * 根据spuId获取图片列表
     * @param spuId
     * @return
     */
    @GetMapping("/spuImageList/{spuId}")
    public Result spuImageList(@PathVariable("spuId") Long spuId){
        List<SpuImage> spuImages = spuImageService.list(new LambdaQueryWrapper<SpuImage>().eq(SpuImage::getSpuId, spuId));
        return Result.ok(spuImages);
    }




}

