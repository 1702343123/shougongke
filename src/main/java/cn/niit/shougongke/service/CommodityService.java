package cn.niit.shougongke.service;

import cn.niit.shougongke.entity.Collect;
import cn.niit.shougongke.entity.Comment;
import cn.niit.shougongke.entity.Commodity;
import cn.niit.shougongke.entity.Shopping;
import cn.niit.shougongke.mapper.CollectMapper;
import cn.niit.shougongke.mapper.CommentMapper;
import cn.niit.shougongke.mapper.CommodityMapper;
import cn.niit.shougongke.mapper.ShoppingMapper;
import cn.niit.shougongke.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.interfaces.PBEKey;
import java.awt.image.RescaleOp;
import java.util.List;

@Service
public class CommodityService {
    @Autowired
    private CommodityMapper commodityMapper;
    @Autowired
    private ShoppingMapper shoppingMapper;

    public ResponseResult allCommodity() {
        List<Commodity> commodities = commodityMapper.selectAll();
        return ResponseResult.success(commodities);
    }

    @Autowired
    private CollectMapper collectMapper;
    //    详情
    public ResponseResult CommodityById(int commodityId,int userId) {
        Commodity commodity = commodityMapper.selectById(commodityId);
//        购物车状态
        Shopping shopping = shoppingMapper.selectByIdOrNo(commodityId, userId);
        int isDel = shopping.getIsDel();
        commodity.setInCar(isDel);
//        收藏状态
        Collect collect = collectMapper.selectByIdOrNo(commodityId, userId);
        commodity.setInCollect(collect.getIsDel());
        return ResponseResult.success(commodity);
    }
}
