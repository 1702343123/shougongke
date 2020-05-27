package cn.niit.shougongke.controller;

import cn.niit.shougongke.BasicTest;
import cn.niit.shougongke.entity.Comment;
import cn.niit.shougongke.entity.Moment;
import cn.niit.shougongke.entity.User;
import cn.niit.shougongke.mapper.CommentMapper;
import cn.niit.shougongke.mapper.MomentMapper;
import cn.niit.shougongke.mapper.UserMapper;
import cn.niit.shougongke.service.CommentService;
import cn.niit.shougongke.service.MomentService;
import cn.niit.shougongke.service.UserService;
import cn.niit.shougongke.util.ResponseResult;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
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

    @Autowired
    MomentMapper momentMapper;
    @Test
    public void selectAllMomentTest() {
        List<Moment> moments = momentMapper.selectAll();
        moments.forEach(moment -> System.out.println(moment.toString()));
    }

    @Test
    public void selectByIdTest() {
        User userById = userMapper.findUserById(1);
        System.out.println(userById.toString());
    }

    @Autowired
    MomentService momentService;
    @Test
    public void allMomentServiceTest() {
        ResponseResult responseResult = momentService.AllMoment();
        System.out.println(responseResult.toString());
    }

    @Autowired
    MomentController momentController;

    @Test
    public void allMomentControllerTest() {
        ResponseResult allMoment = momentController.getAllMoment();
        System.out.println(allMoment.toString());
    }

    @Autowired
    CommentMapper commentMapper;

    @Test
    public void selectCommentByIdTest() {
        Comment comment = commentMapper.selectById(1);
        System.out.println(comment.toString());
    }

    @Test
    public void momentByIdServiceTest() {
        ResponseResult responseResult = momentService.MomentDetails(1);
        System.out.println(responseResult.toString());
    }

    @Test
    public void momentInsertTest() {
        Moment moment = new Moment();
        moment.setCreateTime(new Timestamp(System.currentTimeMillis()));
        moment.setContent("江上之清风");
        moment.setUserId(1);
        moment.setImg("https://img2.panbingwen.cn/img/00c5d70b-5dd7-44cb-adfa-a2bbffcf99a6.jpg");
        moment.setIsDel(0);
        int insert = momentMapper.insert(moment);
        if (insert == 1) {
            System.out.println("成功======");
        }else {
            System.out.println("失败--");
        }

    }

    @Test
    public void addMomentTest() {
        ResponseResult re = momentController.addMoment(1, "山间之明月", "https://img2.panbingwen.cn/img/00c5d70b-5dd7-44cb-adfa-a2bbffcf99a6.jpg");
        System.out.println(re.toString());

    }

    @Test
    public void addCommentTest() {
        Comment comment = new Comment();
        comment.setContent("啦啦");
        comment.setCreateTime(new Timestamp(System.currentTimeMillis()));
        comment.setUserId(1);
        comment.setIsDel(0);
        comment.setMomentId(1);
        int insert = commentMapper.insert(comment);
        if (insert == 1) {
            System.out.println("222222");
        } else {
            System.out.println("3333333");
        }
    }

    @Autowired
    CommentService commentService;
    @Test
    public void addComment() {
        ResponseResult res = commentService.addComment(1, 1, "嘻嘻");
        System.out.println(res.toString());

    }
}