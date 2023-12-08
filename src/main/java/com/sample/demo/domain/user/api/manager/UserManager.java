package com.sample.demo.domain.user.api.manager;

import com.sample.demo.controllers.ResponseDTO;
import com.sample.demo.domain.user.service.UserManagementService;
import com.sample.demo.domain.user.service.UserService;
import com.sample.demo.domain.user.service.validation.UserValidationService;
import com.sample.demo.domain.user.util.Communications;
import com.sample.demo.exceptions.BusinessException;
import com.sample.demo.exceptions.CustomException;
import com.sample.demo.manager.BaseManager;
import com.sample.demo.domain.user.api.mappers.UserMapper;
import com.sample.demo.domain.user.api.resources.UserDto;
import com.sample.demo.domain.user.db.models.User;
import com.sample.demo.utils.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserManager implements BaseManager<UserDto, Long> {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserManagementService userManagementService;

    @Override
    public ResponseDTO<UserDto> findById(Long id) {
        try {
            log.info("Inside user manager find by id: {}", id);
            Optional<User> userOptional = userService.findById(id);
            if (userOptional.isPresent()) {
                UserDto dto = userMapper.mapToResource(userOptional.get());
                return new ResponseDTO("200", "SUCCESS", true, dto);
            }
        } catch (Exception e) {
            log.error("Exception in findById[{}], error message: {}, trace: {}", id, e.getMessage(), e.getStackTrace());
        }
        return ResponseDTO.errorResponse("Cannot find user", "200");
    }

    @Override
    public ResponseDTO<Iterable<UserDto>> findAll() {
        try {
            log.info("Inside user manager find All");
            Iterable<User> user = userService.findAll();
            if (user != null && user.iterator().hasNext()) {
                List<UserDto> dtos = userMapper.mapAllToResource(user);
                return new ResponseDTO("200", "SUCCESS", true, dtos);
            }
        } catch (Exception e) {
            log.error("Exception in findAll[], error message: {}, trace: {}", e.getMessage(), e.getStackTrace());
        }
        return ResponseDTO.errorResponse("Can not find any user", "200");
    }

    @Override
    public ResponseDTO<UserDto> create(UserDto userDto) {
        try {
            log.info("Inside user manager create[userDto: {}]", userDto);
            UserValidationService.performUserValidations(userDto);
            UserDto dto = userMapper.mapToResource(userService.create(userMapper.mapToModel(userDto)));
            return new ResponseDTO("200", "SUCCESS", true, dto);
        }catch (CustomException e) {
            throw e;
        }catch (Exception e) {
            log.error("Exception in user manager create ,userDto: {}, error message: {}, trace: {}", userDto, e.getMessage(), e.getStackTrace());
            throw new BusinessException(Communications.ERR_USER_NOT_CREATED);
        }
    }
    public ResponseDTO<List<UserDto>> create(List<UserDto> userDtos) {
        List<UserDto> createdUsers = new ArrayList<>();

        try {
            log.info("Inside user manager create [userDtos: {}]", userDtos);
            for (UserDto userDto : userDtos) {
                UserValidationService.performUserValidations(userDto);
                UserDto dto = userMapper.mapToResource(userService.create(userMapper.mapToModel(userDto)));
                createdUsers.add(dto);
            }
            return new ResponseDTO<>("200", "SUCCESS", true, createdUsers);
        } catch (CustomException e) {
            throw e;
        } catch (Exception e) {
            log.error("Exception in user manager create, error message: {}, trace: {}", e.getMessage(), e.getStackTrace());
            throw new BusinessException(Communications.ERR_USER_NOT_CREATED);
        }
    }



    @Override
    public ResponseDTO<UserDto> update(UserDto userDto) {
        String err = Communications.ERR_SOMETHING_WENT_WRONG;
        try {
            log.info("Inside update[userDto: {}]", userDto);
            UserValidationService.performUserValidations(userDto);
            UserDto dto = userMapper.mapToResource(userService.update(userMapper.mapToModel(userDto)));
            return new ResponseDTO("200", "SUCCESS", true, dto);
        } catch (Exception e) {
            log.error("Exception in update[], error message: {}, trace: {}", e.getMessage(), e.getStackTrace());
        }
        return ResponseDTO.errorResponse(err, "200");
    }

    public ResponseDTO searchUser(Long id, String phoneNumber, String email, Status status) {
        try {
            log.info("Inside user manager searchUser[id: {}, phoneNumber: {}, email: {}, city: {}, roleType: {}, status: {} ]", id, phoneNumber, email, status);
            List<User> users = userService.searchUser(id, phoneNumber, email, status);
            if (users != null && !users.isEmpty()) {
                List<UserDto> dtos = userMapper.mapAllToResource(users);
                return new ResponseDTO("200", "SUCCESS", true, dtos);
            }
        } catch (Exception e) {
            log.error("Exception in phoneNumber[{}], error message: {}, trace: {}", phoneNumber, e.getMessage(), e.getStackTrace());
        }
        return ResponseDTO.errorResponse("Cannot find user", "200");
    }
}
