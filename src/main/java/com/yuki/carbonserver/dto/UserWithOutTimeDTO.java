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
public class UserWithOutTimeDTO extends User {
    private String userName;
    private String userTelephone;
    private String userPassword;
}
