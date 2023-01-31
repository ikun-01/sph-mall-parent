package com.jing.mall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jing.mall.product.entity.BaseAttrInfo;
import com.jing.mall.product.entity.BaseAttrValue;
import com.jing.mall.product.mapper.BaseAttrInfoMapper;
import com.jing.mall.product.mapper.BaseAttrValueMapper;
import com.jing.mall.product.service.BaseAttrInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
* @author Jing
* @description 针对表【base_attr_info(属性表)】的数据库操作Service实现
* @createDate 2023-01-14 22:14:26
*/
@Service
public class BaseAttrInfoServiceImpl extends ServiceImpl<BaseAttrInfoMapper, BaseAttrInfo>
    implements BaseAttrInfoService{

    @Autowired
    private BaseAttrValueMapper baseAttrValueMapper;

    @Override
    public List<BaseAttrInfo> attrInfoList(Long category1Id, Long category2Id, Long category3Id) {
        return baseMapper.attrInfoList(category1Id,category2Id,category3Id);
    }

    @Transactional
    @Override
    public void saveAttrInfo(BaseAttrInfo baseAttrInfo) {
        if (baseAttrInfo.getId() == null){
            // 添加
            addAttrInfo(baseAttrInfo);
        } else {
            // 修改
            updateAttrInfo(baseAttrInfo);
        }

    }

    private void updateAttrInfo(BaseAttrInfo baseAttrInfo) {
        // 修改attrInfo中的信息
        baseMapper.updateById(baseAttrInfo);
        // 修改attrInfo中对应的attrValue
        // 获取前端传来的所有attrValue
        List<BaseAttrValue> attrValueList = baseAttrInfo.getAttrValueList();
        List<Long> ids = attrValueList.stream()
                .map(BaseAttrValue::getId) // 获取所有的id
                .filter(Objects::nonNull) // 过滤掉新增的数据 id 为null
                .collect(Collectors.toList());
        LambdaQueryWrapper<BaseAttrValue> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(BaseAttrValue::getAttrId,baseAttrInfo.getId());
        if (ids.size() > 0){
            wrapper.notIn(BaseAttrValue::getId,ids);
            // 删除掉需要删除的数据
            baseAttrValueMapper.delete(wrapper);
        }
        attrValueList.forEach(attrValue -> {
            if (attrValue.getId() == null){
                // 新增
                attrValue.setAttrId(baseAttrInfo.getId());
                baseAttrValueMapper.insert(attrValue);
            }else {
                // 修改
                baseAttrValueMapper.updateById(attrValue);
            }
        });
    }

    private void addAttrInfo(BaseAttrInfo baseAttrInfo) {
        // 保存平台属性信息
        baseMapper.insert(baseAttrInfo);
        // 保存平台属性对应的属性值
        baseAttrInfo.getAttrValueList().forEach(baseAttrValue -> {
            baseAttrValue.setAttrId(baseAttrInfo.getId());
            baseAttrValueMapper.insert(baseAttrValue);
        });
    }
}




