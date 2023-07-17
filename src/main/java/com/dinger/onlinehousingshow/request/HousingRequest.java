package com.dinger.onlinehousingshow.request;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class HousingRequest {
    private String housingName;
    private String address;
    private int numberOfFloors;
    private int numberOfMasterRoom;
    private int numberOfSingleRoom;
    private double amount;
    private Timestamp createdDate;
    private Timestamp updatedDate;
}
