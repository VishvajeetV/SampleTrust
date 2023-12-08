package com.sample.demo.domain.user.service.impl;


import com.sample.demo.domain.user.api.resources.AddressDto;
import com.sample.demo.domain.user.db.dao.AddressDao;
import com.sample.demo.domain.user.db.models.Address;
import com.sample.demo.domain.user.service.AddressService;
import com.sample.demo.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
 public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDao addressDao;

    @Override
    public Optional<Address> findById(Long id) {
        return addressDao.findById(id);
    }

    @Override
    public Iterable<Address> findAll() {
        return addressDao.findAll();
    }

    @Override
    public Address create(Address address) {
        return addressDao.save(address);
    }

    @Override
    public Address update(Address address) {
        return addressDao.save(address);
    }

    @Override
    public List<AddressDto> searchAddressByUserIdAndStatus(Long userid, Status status) {
        return addressDao.searchAddressByUserIdAndStatus(userid, status);
    }
}
