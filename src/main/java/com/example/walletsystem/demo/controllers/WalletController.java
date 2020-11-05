package com.example.walletsystem.demo.controllers;

import com.example.walletsystem.demo.model.UserAccount;
import com.example.walletsystem.demo.model.Wallet;
import com.example.walletsystem.demo.model.WalletTransaction;
import com.example.walletsystem.demo.repository.UserLoginRepositoryImpl;
import com.example.walletsystem.demo.service.WalletServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.logging.Logger;

@RestController
@RequestMapping("/wallet/do")
public class WalletController {

    @Autowired
    private WalletServiceImpl walletService;


    @Autowired
    private UserLoginRepositoryImpl userLoginRepository;

  Logger logger=Logger.getLogger("WalletController.class");


    @RequestMapping(path="/{username}/{money}/{wallet}")
    public ResponseEntity addMoneyToUserWallet(@PathVariable("username") String username, @PathVariable("money") String moneyToAdd, @PathVariable("wallet") String wallet)
    {



        logger.info(username+"money is="+moneyToAdd+"to wallet"+wallet);

     return ResponseEntity.status(HttpStatus.OK).body("transaction completed");

    }

    @RequestMapping(path="newwallet/{username}/{wallet}")
    public ResponseEntity createWallet(@PathVariable("username") String username,@PathVariable("wallet")String wallet) {


        UserAccount userAccount=userLoginRepository.findUserByUsername(username);

        if(userAccount!=null)
        {
            Wallet wallet1=new Wallet(wallet);
            wallet1.setUserAccount(userAccount);
            userAccount.getWallets().add(wallet1);
            userLoginRepository.save(userAccount);
            walletService.save(wallet1);
            return ResponseEntity.status(HttpStatus.OK).body("created a wallet with name="+wallet);
        }

    return ResponseEntity.status(HttpStatus.CONFLICT).body("Can't create a new account user does not exist");
    }




}
