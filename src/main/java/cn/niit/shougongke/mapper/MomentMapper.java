package cn.niit.shougongke.mapper;

import cn.niit.shougongke.entity.Moment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface MomentMapper {

    @Select("select * from t_moment where is_del=0")
    List<Moment> selectAll();

    @Select("select * from t_moment where is_del=0 and id=#{id}")
    Moment selectById(@Param("id") Integer id);

}
