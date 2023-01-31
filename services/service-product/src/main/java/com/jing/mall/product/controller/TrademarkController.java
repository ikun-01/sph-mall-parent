package com.jing.mall.product.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jing.mall.common.result.Result;
import com.jing.mall.product.entity.BaseTrademark;
import com.jing.mall.product.service.BaseTrademarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/product")
public class TrademarkController {
    @Autowired
    private BaseTrademarkService baseTrademarkService;


    /**
     * 获取品牌列表
     * @return
     */
    @GetMapping("/baseTrademark/getTrademarkList")
    public Result getTrademarkList(){
        List<BaseTrademark> list = baseTrademarkService.list();
        return Result.ok(list);
    }


    /**
     * 分页获取品牌列表
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/baseTrademark/{page}/{limit}")
    public Result baseTrademarkList(@PathVariable("page") Integer page,
                                    @PathVariable("limit") Integer limit) {
        Page<BaseTrademark> trademarkPage = baseTrademarkService.page(new Page<>(page, limit));
        return Result.ok(trademarkPage);
    }

    /**
     * 添加品牌信息
     * @param baseTrademark
     * @return
     */
    @PostMapping("/baseTrademark/save")
    public Result save(@RequestBody BaseTrademark baseTrademark){
        baseTrademarkService.save(baseTrademark);
        return Result.ok();
    }

    /**
     * 修改品牌
     * @param baseTrademark
     * @return
     */
    @PutMapping("baseTrademark/update")
    public Result update(@RequestBody BaseTrademark baseTrademark){
        baseTrademarkService.updateById(baseTrademark);
        return Result.ok();
    }


    /**
     * 删除品牌
     * @param id
     * @return
     */
    @DeleteMapping("/baseTrademark/remove/{id}")
    public Result remove(@PathVariable("id") Long id){
        baseTrademarkService.removeById(id);
        return Result.ok();
    }

    /**
     * 根据id获取品牌信息
     * @return
     */
    @GetMapping("/baseTrademark/get/{id}")
    public Result getTrademark(@PathVariable("id") Long id){
        BaseTrademark trademark = baseTrademarkService.getById(id);
        return Result.ok(trademark);
    }

}
