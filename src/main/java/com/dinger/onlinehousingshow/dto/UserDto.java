package com.dinger.onlinehousingshow.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class UserDto {

    private Long id;
    private String ownerUserName;
    private String ownerName;
    private String email;
    private String password;
    private Timestamp createdDate;
    private Timestamp updatedDate;
}
