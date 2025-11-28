package com.yuki.carbonserver.dto;

import com.yuki.carbonserver.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO extends User {
    private String userName;
    private String userPassword;
    private LocalDateTime userRegistrationTime; //创建时间
    private LocalDateTime userUpdateTime; //更新时间
}
