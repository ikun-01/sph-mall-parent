package com.jing.mall.product.mapper;

import com.jing.mall.product.entity.BaseAttrInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Jing
* @description 针对表【base_attr_info(属性表)】的数据库操作Mapper
* @createDate 2023-01-14 22:14:26
* @Entity com.jing.mall.product.entity.BaseAttrInfo
*/
public interface BaseAttrInfoMapper extends BaseMapper<BaseAttrInfo> {

    /**
     * 根据商品的分类id查询对应平台属性信息
     * @param category1Id
     * @param category2Id
     * @param category3Id
     * @return
     */
    List<BaseAttrInfo> attrInfoList(@Param("category1Id") Long category1Id,
                                    @Param("category2Id") Long category2Id,
                                    @Param("category3Id") Long category3Id);
}




