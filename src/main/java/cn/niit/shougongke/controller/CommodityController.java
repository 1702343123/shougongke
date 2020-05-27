package cn.niit.shougongke.controller;

import cn.niit.shougongke.entity.Commodity;
import cn.niit.shougongke.service.CommodityService;
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
    public ResponseResult commodityById(int id) {
        return commodityService.CommodityById(id);
    }
}
