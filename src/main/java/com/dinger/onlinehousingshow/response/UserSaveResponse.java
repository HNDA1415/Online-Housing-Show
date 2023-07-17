package com.dinger.onlinehousingshow.response;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;


@Getter
@Setter
public class UserSaveResponse {

    private Long id;
    private String ownerUserName;
    private String ownerName;
    private String email;
    private Timestamp createdDate;

}
