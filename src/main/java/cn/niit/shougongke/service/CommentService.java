package cn.niit.shougongke.service;

import cn.niit.shougongke.entity.Comment;
import cn.niit.shougongke.mapper.CommentMapper;
import cn.niit.shougongke.util.MsgConst;
import cn.niit.shougongke.util.ResponseResult;
import cn.niit.shougongke.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.smartcardio.CommandAPDU;
import java.sql.Timestamp;

@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;

    public ResponseResult addComment(Integer userId, Integer momentId, String content) {
        if (userId == null || momentId == null || content == null) {
            return ResponseResult.error(13, MsgConst.Param_NULL);
        }
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setCreateTime(new Timestamp(System.currentTimeMillis()));
        comment.setUserId(userId);
        comment.setIsDel(0);
        comment.setMomentId(momentId);
        int insert = commentMapper.insert(comment);
        if (insert == 1) {
            return new ResponseResult(0, "评论成功");
        } else {
            return ResponseResult.error(13, MsgConst.PASSWORD_ERROR);
        }
    }
}
