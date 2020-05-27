package cn.niit.shougongke.mapper;

import cn.niit.shougongke.entity.Shopping;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ShoppingMapper {
    //判断是否首次加入购物车
    @Select("select * from t_shopping where commodity_id=#{commodityId} and user_id=#{userId}")
    Shopping selectById(@Param("commodityId") int commodityId, @Param("userId") int userId);
    //判断是否首次加入购物车
    @Select("select * from t_shopping where commodity_id=#{commodityId} and user_id=#{userId} and is_del=0")
    Shopping selectByIdOrNo(@Param("commodityId") int commodityId, @Param("userId") int userId);
    //首次加入购物车
    @Insert("insert into t_shopping(user_id,commodity_id,is_del) values(#{userId},#{commodityId},#{isDel})")
    int insert(@Param("userId")int userId,@Param("commodityId")int commodityId,@Param("isDel")int isDel);

    //加入购物车/取消加入购物车
    int updateStatus(@Param("isDel") int isDel, @Param("id") int id);
    //    统计购物车里的商品数量
    @Select("SELECT COUNT(*) FROM t_shopping WHERE is_del=0 and user_id=#{userId}")
    int countNum(@Param("userId") int userId);
}
