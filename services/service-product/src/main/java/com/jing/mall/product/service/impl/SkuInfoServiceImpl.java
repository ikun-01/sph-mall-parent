package com.jing.mall.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jing.mall.product.entity.SkuAttrValue;
import com.jing.mall.product.entity.SkuImage;
import com.jing.mall.product.entity.SkuInfo;
import com.jing.mall.product.entity.SkuSaleAttrValue;
import com.jing.mall.product.mapper.SkuInfoMapper;
import com.jing.mall.product.service.SkuAttrValueService;
import com.jing.mall.product.service.SkuImageService;
import com.jing.mall.product.service.SkuInfoService;
import com.jing.mall.product.service.SkuSaleAttrValueService;
import com.jing.mall.product.vo.SkuInfoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
* @author Jing
* @description 针对表【sku_info(库存单元表)】的数据库操作Service实现
* @createDate 2023-01-14 22:14:26
*/
@Service
public class SkuInfoServiceImpl extends ServiceImpl<SkuInfoMapper, SkuInfo>
    implements SkuInfoService{

    @Autowired
    private SkuAttrValueService skuAttrValueService;
    @Autowired
    private SkuSaleAttrValueService skuSaleAttrValueService;
    @Autowired
    private SkuImageService skuImageService;


    @Transactional
    @Override
    public void saveSkuInfo(SkuInfoVo skuInfoVo) {
        // 添加skuInfo 信息到sku_info 表中
        SkuInfo skuInfo = new SkuInfo();
        BeanUtils.copyProperties(skuInfoVo,skuInfo);
        this.save(skuInfo);
        Long skuId = skuInfo.getId();
        // 添加 skuAttrValue到sku_attr_value表中
        List<SkuInfoVo.SkuAttrValueListDTO> skuAttrValueList = skuInfoVo.getSkuAttrValueList();
        List<SkuAttrValue> attrValues = skuAttrValueList.stream().map(skuAttrValueDTO -> {
            SkuAttrValue skuAttrValue = new SkuAttrValue();
            skuAttrValue.setSkuId(skuId);
            BeanUtils.copyProperties(skuAttrValueDTO, skuAttrValue);
            return skuAttrValue;
        }).collect(Collectors.toList());
        skuAttrValueService.saveBatch(attrValues);
        // 添加 skuSaleAttrValue 到 sku_sale_attr_vlaue表中
        List<SkuInfoVo.SkuSaleAttrValueListDTO> skuSaleAttrValueList = skuInfoVo.getSkuSaleAttrValueList();
        List<SkuSaleAttrValue> saleAttrValues = skuSaleAttrValueList.stream().map(skuSaleAttrValueDTO -> {
            SkuSaleAttrValue skuSaleAttrValue = new SkuSaleAttrValue();
            skuSaleAttrValue.setSkuId(skuId);
            skuSaleAttrValue.setSpuId(skuInfo.getSpuId());
            BeanUtils.copyProperties(skuSaleAttrValueDTO, skuSaleAttrValue);
            return skuSaleAttrValue;
        }).collect(Collectors.toList());
        skuSaleAttrValueService.saveBatch(saleAttrValues);
        // 保存skuImage到sku_image表中
        List<SkuInfoVo.SkuImageListDTO> skuImageList = skuInfoVo.getSkuImageList();
        List<SkuImage> skuImages = skuImageList.stream().map(skuImageDTO -> {
            SkuImage skuImage = new SkuImage();
            skuImage.setSkuId(skuId);
            BeanUtils.copyProperties(skuImageDTO, skuImage);
            return skuImage;
        }).collect(Collectors.toList());
        skuImageService.saveBatch(skuImages);
    }

    @Override
    public void onSale(Long skuId) {
        updateSkuSaleState(skuId,1);
    }

    @Override
    public void cancelSale(Long skuId) {
        updateSkuSaleState(skuId,0);
    }

    @Override
    public BigDecimal getRealPrice(Long skuId) {
       return baseMapper.getRealPrice(skuId);
    }


    private void updateSkuSaleState(Long skuId,Integer status){
        SkuInfo skuInfo = this.getById(skuId);
        skuInfo.setIsSale(status);
        this.updateById(skuInfo);
    }
}




