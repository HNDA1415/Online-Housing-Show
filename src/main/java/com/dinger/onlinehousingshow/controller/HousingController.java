package com.dinger.onlinehousingshow.controller;

import com.dinger.onlinehousingshow.Security.UserPrincipal;
import com.dinger.onlinehousingshow.dto.HousingDto;
import com.dinger.onlinehousingshow.entity.Housing;
import com.dinger.onlinehousingshow.entity.User;
import com.dinger.onlinehousingshow.mapper.HousingMapper;
import com.dinger.onlinehousingshow.repository.UserRepository;
import com.dinger.onlinehousingshow.request.HousingRequest;
import com.dinger.onlinehousingshow.response.HousingResponse;
import com.dinger.onlinehousingshow.response.HousingSavedResponse;
import com.dinger.onlinehousingshow.response.HousingUpdateResponse;
import com.dinger.onlinehousingshow.service.HousingService;
import com.dinger.onlinehousingshow.service.UserService;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api")
public class HousingController {

    private final UserRepository userRepository;
    private final HousingMapper housingMapper;
    private final HousingService housingService;
    private final UserService userService;

    public HousingController(UserRepository userRepository, HousingMapper housingMapper, HousingService housingService, UserService userService) {
        this.userRepository = userRepository;
        this.housingMapper = housingMapper;
        this.housingService = housingService;
        this.userService = userService;
    }
    @PostMapping("/saveHousing")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public HousingSavedResponse saveHousing(@RequestBody HousingRequest housingRequest, @AuthenticationPrincipal UserPrincipal userPrincipal){

        User owner = userRepository.getById(userPrincipal.getId());
        HousingDto housingDto = housingMapper.toHousingSaveDto(owner,housingRequest);
        HousingDto saved = housingService.saveHousing(owner,housingDto);
        HousingSavedResponse response = housingMapper.toHousingSaveResponse(saved);
        return response;
    }
    @PutMapping("/editHousing/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public HousingUpdateResponse updateHousing(@RequestBody HousingRequest housingRequest, @PathVariable Long id){
        HousingDto housingDto = housingMapper.toHousingUpdateDto(housingRequest);
        HousingDto saved = housingService.updateHousing(id,housingDto);
        HousingUpdateResponse response = housingMapper.toHousingUpdateResponse(id,saved);
        return response;

    }
    @GetMapping("/ownerHousing")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<HousingResponse> currentUserHousings(@AuthenticationPrincipal UserPrincipal userPrincipal,
                                                    @RequestParam(value = "page", defaultValue = "0") int page,
                                                    @RequestParam(value = "size", defaultValue = "3") int size,
                                                    @RequestParam(value = "housingName", required = false) String housingName,
                                                    @RequestParam(value = "numberOfFloors", required = false) int floors,
                                                    @RequestParam(value = "numberOfMasterRoom", required = false) int masterRoom,
                                                    @RequestParam(value = "numberOfSingleRoom", required = false) int singleRoom,
                                                    @RequestParam(value = "amount", required = false) Double amount,
                                                    @RequestParam(value = "createdDate", required = false) String postedDate
    ){
        String dateString = postedDate;
        String pattern = "yyyy-MM-dd";

        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        User user = userService.getUserById(userPrincipal.getId());
        List<HousingResponse> housingResponses = new ArrayList<>();
        List<Housing> housings = housingService.findByUserId(userPrincipal.getId(),page,size,housingName,floors,masterRoom,singleRoom,amount,date);
        for (Housing housing : housings){
            HousingDto housingDto = housingMapper.toHousingDto(housing,user);
            HousingResponse response = housingMapper.toHousingResponse(housingDto);
            housingResponses.add(response);
        }

        return housingResponses;
    }

    @GetMapping("/visitors/getAllHousings")
    public List<HousingResponse> getAllHousings(@RequestParam(value = "page", defaultValue = "0") int page,
                                                @RequestParam(value = "size", defaultValue = "3") int size,
                                                @RequestParam("housingName")String housingName,
                                                @RequestParam("floor")int floor,
                                                @RequestParam("masterRoom")int masterRoom,
                                                @RequestParam("amount")double amount,
                                                @RequestParam("singleRoom")int singleRoom,
                                                @RequestParam("postedDate")String postedDate){

        String dateString = postedDate;
        String pattern = "yyyy-MM-dd";

        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

//        Timestamp timestamp = new Timestamp(date.getTime());
        List<HousingResponse> housingResponses = new ArrayList<>();
        List<HousingDto> housingDtoList = housingService.getHousings(page,size,housingName,floor,masterRoom,amount,singleRoom,date);
        for (HousingDto housingDto: housingDtoList){
            HousingResponse response = housingMapper.toHousingResponse(housingDto);
            housingResponses.add(response);
        }
        return housingResponses;
    }
}
