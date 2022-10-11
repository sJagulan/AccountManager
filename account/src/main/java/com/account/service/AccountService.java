package com.account.service;

import com.account.dao.AccountDao;
import com.account.exception.AppsException;
import com.account.model.domain.Account;
import com.account.model.dto.AccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountDao accountDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public AccountDTO saveAccount(AccountDTO updateAccountDTO) throws AppsException {
        Account account = new Account();

        account.setAccountType(updateAccountDTO.getAccountType());
        account.setAccountNumber(updateAccountDTO.getAccountNumber());
        account.setAccountName(updateAccountDTO.getAccountName());
        account.setBalance(updateAccountDTO.getBalance());
        account.setDate(new Date());

        account = this.accountDao.saveAndFlush(account);

        return new AccountDTO(account);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public AccountDTO getAccount(Integer accountID) throws AppsException {
        Account account = this.accountDao.getById(accountID);

        if (account == null) {
            throw new AppsException("Can't find account for this ID");
        }

        return new AccountDTO(account);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<AccountDTO> getAllAccount() throws AppsException {
        List<AccountDTO> accountDTOS = new ArrayList<>();
        List<Account> accounts = this.accountDao.findAll();

        for (Account account : accounts) {
            accountDTOS.add(new AccountDTO(account));
        }

        return accountDTOS;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public AccountDTO updateAccount(Integer accountID, AccountDTO updateAccountDTO) throws AppsException {
        Account account = this.accountDao.getById(accountID);

        if (account == null) {
            throw new AppsException("Can't find account for this ID");
        } else {
            account.setAccountType(updateAccountDTO.getAccountType());
            account.setAccountNumber(updateAccountDTO.getAccountNumber());
            account.setAccountName(updateAccountDTO.getAccountName());
            account.setBalance(updateAccountDTO.getBalance());
            account.setDate(new Date());

            account = this.accountDao.saveAndFlush(account);

            return new AccountDTO(account);
        }
    }

    public Boolean deleteAccount(Integer accountID) throws AppsException {
        Account account = this.accountDao.getById(accountID);

        if (account == null) {
            throw new AppsException("Can't find account for this ID");
        } else {
            accountDao.delete(account);
            return true;
        }
    }
}
