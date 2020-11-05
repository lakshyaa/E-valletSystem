package com.example.walletsystem.demo.model;

import javax.persistence.*;

@Entity
public class Wallet {


    public Wallet()
    {

    }

    public  Wallet(String walletName)
    {
        this.walletName=walletName;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long walletId;

    @ManyToOne
    private UserAccount userAccount;

    private Long amount;


    public long getWalletId() {
        return walletId;
    }

    public void setWalletId(long walletId) {
        this.walletId = walletId;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getWalletName() {
        return walletName;
    }

    public void setWalletName(String walletName) {
        this.walletName = walletName;
    }

    private String walletName;




}
