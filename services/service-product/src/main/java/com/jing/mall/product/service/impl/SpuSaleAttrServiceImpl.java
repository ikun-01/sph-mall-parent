package com.jing.mall.product.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jing.mall.product.entity.SpuSaleAttr;
import com.jing.mall.product.mapper.SpuSaleAttrMapper;
import com.jing.mall.product.service.SpuSaleAttrService;
import com.jing.mall.product.vo.SkuAttrValueVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
* @author Jing
* @description 针对表【spu_sale_attr(spu销售属性)】的数据库操作Service实现
* @createDate 2023-01-14 22:14:26
*/
@Slf4j
@Service
public class SpuSaleAttrServiceImpl extends ServiceImpl<SpuSaleAttrMapper, SpuSaleAttr>
    implements SpuSaleAttrService{

    @Autowired
    private SpuSaleAttrMapper spuSaleAttrMapper;

    @Override
    public List<SpuSaleAttr> getSpuSaleAttrList(Long spuId) {
        return spuSaleAttrMapper.getSpuSaleAttrList(spuId);
    }

    @Override
    public List<SpuSaleAttr> getSpuSaleAttrAndValue(Long spuId, Long skuId) {
        return spuSaleAttrMapper.getSpuSaleAttrAndValue(spuId,skuId);
    }

    @Override
    public String getSpuSaleAttrJsonStr(Long spuId) {
        List<SkuAttrValueVo> skuAttrVos = spuSaleAttrMapper.getSpuSaleAttrJsonStr(spuId);
        Map<String, Long> map = skuAttrVos.stream().collect(Collectors.toMap(SkuAttrValueVo::getVal, SkuAttrValueVo::getSkuId));
        log.info("map: {}",map);
        return JSON.toJSONString(map);
    }
}




