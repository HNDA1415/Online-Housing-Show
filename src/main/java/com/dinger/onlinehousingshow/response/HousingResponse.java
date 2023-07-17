package com.dinger.onlinehousingshow.response;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class HousingResponse {
    private Long id;
    private String housingName;
    private String address;
    private int numberOfFloors;
    private int numberOfMasterRoom;
    private int numberOfSingleRoom;
    private double amount;
    private Timestamp createdDate;
    private Timestamp updatedDate;
}
