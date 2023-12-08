package com.sample.demo.domain.user.service;


import com.sample.demo.utils.Status;

public interface UserManagementService {
    Boolean updateStatus(Long userid, Status status);
}
