package cn.niit.shougongke.service;

import cn.niit.shougongke.entity.Moment;
import cn.niit.shougongke.entity.User;
import cn.niit.shougongke.mapper.MomentMapper;
import cn.niit.shougongke.mapper.UserMapper;
import cn.niit.shougongke.util.MsgConst;
import cn.niit.shougongke.util.ResponseResult;
import cn.niit.shougongke.util.StringUtil;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.RescaleOp;
import java.sql.Timestamp;
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

    //    添加
    public ResponseResult addMoment(Integer userId, String content, String img) {
        if (userId == null || userId.equals("") || content.equals("") || content == null || img.equals("") || img == null) {
            return ResponseResult.error(13, MsgConst.Param_NULL);
        }
        Moment moment = new Moment();
        moment.setCreateTime(new Timestamp(System.currentTimeMillis()));
        moment.setContent(content);
        moment.setUserId(userId);
        moment.setImg(img);
        moment.setIsDel(0);
        int insert = momentMapper.insert(moment);
        if (insert == 1) {
            return new ResponseResult();
        }else {
            return ResponseResult.error(13, "发布失败");
        }
    }
}
