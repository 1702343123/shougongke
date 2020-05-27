package cn.niit.shougongke.mapper;

import java.util.List;

import cn.niit.shougongke.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {


    User selectUserById(Integer id);
}