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
        User user = userMapper.login("Joker","java");
        System.out.println(user.toString());
    }

    @Test
    public void findUserServiceTest() {
        ResponseResult userById = userService.login("Joker","java");
        System.out.println(userById.toString());
    }

    @Autowired
    UserController userController;

    @Test
    public void findUserControllerTest() {
        ResponseResult res = userController.login("Joker","java");
        System.out.println(res.toString());

    }

    @Test
    public void insertUserTest() {
        User user = new User();
        user.setName("Joker");
        user.setImg("imgURL");
        user.setIsDel(0);
        user.setPassword("java");
        int insert = userMapper.insert(user);
        if (insert == 1) {
            System.out.println("成功");
        } else {
            System.out.println("失败");
        }
    }

    @Test
    public void register() {
        ResponseResult responseResult = userService.insertUser("mary", "java");
        System.out.println(responseResult.toString());
    }
}