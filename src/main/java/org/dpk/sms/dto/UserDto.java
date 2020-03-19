package org.dpk.sms.dto;

import lombok.Data;

@Data
public class UserDto {

    private Long id;
    private String name;
    private String occupation;
    private String login;
    private String password;

    private Long roleId;

}
