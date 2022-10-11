package com.account.controller;

import com.account.exception.AppsException;
import com.account.model.dto.AccountDTO;
import com.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping(value = "/saveAccount", headers = "Accept=application/json")
    public ResponseEntity<AccountDTO> saveAccount(@RequestBody AccountDTO updateAccountDTO) throws AppsException {

        AccountDTO accountDTO = this.accountService.saveAccount(updateAccountDTO);

        return new ResponseEntity<>(accountDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/getAllAccount", headers = "Accept=application/json")
    public ResponseEntity<List<AccountDTO>> getAllAccount() throws AppsException {

        List<AccountDTO> allAccounts = this.accountService.getAllAccount();

        return new ResponseEntity<>(allAccounts, HttpStatus.OK);
    }

    @GetMapping(value = "/getAccount/{accountID}", headers = "Accept=application/json")
    public ResponseEntity<AccountDTO> getAccount(@PathVariable Integer accountID) throws AppsException {

        AccountDTO accountDTO = this.accountService.getAccount(accountID);

        return new ResponseEntity<>(accountDTO, HttpStatus.OK);
    }

    @PutMapping("/updateAccount/{accountID}")
    public ResponseEntity<AccountDTO> updateAccount(@PathVariable Integer accountID, @RequestBody AccountDTO updateAccountDTO) throws AppsException {

        AccountDTO accountDTO = this.accountService.updateAccount(accountID, updateAccountDTO);

        return new ResponseEntity<>(accountDTO, HttpStatus.OK);
    }

    @DeleteMapping("/deleteAccount/{id}")
    public ResponseEntity<Boolean> deleteAccount(@PathVariable(value = "id") Integer accountID) throws AppsException {

        Boolean isDeleted = accountService.deleteAccount(accountID);

        return new ResponseEntity<>(isDeleted, HttpStatus.OK);
    }
}
