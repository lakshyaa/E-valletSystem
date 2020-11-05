package com.example.walletsystem.demo;



import com.example.walletsystem.demo.repository.UserLoginRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class UniqueUserNameValidator implements ConstraintValidator<UniqueUserName,String> {


    @Autowired
    private UserLoginRepositoryImpl userLoginRepository;


    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        return username!=null && userLoginRepository.findUserByUsername(username)==null;
    }
}
