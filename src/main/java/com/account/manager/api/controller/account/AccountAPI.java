package com.account.manager.api.controller.account;

import com.account.manager.api.dto.account.AccountDTO;
import com.account.manager.api.dto.common.ResponseDTO;
import com.account.manager.api.exception.AppsException;
import com.account.manager.api.service.account.AccountFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountAPI {

    @Autowired
    private AccountFeignClient accountFeignClient;

    @PostMapping(value = "/saveAccount", headers = "Accept=application/json")
    public ResponseEntity<ResponseDTO<AccountDTO>> saveAccount(@RequestBody AccountDTO updateAccountDTO) {
        ResponseDTO<AccountDTO> response = new ResponseDTO<>();

        try {
            AccountDTO accountDTO = this.accountFeignClient.saveAccount(updateAccountDTO);

            response.setResult(accountDTO);
            response.setStatus("SUCCESS");
        } catch (AppsException e) {
            response.setStatus("FAILED");
            response.setAppsErrorMessages(e.getAppsErrorMessages());
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/getAllAccount", headers = "Accept=application/json")
    public ResponseEntity<ResponseDTO<List<AccountDTO>>> getAllAccount() {
        ResponseDTO<List<AccountDTO>> response = new ResponseDTO<>();

        try {
            List<AccountDTO> allAccounts = this.accountFeignClient.getAllAccount();

            response.setResult(allAccounts);
            response.setStatus("SUCCESS");
        } catch (AppsException e) {
            response.setStatus("FAILED");
            response.setAppsErrorMessages(e.getAppsErrorMessages());
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/getAccount/{accountID}", headers = "Accept=application/json")
    public ResponseEntity<ResponseDTO<AccountDTO>> getAccount(@PathVariable Integer accountID) {
        ResponseDTO<AccountDTO> response = new ResponseDTO<>();

        try {
            AccountDTO accountDTO = this.accountFeignClient.getAccount(accountID);

            response.setResult(accountDTO);
            response.setStatus("SUCCESS");
        } catch (AppsException e) {
            response.setStatus("FAILED");
            response.setAppsErrorMessages(e.getAppsErrorMessages());
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/updateAccount/{accountID}")
    public ResponseEntity<ResponseDTO<AccountDTO>> updateAccount(@PathVariable Integer accountID, @RequestBody AccountDTO updateAccountDTO) {
        ResponseDTO<AccountDTO> response = new ResponseDTO<>();

        try {
            AccountDTO accountDTO = this.accountFeignClient.updateAccount(accountID, updateAccountDTO);

            response.setResult(accountDTO);
            response.setStatus("SUCCESS");
        } catch (AppsException e) {
            response.setStatus("FAILED");
            response.setAppsErrorMessages(e.getAppsErrorMessages());
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/deleteAccount/{accountID}")
    public ResponseEntity<ResponseDTO<Boolean>> deleteAccount(@PathVariable Integer accountID) {
        ResponseDTO<Boolean> response = new ResponseDTO<>();

        try {
            Boolean isDeleted = accountFeignClient.deleteAccount(accountID);

            response.setResult(isDeleted);
            response.setStatus("SUCCESS");
        } catch (AppsException e) {
            response.setStatus("FAILED");
            response.setAppsErrorMessages(e.getAppsErrorMessages());
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
