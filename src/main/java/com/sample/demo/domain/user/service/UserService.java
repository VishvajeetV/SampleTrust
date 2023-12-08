package com.sample.demo.domain.user.service;



import com.sample.demo.domain.user.db.models.User;
import com.sample.demo.service.BaseService;
import com.sample.demo.utils.Status;

import java.util.List;


public interface UserService extends BaseService<User, Long> {
    
    List<User> searchUser(Long id, String phoneNumber, String email, Status status);
}
