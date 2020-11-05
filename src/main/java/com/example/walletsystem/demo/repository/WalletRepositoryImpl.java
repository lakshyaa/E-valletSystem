package com.example.walletsystem.demo.repository;

import com.example.walletsystem.demo.model.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class WalletRepositoryImpl {

    @Autowired
    private WalletRepository walletRepository;

    public void save(Wallet wallet){

        walletRepository.save(wallet);
    }
    public Wallet findWalletByName(String wallet)
    {
        return walletRepository.findWalletByWalletName(wallet);
    }

}
