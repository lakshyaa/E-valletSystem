package com.example.walletsystem.demo.repository;

import com.example.walletsystem.demo.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserLoginRepository extends JpaRepository<UserAccount,Long> {

      public UserAccount findUserAccountByUsername(String username);

}
