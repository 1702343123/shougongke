package cn.niit.shougongke.service;

import cn.niit.shougongke.entity.Moment;
import cn.niit.shougongke.entity.User;
import cn.niit.shougongke.mapper.MomentMapper;
import cn.niit.shougongke.mapper.UserMapper;
import cn.niit.shougongke.util.ResponseResult;
import cn.niit.shougongke.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.RescaleOp;
import java.util.List;

@Service
public class MomentService {
    @Autowired
    MomentMapper momentMapper;
    @Autowired
    UserMapper userMapper;

    public ResponseResult AllMoment() {
        List<Moment> moments = momentMapper.selectAll();
        for (Moment moment : moments) {
            int userId = moment.getUserId();
            User user = userMapper.findUserById(userId);
            moment.setUser(user);
            moment.setTime(StringUtil.getDateString(moment.getCreateTime()));
        }
        return ResponseResult.success(moments);
    }

    //    详情
    public ResponseResult MomentDetails(int id) {
        Moment moment = momentMapper.selectById(id);
        moment.setTime(StringUtil.getDateString(moment.getCreateTime()));
        User user = userMapper.findUserById(moment.getUserId());
        moment.setUser(user);
        return ResponseResult.success(moment);
    }
}
