package com.sample.demo.domain.user.service.impl;


import com.sample.demo.domain.user.db.dao.UserDao;
import com.sample.demo.domain.user.db.models.User;
import com.sample.demo.domain.user.service.UserService;
import com.sample.demo.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserDao userDao;

    @Override
    public Optional<User> findById(Long id) {
        return userDao.findById(id);
    }
    
    @Override
    public Iterable<User> findAll() {
        return userDao.findAll();
    }
    
    @Override
    public User create(User user) {
        return userDao.save(user);
    }
    
    @Override
    public User update(User user) {
        return userDao.save(user);
    }
    
    @Override
    public List<User> searchUser(Long id, String phoneNumber, String email, Status status){
        List<User> users = userDao.searchUser(id, phoneNumber, email, status);
      return users;
    }
}
