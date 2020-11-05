package com.example.walletsystem.demo.service;

import com.example.walletsystem.demo.model.Wallet;
import com.example.walletsystem.demo.repository.WalletRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl {



    @Autowired
    private WalletRepositoryImpl walletRepository;

    public void save(Wallet wallet)
    {
        walletRepository.save(wallet);
    }

    public Wallet findWalletByName(String wallet)
    {

        walletRepository.
    }


}
