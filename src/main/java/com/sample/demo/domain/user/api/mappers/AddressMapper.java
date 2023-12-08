package com.sample.demo.domain.user.api.mappers;

import com.sample.demo.domain.user.api.resources.AddressDto;
import com.sample.demo.domain.user.db.models.Address;
import com.sample.demo.domain.user.util.Communications;
import com.sample.demo.exceptions.MappingException;
import com.sample.demo.mappers.BaseMapper;
import com.sample.demo.utils.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AddressMapper implements BaseMapper<Address, AddressDto> {
    
    @Autowired
    private UserMapper userMapper;
        @Override
        public Address mapToModel(AddressDto addressDto) {
           try {
               Address address = new Address();
               address.setId(addressDto.getId());
               address.setAddressLine1(addressDto.getAddressLine1());
               address.setAddressLine2(addressDto.getAddressLine2());
               address.setCity(addressDto.getCity());
               address.setState(addressDto.getState());
               address.setCountry(addressDto.getCountry());
               address.setPinCode(addressDto.getPinCode());
               address.setStatus(Status.valueOf(addressDto.getStatus()));
               address.setCreatedAt(addressDto.getCreatedAt());
               address.setUpdatedAt(addressDto.getUpdatedAt());
               address.setUser(userMapper.mapToModel(addressDto.getUser()));
               return address;
           }catch (MappingException e){
               throw e;
           }catch (Exception e){
               log.error("getting Exception while mapping address mapToModel error msg: {}, error: {}", e.getMessage(), e.getStackTrace());
               throw new MappingException(Communications.ERR_MAPPING_ADDRESS_MTM);
           }
        }
        
        @Override
        public AddressDto mapToResource(Address address) {
          try {
              AddressDto addressDto = new AddressDto();
              addressDto.setId(address.getId());
              addressDto.setAddressLine1(address.getAddressLine1());
              addressDto.setAddressLine2(address.getAddressLine2());
              addressDto.setCity(address.getCity());
              addressDto.setState(address.getState());
              addressDto.setCountry(address.getCountry());
              addressDto.setPinCode(address.getPinCode());
              addressDto.setStatus(address.getStatus().name());
              addressDto.setCreatedAt(address.getCreatedAt());
              addressDto.setUpdatedAt(address.getUpdatedAt());
              addressDto.setUser(userMapper.mapToResource(address.getUser()));
              return addressDto;

          }catch (MappingException e){
              throw e;
          }catch (Exception e){
              log.error("getting Exception while mapping address mapToResource error msg: {}, error: {}", e.getMessage(), e.getStackTrace());
              throw new MappingException(Communications.ERR_MAPPING_ADDRESS_MTM);
          }
        }
    }
