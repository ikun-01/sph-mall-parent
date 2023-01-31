package com.jing.mall.product.service;

import com.jing.mall.product.entity.BaseAttrInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Jing
* @description 针对表【base_attr_info(属性表)】的数据库操作Service
* @createDate 2023-01-14 22:14:26
*/
public interface BaseAttrInfoService extends IService<BaseAttrInfo> {

    /**
     * 根据商品分类查询对应的平台属性信息
     * @param category1Id
     * @param category2Id
     * @param category3Id
     * @return
     */
    List<BaseAttrInfo> attrInfoList(Long category1Id, Long category2Id, Long category3Id);

    /**
     * 保存对应分类的平台属性以及值
     * @param baseAttrInfo
     */
    void saveAttrInfo(BaseAttrInfo baseAttrInfo);
}
