package cn.niit.shougongke.service;

import cn.niit.shougongke.entity.Comment;
import cn.niit.shougongke.entity.Commodity;
import cn.niit.shougongke.entity.Shopping;
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

    //    详情
    public ResponseResult CommodityById(int commodityId,int userId) {
        Commodity commodity = commodityMapper.selectById(commodityId);
        Shopping shopping = shoppingMapper.selectByIdOrNo(commodityId, userId);
        int isDel = shopping.getIsDel();
        commodity.setInCar(isDel);
        return ResponseResult.success(commodity);
    }
}
