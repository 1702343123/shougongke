package cn.niit.shougongke.mapper;

import java.util.List;

import cn.niit.shougongke.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import sun.security.util.Password;

@Mapper
@Component
public interface UserMapper {


    User login(@Param("name") String name, @Param("password")String password);

    int insert(User user);
}