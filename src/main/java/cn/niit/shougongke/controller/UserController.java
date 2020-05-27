package cn.niit.shougongke.controller;

import cn.niit.shougongke.service.UserService;
import cn.niit.shougongke.util.Client;
import cn.niit.shougongke.util.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Client
@RequestMapping(value = "/user")
@Api(tags = "1.用户")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "查找用户", notes = "输入用户ID")
    @GetMapping(value = "/查找")
    public ResponseResult findUserById(Integer id) {
        return userService.findUserById(id);
    }
}
