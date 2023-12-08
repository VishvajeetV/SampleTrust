package com.sample.demo.domain.user.api.mappers;

import com.sample.demo.domain.user.api.resources.UserDto;
import com.sample.demo.domain.user.db.models.User;
import com.sample.demo.mappers.BaseMapper;
import com.sample.demo.utils.Status;
import org.springframework.stereotype.Service;

@Service
public class UserMapper implements BaseMapper<User, UserDto> {

    @Override
    public User mapToModel(UserDto userDto) {
        if (userDto != null) {
            User user = new User();
            user.setId(userDto.getId());
            user.setUsername(userDto.getUsername());
            user.setName(userDto.getName());
            user.setEmail(userDto.getEmail());
            user.setPhoneNumber(userDto.getPhoneNumber());
            user.setRoleType(userDto.getRoleType());
            user.setIsSalesUser(userDto.getIsSalesUser());
            user.setIsCrmUser(userDto.getIsCrmUser());
            user.setExternalUserType(userDto.getExternalUserType());
            user.setIsExternalUser(userDto.getIsExternalUser());
            if (userDto.getStatus() != null)
                user.setStatus(Status.valueOf(userDto.getStatus()));
            user.setCreatedAt(userDto.getCreatedAt());
            user.setUpdatedAt(userDto.getUpdatedAt());
            user.setCreatedBy(userDto.getCreatedBy());
            user.setUpdatedBy(userDto.getUpdatedBy());
            return user;
        }
        return null;
    }

    @Override
    public UserDto mapToResource(User user) {
        if (user != null) {
            UserDto userDto = new UserDto();
            userDto.setId(user.getId());
            userDto.setUsername(user.getUsername());
            userDto.setName(user.getName());
            userDto.setEmail(user.getEmail());
            userDto.setPhoneNumber(user.getPhoneNumber());
            userDto.setRoleType(user.getRoleType());
            userDto.setIsSalesUser(user.getIsSalesUser());
            userDto.setIsCrmUser(userDto.getIsCrmUser());
            userDto.setExternalUserType(user.getExternalUserType());
            userDto.setIsExternalUser(user.getIsExternalUser());
            if (user.getStatus() != null)
                userDto.setStatus(user.getStatus().name());
            userDto.setCreatedAt(user.getCreatedAt());
            userDto.setUpdatedAt(user.getUpdatedAt());
            userDto.setCreatedBy(user.getCreatedBy());
            userDto.setUpdatedBy(user.getUpdatedBy());
            return userDto;
        }
        return null;
    }
}
