package com.jing.mall.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jing.mall.product.entity.SkuInfo;
import com.jing.mall.product.service.SkuInfoService;
import com.jing.mall.product.mapper.SkuInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author Jing
* @description 针对表【sku_info(库存单元表)】的数据库操作Service实现
* @createDate 2023-01-14 22:14:26
*/
@Service
public class SkuInfoServiceImpl extends ServiceImpl<SkuInfoMapper, SkuInfo>
    implements SkuInfoService{

}




