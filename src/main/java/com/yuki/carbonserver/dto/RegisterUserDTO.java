package com.yuki.carbonserver.dto;

import com.yuki.carbonserver.pojo.User;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserDTO extends User {
    @Pattern(regexp = "^\\+?[1-9]\\d{1,14}$", message = "电话号码格式不正确")
    private String userTelephone;
    private String userName;
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "密码必须至少包含8个字符，且包含字母和数字")
    private String userPassword;
}
