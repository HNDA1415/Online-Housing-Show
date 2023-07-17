package com.dinger.onlinehousingshow.service;

import com.dinger.onlinehousingshow.dto.HousingDto;
import com.dinger.onlinehousingshow.entity.Housing;
import com.dinger.onlinehousingshow.entity.User;

import java.util.Date;
import java.util.List;

public interface HousingService {
    HousingDto saveHousing(User owner, HousingDto housingDto);
    HousingDto updateHousing(Long id, HousingDto housingDto);

    //List<Housing> findByUserId(Long id);

    List<Housing> findByUserId(Long id, int page, int size, String housingName, int floors, int masterRoom, int singleRoom, Double amount, Date date);

    List<HousingDto> getHousings(int page, int size, String housingName, int floor, int masterRoom,double amount, int singleRoom, Date timestamp);
}
