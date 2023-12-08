package com.sample.demo.domain.user.service;


import com.sample.demo.domain.user.api.resources.AddressDto;
import com.sample.demo.domain.user.db.models.Address;
import com.sample.demo.service.BaseService;
import com.sample.demo.utils.Status;

import java.util.List;

public interface AddressService extends BaseService<Address, Long> {
    
    List<AddressDto> searchAddressByUserIdAndStatus(Long userid, Status status);

}
