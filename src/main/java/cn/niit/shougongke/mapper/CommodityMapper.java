package cn.niit.shougongke.mapper;

import cn.niit.shougongke.entity.Commodity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Component
public interface CommodityMapper {

    @Select("select * from t_commodity")
    List<Commodity> selectAll();

    @Select("select * from t_commodity where id=#{id}")
    Commodity selectById(@Param("id") Integer id);
}
