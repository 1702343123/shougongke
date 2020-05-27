package cn.niit.shougongke.service;

import cn.niit.shougongke.entity.User;
import cn.niit.shougongke.mapper.UserMapper;
import cn.niit.shougongke.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public ResponseResult findUserById(Integer id) {
        User user = userMapper.selectUserById(id);
        return ResponseResult.success(user);
    }
}
