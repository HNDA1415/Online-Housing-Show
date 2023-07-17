package com.dinger.onlinehousingshow.service;

import com.dinger.onlinehousingshow.dto.HousingDto;
import com.dinger.onlinehousingshow.entity.Housing;
import com.dinger.onlinehousingshow.entity.User;
import com.dinger.onlinehousingshow.mapper.HousingMapper;
import com.dinger.onlinehousingshow.repository.HousingRepository;
import com.dinger.onlinehousingshow.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class HousingServiceImplementation implements HousingService{
    private final HousingMapper housingMapper;
    private final UserRepository userRepository;
    private final HousingRepository housingRepository;

    public HousingServiceImplementation(HousingMapper housingMapper, UserRepository userRepository, HousingRepository housingRepository) {
        this.housingMapper = housingMapper;
        this.userRepository = userRepository;
        this.housingRepository = housingRepository;
    }

    @Override
    public HousingDto saveHousing(User owner, HousingDto housingDto) {

        Housing housing = housingMapper.toHousingEntity(owner,housingDto);
        housing.setHousingName(housingDto.getHousingName());
        housing.setAddress(housingDto.getAddress());
        housing.setAmount(housingDto.getAmount());
        housing.setNumberOfSingleRoom(housingDto.getNumberOfSingleRoom());
        housing.setNumberOfMasterRoom(housingDto.getNumberOfMasterRoom());
        housing.setNumberOfFloors(housingDto.getNumberOfFloors());
        housing.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        //housing.setOwnerId(owner);
        User userSaved = userRepository.save(owner);
        Housing saved = housingRepository.save(housing);
        HousingDto dto = housingMapper.toHousingDto(saved,userSaved);

        return dto;
    }

    @Override
    public HousingDto updateHousing(Long id, HousingDto housingDto) {
        Housing housing = housingRepository.getById(id);
        housing.setHousingName(housingDto.getHousingName());
        housing.setAddress(housingDto.getAddress());
        housing.setAmount(housingDto.getAmount());
        housing.setNumberOfSingleRoom(housingDto.getNumberOfSingleRoom());
        housing.setNumberOfMasterRoom(housingDto.getNumberOfMasterRoom());
        housing.setNumberOfFloors(housingDto.getNumberOfFloors());
        housing.setCreatedDate(housingDto.getCreatedDate());
        housing.setUpdatedDate(housingDto.getUpdatedDate());
        Housing saved = housingRepository.save(housing);
        HousingDto dto = housingMapper.toHousingDto(saved);
        return dto;
    }


    @Override
    public List<Housing> findByUserId(Long id, int page, int size, String housingName, int floors, int masterRoom, int singleRoom, Double amount, Date date) {
        List<Housing> housings = housingRepository.findByUserId(id,housingName,floors,masterRoom,singleRoom,amount,date);
        if (housings.size() > size) {
            housings = housings.subList(0, size);
        }
        return housings;
    }

    @Override
    public List<HousingDto> getHousings(int page, int size, String housingName, int floor, int masterRoom,double amount, int singleRoom, Date timestamp) {
        List<HousingDto> housingDtoList = new ArrayList<>();
        List<Housing> housings = housingRepository.search(housingName,floor,masterRoom,amount,singleRoom,timestamp);
        for (Housing housing : housings){
            if (housings.size() > size) {
                housings = housings.subList(0, size);
            }
            HousingDto housingDto = housingMapper.toHousingDto(housing);
            housingDtoList.add(housingDto);
        }
        return housingDtoList;
    }

}
