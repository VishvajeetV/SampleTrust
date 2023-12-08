package com.sample.demo.domain.user.api.rest;


import com.sample.demo.controllers.ResponseDTO;
import com.sample.demo.domain.user.api.manager.AddressManager;
import com.sample.demo.domain.user.api.resources.AddressDto;
import com.sample.demo.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("{resourceName}/address")
public class AddressController {
        @Autowired
        private AddressManager addressManager;
        
        @PostMapping(value = "")
        public ResponseDTO createAddress(@RequestBody AddressDto address) {
            return addressManager.create(address);
        }
        
        @GetMapping(value = "/{id}")
        public ResponseDTO findById(@PathVariable(name = "id") Long id) {
            return addressManager.findById(id);
        }

        @GetMapping(value = "")
        public ResponseDTO findAll() {
            return addressManager.findAll();
        }
    
    @GetMapping(value="/user/{userId}")
    public ResponseDTO searchAddressByUserIdAndStatus(@PathVariable(name = "userId") Long userId, @RequestParam(required = false) Status status){
        return addressManager.searchAddressByUserIdAndStatus(userId, status);
    }
        
    }
        