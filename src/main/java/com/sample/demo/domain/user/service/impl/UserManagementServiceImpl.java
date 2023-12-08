package com.sample.demo.domain.user.service.impl;


import com.sample.demo.domain.user.api.mappers.UserMapper;
import com.sample.demo.domain.user.db.dao.UserDao;
import com.sample.demo.domain.user.service.UserManagementService;
import com.sample.demo.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManagementServiceImpl implements UserManagementService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserMapper userMapper;
    public Boolean updateStatus(Long userid, Status status){
        if (userid != null) {
            return 1 == userDao.updateStatus(userid, status);
        }
        return false;
    }

}