package com.dinger.onlinehousingshow.mapper;

import com.dinger.onlinehousingshow.dto.HousingDto;
import com.dinger.onlinehousingshow.entity.Housing;
import com.dinger.onlinehousingshow.entity.User;
import com.dinger.onlinehousingshow.request.HousingRequest;
import com.dinger.onlinehousingshow.response.HousingResponse;
import com.dinger.onlinehousingshow.response.HousingSavedResponse;
import com.dinger.onlinehousingshow.response.HousingUpdateResponse;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Component
public class HousingMapperImplementation implements HousingMapper{

    @Override
    public HousingDto toHousingSaveDto(User owner, HousingRequest housingRequest) {
        HousingDto housingDto = new HousingDto();
        housingDto.setHousingName(housingRequest.getHousingName());
        housingDto.setAmount(housingRequest.getAmount());
        housingDto.setAddress(housingRequest.getAddress());
        housingDto.setNumberOfFloors(housingRequest.getNumberOfFloors());
        housingDto.setNumberOfMasterRoom(housingRequest.getNumberOfMasterRoom());
        housingDto.setNumberOfSingleRoom(housingRequest.getNumberOfSingleRoom());
        housingDto.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        housingDto.setOwnerId(owner.getId());
        return housingDto;
    }

    @Override
    public Housing toHousingEntity(User owner, HousingDto housingDto) {
        Housing housing = new Housing();
        housing.setOwnerId(owner);
        housing.setHousingName(housingDto.getHousingName());
        housing.setAmount(housingDto.getAmount());
        housing.setAddress(housingDto.getAddress());
        housing.setNumberOfFloors(housingDto.getNumberOfFloors());
        housing.setNumberOfMasterRoom(housingDto.getNumberOfMasterRoom());
        housing.setNumberOfSingleRoom(housingDto.getNumberOfSingleRoom());
        housing.setCreatedDate(housingDto.getCreatedDate());
        //housing.setUpdatedDate(housingDto.getUpdatedDate());
        return housing;
    }

    @Override
    public HousingDto toHousingDto(Housing saved, User userSaved) {
        HousingDto housingDto = new HousingDto();
        housingDto.setId(saved.getId());
        housingDto.setOwnerId(userSaved.getId());
        housingDto.setHousingName(saved.getHousingName());
        housingDto.setAmount(saved.getAmount());
        housingDto.setAddress(saved.getAddress());
        housingDto.setNumberOfFloors(saved.getNumberOfFloors());
        housingDto.setNumberOfMasterRoom(saved.getNumberOfMasterRoom());
        housingDto.setNumberOfSingleRoom(saved.getNumberOfSingleRoom());
        housingDto.setCreatedDate(saved.getCreatedDate());
        housingDto.setUpdatedDate(saved.getUpdatedDate());
        return housingDto;

    }

    @Override
    public HousingSavedResponse toHousingSaveResponse(HousingDto saved) {
        HousingSavedResponse response = new HousingSavedResponse();
        response.setId(saved.getId());
        //response.setOwnerId(saved.getId());
        response.setHousingName(saved.getHousingName());
        response.setAmount(saved.getAmount());
        response.setAddress(saved.getAddress());
        response.setNumberOfFloors(saved.getNumberOfFloors());
        response.setNumberOfMasterRoom(saved.getNumberOfMasterRoom());
        response.setNumberOfSingleRoom(saved.getNumberOfSingleRoom());
        response.setCreatedDate(saved.getCreatedDate());

        return response;
    }

    @Override
    public HousingDto toHousingUpdateDto(HousingRequest housingRequest) {
        HousingDto housingDto = new HousingDto();
        housingDto.setHousingName(housingRequest.getHousingName());
        housingDto.setAmount(housingRequest.getAmount());
        housingDto.setAddress(housingRequest.getAddress());
        housingDto.setNumberOfFloors(housingRequest.getNumberOfFloors());
        housingDto.setNumberOfMasterRoom(housingRequest.getNumberOfMasterRoom());
        housingDto.setNumberOfSingleRoom(housingRequest.getNumberOfSingleRoom());
        housingDto.setCreatedDate(housingRequest.getCreatedDate());
        housingDto.setUpdatedDate(Timestamp.valueOf(LocalDateTime.now()));
        //housingDto.setOwnerId(owner.getId());
        return housingDto;
    }

    @Override
    public HousingDto toHousingDto(Housing saved) {
        HousingDto housingDto = new HousingDto();
        housingDto.setHousingName(saved.getHousingName());
        housingDto.setAmount(saved.getAmount());
        housingDto.setAddress(saved.getAddress());
        housingDto.setNumberOfFloors(saved.getNumberOfFloors());
        housingDto.setNumberOfMasterRoom(saved.getNumberOfMasterRoom());
        housingDto.setNumberOfSingleRoom(saved.getNumberOfSingleRoom());
        housingDto.setCreatedDate(saved.getCreatedDate());
        housingDto.setUpdatedDate(saved.getUpdatedDate());

        return housingDto;
    }

    @Override
    public HousingUpdateResponse toHousingUpdateResponse(Long id,HousingDto saved) {
        HousingUpdateResponse response = new HousingUpdateResponse();
        response.setId(id);
        response.setHousingName(saved.getHousingName());
        response.setAmount(saved.getAmount());
        response.setAddress(saved.getAddress());
        response.setNumberOfFloors(saved.getNumberOfFloors());
        response.setNumberOfMasterRoom(saved.getNumberOfMasterRoom());
        response.setNumberOfSingleRoom(saved.getNumberOfSingleRoom());
        response.setCreatedDate(saved.getCreatedDate());
        response.setUpdatedDate(saved.getUpdatedDate());
        return response;
    }

    @Override
    public HousingResponse toHousingResponse(HousingDto housingDto) {
        HousingResponse response = new HousingResponse();
        response.setId(housingDto.getId());
        response.setHousingName(housingDto.getHousingName());
        response.setAmount(housingDto.getAmount());
        response.setAddress(housingDto.getAddress());
        response.setCreatedDate(housingDto.getCreatedDate());
        if (housingDto.getUpdatedDate()==null){
            response.setUpdatedDate(housingDto.getCreatedDate());
        }else {
            response.setUpdatedDate(housingDto.getUpdatedDate());
        }
        response.setNumberOfFloors(housingDto.getNumberOfFloors());
        response.setNumberOfMasterRoom(housingDto.getNumberOfMasterRoom());
        response.setNumberOfSingleRoom(housingDto.getNumberOfSingleRoom());

        return response;
    }
}
