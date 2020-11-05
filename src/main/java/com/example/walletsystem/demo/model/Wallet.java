package com.example.walletsystem.demo.model;

import javax.persistence.*;

@Entity
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long walletId;

    @ManyToOne
    private UserAccount userAccount;

    private Long amount;

    public Character getWalletSymbol() {
        return walletSymbol;
    }

    public void setWalletSymbol(Character walletSymbol) {
        this.walletSymbol = walletSymbol;
    }

    private Character walletSymbol;




}
