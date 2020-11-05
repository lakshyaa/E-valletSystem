package com.example.walletsystem.demo.repository;

import com.example.walletsystem.demo.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet,Long> {


public Wallet findWalletByWalletName(String name);

}
