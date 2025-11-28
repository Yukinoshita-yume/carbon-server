package com.yuki.carbonserver.service;

import com.yuki.carbonserver.dto.LoginUserDTO;
import com.yuki.carbonserver.dto.RegisterUserDTO;
import com.yuki.carbonserver.pojo.Result;

public interface UserService {
    Result register(RegisterUserDTO user);
    Result login(LoginUserDTO user);
}
