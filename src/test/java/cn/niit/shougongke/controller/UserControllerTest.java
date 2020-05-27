package cn.niit.shougongke.controller;

import cn.niit.shougongke.BasicTest;
import cn.niit.shougongke.entity.User;
import cn.niit.shougongke.mapper.UserMapper;
import cn.niit.shougongke.service.UserService;
import cn.niit.shougongke.util.ResponseResult;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserControllerTest extends BasicTest {


    @Autowired
    UserMapper userMapper;
    @Autowired
    UserService userService;
    @Test
    public void findUserMapperTest() {
        User user = userMapper.selectUserById(1);
        System.out.println(user.toString());
    }

    @Test
    public void findUserServiceTest() {
        ResponseResult userById = userService.findUserById(1);
        System.out.println(userById.toString());
    }

    @Autowired
    UserController userController;

    @Test
    public void findUserControllerTest() {
        ResponseResult res = userController.findUserById(1);
        System.out.println(res.toString());

    }
}