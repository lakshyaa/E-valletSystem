package com.example.walletsystem.demo.repository;

import com.example.walletsystem.demo.model.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserLoginRepositoryImpl  {

   @Autowired
   private UserLoginRepository userLoginRepository;


    public UserAccount findUserByUsername(String username) {
        return userLoginRepository.findUserAccountByUsername(username);
    }

    public void save(UserAccount userAccount)
    {
        userLoginRepository.save(userAccount);
    }

}
