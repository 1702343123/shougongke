package cn.niit.shougongke.mapper;

import cn.niit.shougongke.entity.Collect;
import cn.niit.shougongke.entity.Like;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface LikeMapper {
    //判断是否首次点赞
    @Select("select * from t_like where moment_id=#{momentId} and user_id=#{userId}")
    Like selectById(@Param("momentId") int momentId, @Param("userId") int userId);
    //判断是否首次点赞
    @Select("select * from t_like where moment_id=#{momentId} and user_id=#{userId} and is_del=0")
    Like selectByIdOrNo(@Param("momentId") int momentId, @Param("userId") int userId);
    //首次加入点赞
    @Insert("insert into t_like(user_id,moment_id,is_del) values(#{userId},#{momentId},#{isDel})")
    int insert(@Param("userId")int userId,@Param("momentId")int momentId,@Param("isDel")int isDel);

    //点赞/取消点赞
    int updateStatus(@Param("isDel") int isDel, @Param("id") int id);
}
