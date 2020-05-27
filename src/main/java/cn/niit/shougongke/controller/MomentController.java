package cn.niit.shougongke.controller;

import cn.niit.shougongke.service.CommentService;
import cn.niit.shougongke.service.MomentService;
import cn.niit.shougongke.util.Client;
import cn.niit.shougongke.util.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Client
@RequestMapping(value = "/moment")
@Api(tags = "2.发现")
public class MomentController {
    @Autowired
    private MomentService momentService;

    @GetMapping(value = "/getAllMoment")
    @ApiOperation(value = "所有发现")
    public ResponseResult getAllMoment() {
        return momentService.AllMoment();
    }

    @GetMapping(value = "/MomentDetails")
    @ApiOperation(value = "详情")
    public ResponseResult MomentDetails(int id) {
        return momentService.MomentDetails(id);
    }

    @GetMapping(value = "/addMoment")
    @ApiOperation(value = "添加")
    public ResponseResult addMoment(int userId, String content, String img) {
        return momentService.addMoment(userId,content,img);
    }

    @Autowired
    private CommentService commentService;

    @PostMapping(value = "/addComment")
    @ApiOperation(value = "添加评论")
    public ResponseResult addComment(Integer userId, Integer momentId, String content) {
        return commentService.addComment(userId, momentId, content);
    }
}
