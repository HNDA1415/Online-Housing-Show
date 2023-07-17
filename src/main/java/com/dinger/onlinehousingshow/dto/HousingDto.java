package com.dinger.onlinehousingshow.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class HousingDto {

    private Long id;
    private String housingName;
    private String address;
    private int numberOfFloors;
    private int numberOfMasterRoom;
    private int numberOfSingleRoom;
    private double amount;
    private Timestamp createdDate;
    private Timestamp updatedDate;
    private Long ownerId;
}
