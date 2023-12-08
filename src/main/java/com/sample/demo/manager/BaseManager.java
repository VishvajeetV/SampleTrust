package com.sample.demo.manager;


import com.sample.demo.controllers.ResponseDTO;
import com.sample.demo.domain.user.api.resources.UserDto;

import java.util.List;

public interface BaseManager <Resource, ID>{
    
    ResponseDTO<Resource> findById(ID id);
    
    ResponseDTO findAll();
    
    ResponseDTO<Resource> create(Resource resource);

    ResponseDTO<Resource> update(Resource resource);
    
}
