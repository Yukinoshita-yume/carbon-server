package com.yuki.carbonserver.mapper;

import com.yuki.carbonserver.dto.LoginUserDTO;
import com.yuki.carbonserver.dto.RegisterUserDTO;
import com.yuki.carbonserver.dto.UserDTO;
import com.yuki.carbonserver.dto.UserWithOutTimeDTO;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface UserMapper {
    //根据电话号码查询用户
    @Select("select * from users where user_telephone=#{userTelephone}" )
    UserDTO findByUserTelephone(String userTelephone);

    //根据用户ID查询用户
    @Select("select * from users where user_id=#{userId}" )
    UserDTO findByUserId(Integer userId);

    //根据用户名查询用户
    @Select("select * from users where user_name=#{userName}" )
    ArrayList<UserDTO> findByUserName(String userName);

    //insert user
    @Insert("insert into users(user_name,user_telephone,user_password,user_registration_time,user_update_time,user_level)" +
            " values(#{userName},#{userTelephone},#{userPassword},now(),now(),#{userLevel})")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    Integer add(RegisterUserDTO user);

    //delete user by userId
    @Delete("delete from users where user_id=#{userId}" )
    void deleteByUserId(Integer userId);

    //update user
    @Update("update users set user_name=#{userName},user_password=#{userPassword}," +
            "user_update_time=now(),user_level=#{userLevel} where user_id=#{userId}")
    void update(UserWithOutTimeDTO user);

    //登录
    @Select("select * from users where user_telephone=#{userTelephone} and user_password=#{userPassword}")
    UserDTO login(LoginUserDTO user);
}
