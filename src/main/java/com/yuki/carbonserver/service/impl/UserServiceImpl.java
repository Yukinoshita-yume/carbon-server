package com.yuki.carbonserver.service.impl;

import com.yuki.carbonserver.dto.LoginUserDTO;
import com.yuki.carbonserver.dto.RegisterUserDTO;
import com.yuki.carbonserver.dto.UserDTO;
import com.yuki.carbonserver.mapper.UserMapper;
import com.yuki.carbonserver.pojo.Result;
import com.yuki.carbonserver.service.UserService;
import com.yuki.carbonserver.utils.JwtUtil;
import com.yuki.carbonserver.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Result register(RegisterUserDTO user) {
        try {
            UserDTO existingUser = userMapper.findByUserTelephone(user.getUserTelephone());
            if (existingUser != null) {
                return Result.error("手机号已被占用");

            }
            //加密
            user.setUserPassword(Md5Util.getMD5String(user.getUserPassword()));

            //添加
            return Result.success(userMapper.add(user));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("注册失败，数据库错误"); //数据库错误
        }
    }

    @Override
    public Result login(LoginUserDTO user) {
        try {

            //加密
            user.setUserPassword(Md5Util.getMD5String(user.getUserPassword()));
            //验证
            UserDTO userData = userMapper.login(user);
            if (userData == null) {
                return Result.error("用户名或密码错误");
            }
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", userData.getUserId());
            claims.put("userTelephone", userData.getUserTelephone());
            String token = JwtUtil.genToken(claims);
            return Result.success(token);
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("登录失败，数据库错误"); //数据库错误
        }

    }
}
