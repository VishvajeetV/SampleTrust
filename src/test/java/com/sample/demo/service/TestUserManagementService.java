//package com.sample.demo.service;
//
//import com.sample.demo.domain.user.service.UserManagementService;
//import com.sample.demo.utils.Status;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.testng.annotations.Ignore;
//
//@SpringBootTest
//@Ignore
//public class TestUserManagementService {
//    @Autowired
//    UserManagementService userManagementService;
//
//    @Test
//    public void testUpdateStatus() {
//            Boolean r = userManagementService.updateStatus(1L, Status.ACTIVE);
//            Assertions.assertTrue(r);
//    }
//
//    @Test
//    public void testUpdateStatusNotFound() {
//            Boolean r = userManagementService.updateStatus(-1L, Status.ACTIVE);
//            Assertions.assertFalse(r);
//    }
//}
