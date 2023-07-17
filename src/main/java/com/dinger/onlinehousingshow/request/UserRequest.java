package com.dinger.onlinehousingshow.request;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class UserRequest {
    private String ownerUserName;
    private String ownerName;
    private String email;
    private String password;
    private Timestamp createdDate;
    private Timestamp updatedDate;
}
