package cn.niit.shougongke.service;

import cn.niit.shougongke.entity.Collect;
import cn.niit.shougongke.entity.Shopping;
import cn.niit.shougongke.mapper.CollectMapper;
import cn.niit.shougongke.util.MsgConst;
import cn.niit.shougongke.util.ResponseResult;
import cn.niit.shougongke.util.StatusConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectService {
    @Autowired
    private CollectMapper collectMapper;
    public ResponseResult checkGoCollect(Integer userId, Integer commodityId) {
        Collect likeOrNo;
        likeOrNo = collectMapper.selectById(commodityId, userId);
        String success = "收藏成功";
        String cancel = "取消收藏成功";
        if (likeOrNo == null) {
            int i = collectMapper.insert(userId, commodityId,0);
            if (i == 1) {
                return new ResponseResult(0, success);
            }
            return ResponseResult.error(StatusConst.ERROR, MsgConst.FAIL);
        }
        int i = collectMapper.updateStatus(likeOrNo.getIsDel(), likeOrNo.getId());
        if (i == 1) {
            likeOrNo = collectMapper.selectById(commodityId, userId);
            if (likeOrNo.getIsDel() == 1) {
                return new ResponseResult(1, cancel);
            }
            return new ResponseResult(0, success);
        }
        return ResponseResult.error(StatusConst.ERROR, MsgConst.FAIL);
    }

}
