package com.sample.demo.domain.user.db.dao;


import com.sample.demo.domain.user.api.resources.AddressDto;
import com.sample.demo.domain.user.db.models.Address;
import com.sample.demo.utils.Status;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressDao extends CrudRepository<Address, Long> {
   @Query(
      value =
          "select new com.sample.demo.domain.user.api.resources.AddressDto( "
              + "a.id, a.addressLine1, a.addressLine2, a.city, a.pinCode, a.country, a.state, "
              +  "a.status, a.createdAt, a.updatedAt, a.user.id) from Address a where a.user.id = :userId "
              + " and (:status is NULL or a.status = :status)")
   List<AddressDto> searchAddressByUserIdAndStatus(Long userId, Status status);
   
   
    }
