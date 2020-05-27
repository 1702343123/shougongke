package cn.niit.shougongke.service;

import cn.niit.shougongke.entity.User;
import cn.niit.shougongke.mapper.UserMapper;
import cn.niit.shougongke.util.MsgConst;
import cn.niit.shougongke.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public ResponseResult login(String name,String password) {
        User user = userMapper.login(name,password);
        if (user == null) {
            return ResponseResult.error(13, "账号或密码不正确");
        }
        return ResponseResult.success(user);
    }

    public ResponseResult insertUser(String name, String password) {
        if (name == null || password == null || name.equals("") || password.equals("")) {
            return ResponseResult.error(13, "账号或密码不能为空");
        }
        User user = new User();
        user.setPassword(password);
        user.setName(name);
        user.setImg("https://img2.panbingwen.cn/img/00c5d70b-5dd7-44cb-adfa-a2bbffcf99a6.jpg");
        user.setIsDel(0);
        int insert = userMapper.insert(user);
        if (insert == 1) {
            return new ResponseResult(0, "注册成功");
        } else {
            return ResponseResult.error(13, "注册失败");
        }

    }
}
