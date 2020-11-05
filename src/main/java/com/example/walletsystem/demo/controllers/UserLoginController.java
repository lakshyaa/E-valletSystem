package com.example.walletsystem.demo.controllers;

import com.example.walletsystem.demo.dto.UserDto;
import com.example.walletsystem.demo.model.UserAccount;
import com.example.walletsystem.demo.model.Wallet;
import com.example.walletsystem.demo.repository.UserLoginRepository;
import com.example.walletsystem.demo.repository.UserLoginRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class UserLoginController {


    @Autowired
    private UserLoginRepositoryImpl userLoginRepository;
Logger logger=Logger.getLogger("UserLoginController.class");

    @GetMapping("/register")
    public String register(Model model)
    {
        model.addAttribute("user",new UserDto());
        return "register";
    }
    @PostMapping("register")
    public String  register(@Valid @ModelAttribute("user")UserDto user, BindingResult bindingResult, RedirectAttributes redirectAttributes)
    {

        if(bindingResult.hasErrors()) {
            return "register";
        }
        UserAccount userAccount=new UserAccount();
        userAccount.setUsername(user.getUsername());
        userAccount.setPassword(user.getPassword());
        userAccount.setFirstName(user.getFirstname()
        );
        userAccount.setLastName(user.getLastname());
        userAccount.setEmail(user.getEmail());
        List<Wallet> walletList=new ArrayList<>();
        /*
        Default two wallets are added on registration
         */
        userLoginRepository.save(userAccount);

      return "redirect:register?success";
    }
    @PostMapping("/authenticate")
    public ResponseEntity authenticate(UserDto user)
    {

        logger.info(user.getUsername());
        logger.info(user.getPassword());

       UserAccount userAccount=userLoginRepository.findUserByUsername(user.getUsername());

       if(userAccount ==null)
       {
           return ResponseEntity.status(HttpStatus.CONFLICT).body("No such user present!");

       }

       return  userAccount.getPassword().equals(user.getPassword())?ResponseEntity.status(HttpStatus.OK).body("Login successful"):ResponseEntity.status(HttpStatus.CONFLICT).body("Bad Password");

    }
}