package com.account.model.dto;

import com.account.model.domain.Account;
import com.account.util.CalendarUtil;

import java.math.BigDecimal;

public class AccountDTO {

    private Integer accountID;

    private String accountType;

    private String accountNumber;

    private String accountName;

    private BigDecimal balance;

    private String dateStr;

    public AccountDTO() {
    }

    public AccountDTO(Account account) {
        this.accountID = account.getAccountID();
        this.accountType = account.getAccountType();
        this.accountNumber = account.getAccountNumber();
        this.accountName = account.getAccountName();
        this.balance = account.getBalance();
        this.dateStr = CalendarUtil.getDefaultFormattedDate(account.getDate());
    }

    public Integer getAccountID() {
        return accountID;
    }

    public void setAccountID(Integer accountID) {
        this.accountID = accountID;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }
}
