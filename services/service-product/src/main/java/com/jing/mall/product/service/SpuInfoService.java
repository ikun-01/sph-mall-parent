package com.jing.mall.product.service;

import com.jing.mall.product.entity.SpuInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jing.mall.product.vo.SpuInfoVo;

/**
* @author Jing
* @description 针对表【spu_info(商品表)】的数据库操作Service
* @createDate 2023-01-14 22:14:26
*/
public interface SpuInfoService extends IService<SpuInfo> {

    /**
     * 添加spu信息
     * @param spuInfoVo
     */
    void saveSpuInfo(SpuInfoVo spuInfoVo);
}
