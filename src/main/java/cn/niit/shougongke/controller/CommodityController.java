package cn.niit.shougongke.controller;

import cn.niit.shougongke.entity.Collect;
import cn.niit.shougongke.entity.Commodity;
import cn.niit.shougongke.service.CollectService;
import cn.niit.shougongke.service.CommodityService;
import cn.niit.shougongke.service.ShoppingService;
import cn.niit.shougongke.util.Client;
import cn.niit.shougongke.util.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Client
@RequestMapping(value = "/commodity")
@Api(tags = "3.商品")
public class CommodityController {
    @Autowired
    private CommodityService commodityService;

    @GetMapping(value = "/allCommodity")
    @ApiOperation(value = "所有商品")
    public ResponseResult allCommodity() {
        return commodityService.allCommodity();
    }
    @GetMapping(value = "/commodityById")
    @ApiOperation(value = "商品详情")
    public ResponseResult commodityById(int commodityId,int userId) {
        return commodityService.CommodityById(commodityId,userId);
    }

    @Autowired
    private ShoppingService shoppingService;
    @GetMapping(value = "/goShopping")
    @ApiOperation(value = "加入购物车/取消加入购物车")
    public ResponseResult goShopping(int commodityId,int userId) {
        return shoppingService.checkGoShopping(userId,commodityId);
    }

    @Autowired
    private CollectService collectService;
    @GetMapping(value = "/goCollect")
    @ApiOperation(value = "收藏/取消收藏")
    public ResponseResult goCollect(int commodityId,int userId) {
        return collectService.checkGoCollect(userId,commodityId);
    }
}
