package cn.niit.shougongke.service;

import cn.niit.shougongke.entity.Shopping;
import cn.niit.shougongke.mapper.ShoppingMapper;
import cn.niit.shougongke.util.MsgConst;
import cn.niit.shougongke.util.ResponseResult;
import cn.niit.shougongke.util.StatusConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingService {
    @Autowired
    private ShoppingMapper shoppingMapper;
    //首次加入购物车就插入记录，否则切换状态
    public ResponseResult checkGoShopping(Integer userId,  Integer commodityId) {
        Shopping likeOrNo;
        likeOrNo = shoppingMapper.selectById(commodityId, userId);
        String success = "加入购物车成功";
        String cancel = "取消加入购物车成功";
        if (likeOrNo == null) {
            int i = shoppingMapper.insert(userId, commodityId,0);
            if (i == 1) {
                return new ResponseResult(0, success);
            }
            return ResponseResult.error(StatusConst.ERROR, MsgConst.FAIL);
        }
        int i = shoppingMapper.updateStatus(likeOrNo.getIsDel(), likeOrNo.getId());
        if (i == 1) {
            likeOrNo = shoppingMapper.selectById(commodityId, userId);
            if (likeOrNo.getIsDel() == 1) {
                return new ResponseResult(1, cancel);
            }
            return new ResponseResult(0, success);
        }
        return ResponseResult.error(StatusConst.ERROR, MsgConst.FAIL);
    }
}
