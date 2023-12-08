package com.sample.demo.domain.user.service.validation;

import com.sample.demo.domain.user.api.resources.UserDto;
import com.sample.demo.domain.user.util.Communications;
import com.sample.demo.exceptions.InvalidInputException;

public class UserValidationService {
    
   
    public static  Boolean phoneNumberValidation(String phoneNumber) throws InvalidInputException
    {
        if(phoneNumber == null || phoneNumber.isEmpty()){
            throw new InvalidInputException(Communications.ERR_PHONE_NUMBER_BLANK, 400);
        }else if(phoneNumber.length() < 10) {
            throw new InvalidInputException(Communications.ERR_PHONE_NUMBER_INVALID, 400);
        }
        return true;
    }
    
    public static  Boolean emailValidation(String email) throws InvalidInputException
    {
        int count=0;
        if(email == null || email.isEmpty()){
            throw new InvalidInputException(Communications.ERR_EMAIL_BLANK, 400);
        }else if(!email.contains("@")) {
            throw new InvalidInputException(Communications.ERR_EMAIL_INVALID, 400);
        }
        return true;
    }
    
    public static void performUserValidations(UserDto userDto) throws InvalidInputException{
        phoneNumberValidation(userDto.getPhoneNumber());
        emailValidation(userDto.getEmail());
    }
}
