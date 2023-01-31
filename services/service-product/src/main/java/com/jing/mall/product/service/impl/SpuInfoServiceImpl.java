package com.jing.mall.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jing.mall.product.entity.SpuImage;
import com.jing.mall.product.entity.SpuInfo;
import com.jing.mall.product.entity.SpuSaleAttr;
import com.jing.mall.product.entity.SpuSaleAttrValue;
import com.jing.mall.product.mapper.SpuImageMapper;
import com.jing.mall.product.mapper.SpuSaleAttrMapper;
import com.jing.mall.product.mapper.SpuSaleAttrValueMapper;
import com.jing.mall.product.service.SpuInfoService;
import com.jing.mall.product.mapper.SpuInfoMapper;
import com.jing.mall.product.vo.SpuInfoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @author Jing
* @description 针对表【spu_info(商品表)】的数据库操作Service实现
* @createDate 2023-01-14 22:14:26
*/
@Service
public class SpuInfoServiceImpl extends ServiceImpl<SpuInfoMapper, SpuInfo>
    implements SpuInfoService{

    @Autowired
    private SpuImageMapper spuImageMapper;
    @Autowired
    private SpuSaleAttrMapper spuSaleAttrMapper;
    @Autowired
    private SpuSaleAttrValueMapper spuSaleAttrValueMapper;

    @Transactional
    @Override
    public void saveSpuInfo(SpuInfoVo spuInfoVo) {
        // 保存spuInfo信息到spuInfo表中
        SpuInfo spuInfo = new SpuInfo();
        BeanUtils.copyProperties(spuInfoVo,spuInfo);
        this.save(spuInfo);
        // 保存图片信息到 spu_image表中
        Long spuInfoId = spuInfo.getId();
        List<SpuInfoVo.SpuImageListDTO> spuImageList =
                spuInfoVo.getSpuImageList();
        spuImageList.forEach(spuImageDTO -> {
            SpuImage spuImage = new SpuImage();
            spuImage.setSpuId(spuInfoId);
            BeanUtils.copyProperties(spuImageDTO,spuImage);
            spuImageMapper.insert(spuImage);
        });

        // 保存 spu销售属性信息列表到spu_sale_attr表中
        List<SpuInfoVo.SpuSaleAttrListDTO> spuSaleAttrList = spuInfoVo.getSpuSaleAttrList();
        spuSaleAttrList.forEach(spuSaleAttrDTO -> {
            // 保存spu 销售属性信息
            SpuSaleAttr spuSaleAttr = new SpuSaleAttr();
            spuSaleAttr.setSpuId(spuInfoId);
            BeanUtils.copyProperties(spuSaleAttrDTO,spuSaleAttr);
            spuSaleAttrMapper.insert(spuSaleAttr);
            // 保存spu 销售属性信息对应的值
            List<SpuInfoVo.SpuSaleAttrListDTO.SpuSaleAttrValueListDTO> spuSaleAttrValueList = spuSaleAttrDTO.getSpuSaleAttrValueList();
            spuSaleAttrValueList.forEach(spuSaleAttrValueDTO -> {
                SpuSaleAttrValue spuSaleAttrValue = new SpuSaleAttrValue();
                spuSaleAttrValue.setSpuId(spuInfoId);
                spuSaleAttrValue.setSaleAttrName(spuSaleAttrDTO.getSaleAttrName());
                BeanUtils.copyProperties(spuSaleAttrValueDTO,spuSaleAttrValue);
                spuSaleAttrValueMapper.insert(spuSaleAttrValue);
            });
        });
    }

}




