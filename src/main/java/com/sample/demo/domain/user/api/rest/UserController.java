package com.sample.demo.domain.user.api.rest;

import com.sample.demo.controllers.ResponseDTO;
import com.sample.demo.domain.user.api.manager.UserManager;
import com.sample.demo.domain.user.api.resources.UserDto;
import com.sample.demo.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserManager userManager;

    @PostMapping(value = "")
    public ResponseDTO create(@RequestBody UserDto user) {
        return userManager.create(user);
    }

    @PostMapping("/create")
    public ResponseDTO<List<UserDto>> createUsers(@RequestBody List<UserDto> users) {
        return userManager.create(users);
    }

    @GetMapping(value = "/{id}")
    public ResponseDTO findById(@PathVariable(name = "id") Long id) {
        return userManager.findById(id);
    }

    @GetMapping(value = "")
    public ResponseDTO findAll() {
        return userManager.findAll();
    }

    @GetMapping(value = "/search")
    public ResponseDTO findByMobile(@RequestParam(name = "mobile", required = false) String phoneNumber,
                                    @RequestParam(name = "id", required = false) Long id,
                                    @RequestParam(name = "email", required = false) String email,
                                    @RequestParam(name = "status", required = false) Status status) {
        return userManager.searchUser(id, phoneNumber, email, status);
    }

    @PutMapping(value = "/update")
    public ResponseDTO update(@RequestBody UserDto userDto) {
        return userManager.update(userDto);
    }
}
