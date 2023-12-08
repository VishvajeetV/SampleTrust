package com.sample.demo.domain.user.api.manager;


import com.sample.demo.controllers.ResponseDTO;
import com.sample.demo.domain.user.api.mappers.AddressMapper;
import com.sample.demo.domain.user.api.resources.AddressDto;
import com.sample.demo.domain.user.db.models.Address;
import com.sample.demo.domain.user.service.AddressService;
import com.sample.demo.domain.user.util.Communications;
import com.sample.demo.manager.BaseManager;
import com.sample.demo.utils.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AddressManager implements BaseManager<AddressDto, Long> {
    
    @Autowired
    private AddressService addressService;
    
    @Autowired
    private AddressMapper addressMapper;
    
    
    @Override
    public ResponseDTO<AddressDto> findById(Long id) {
        try {
            log.info("inside address manager find by id: {}", id);
            Optional<Address> userOptional = addressService.findById(id);
            if (userOptional.isPresent()) {
                AddressDto dto = addressMapper.mapToResource(userOptional.get());
                return new ResponseDTO("200", "SUCCESS", true, dto);
            }
        } catch (Exception e) {
            log.error("Exception in address manager findById[{}], error message: {}, trace: {}", id, e.getMessage(), e.getStackTrace());
        }
        return ResponseDTO.errorResponse("Cannot find address", "200");
    }
    
    @Override
    public ResponseDTO findAll() {
        try {
            log.info(" inside address manager find All ");
            Iterable<Address> address = addressService.findAll();
            if (address != null && address.iterator().hasNext()) {
                List<AddressDto> dtos = addressMapper.mapAllToResource(address);
                return new ResponseDTO("200", "SUCCESS", true, dtos);
            }
        } catch (Exception e) {
            log.error("Exception in address manager findAll[], error message: {}, trace: {}", e.getMessage(), e.getStackTrace());
        }
        return ResponseDTO.errorResponse("Cannot find address", "200");
    }
    
    @Override
    public ResponseDTO<AddressDto> create(AddressDto addressDto) {
        String err  = Communications.ERR_SOMETHING_WENT_WRONG;
        try {
            log.info("inside address manager create[userDto: {}]", addressDto);
            AddressDto dto = addressMapper.mapToResource(addressService.create(addressMapper.mapToModel(addressDto)));
            return new ResponseDTO("200", "SUCCESS", true, dto);
        }catch (Exception e){
            log.error("Exception in create[], error message: {}, trace: {}",err,e.getMessage(), e.getStackTrace());
            return ResponseDTO.errorResponse(err, "500");
        }
        
    }
    public ResponseDTO searchAddressByUserIdAndStatus(Long userId, Status status) {
        try {
            log.info("inside address manager find by userId: {}", userId);
            List<AddressDto> addresses = addressService.searchAddressByUserIdAndStatus(userId, status);
               return new ResponseDTO("200", "SUCCESS", true, addresses);
        } catch (Exception e) {
            log.error("Exception in address manager findById[{}], error message: {}, trace: {}", userId, e.getMessage(), e.getStackTrace());
        }
        return ResponseDTO.errorResponse("Cannot find address or user is inactive", "200");
    }

    @Override
    public ResponseDTO<AddressDto> update(AddressDto addressDto) {
        String err = Communications.ERR_SOMETHING_WENT_WRONG;
        try {
            log.info("Inside address manager update[ addressDto: {}]", addressDto);
            AddressDto dto = addressMapper.mapToResource(addressService.update(addressMapper.mapToModel(addressDto)));
            return new ResponseDTO("200", "SUCCESS", true, dto);
        } catch (Exception e) {
            log.error("Exception in update[], error message: {}, trace: {}", e.getMessage(), e.getStackTrace());
        }
        return ResponseDTO.errorResponse(err, "200");
    }
    
}
