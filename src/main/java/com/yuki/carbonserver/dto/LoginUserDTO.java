package com.yuki.carbonserver.dto;

import com.yuki.carbonserver.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginUserDTO extends User {
    private String userTelephone;
    private String userPassword;
}
