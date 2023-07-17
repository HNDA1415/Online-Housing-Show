package com.dinger.onlinehousingshow.mapper;

import com.dinger.onlinehousingshow.dto.HousingDto;
import com.dinger.onlinehousingshow.entity.Housing;
import com.dinger.onlinehousingshow.entity.User;
import com.dinger.onlinehousingshow.request.HousingRequest;
import com.dinger.onlinehousingshow.response.HousingResponse;
import com.dinger.onlinehousingshow.response.HousingSavedResponse;
import com.dinger.onlinehousingshow.response.HousingUpdateResponse;

public interface HousingMapper {

    HousingDto toHousingSaveDto(User owner, HousingRequest housingRequest);

    Housing toHousingEntity(User owner, HousingDto housingDto);

    HousingDto toHousingDto(Housing saved, User userSaved);

    HousingSavedResponse toHousingSaveResponse(HousingDto saved);

    HousingDto toHousingUpdateDto(HousingRequest housingRequest);

    HousingDto toHousingDto(Housing saved);

    HousingUpdateResponse toHousingUpdateResponse(Long id,HousingDto saved);

    HousingResponse toHousingResponse(HousingDto housingDto);
}
