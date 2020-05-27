package cn.niit.shougongke.mapper;

import cn.niit.shougongke.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface CommentMapper {

    @Select("select * from t_comment where moment_id=#{id}")
    Comment selectById(@Param("id")Integer id);
}
