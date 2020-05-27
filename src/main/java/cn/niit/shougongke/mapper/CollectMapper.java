package cn.niit.shougongke.mapper;

import cn.niit.shougongke.entity.Collect;
import cn.niit.shougongke.entity.Shopping;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface CollectMapper {
    //判断是否首次收藏
    @Select("select * from t_collect where commodity_id=#{commodityId} and user_id=#{userId}")
    Collect selectById(@Param("commodityId") int commodityId, @Param("userId") int userId);
    //判断是否首次收藏
    @Select("select * from t_collect where commodity_id=#{commodityId} and user_id=#{userId} and is_del=0")
    Collect selectByIdOrNo(@Param("commodityId") int commodityId, @Param("userId") int userId);
    //首次加入收藏
    @Insert("insert into t_collect(user_id,commodity_id,is_del) values(#{userId},#{commodityId},#{isDel})")
    int insert(@Param("userId")int userId,@Param("commodityId")int commodityId,@Param("isDel")int isDel);

    //收藏/取消收藏
    int updateStatus(@Param("isDel") int isDel, @Param("id") int id);

    //    统计收藏数量
    @Select("SELECT COUNT(*) FROM t_collect WHERE is_del=0 and user_id=#{userId}")
    int countNum(@Param("userId") int userId);

}
