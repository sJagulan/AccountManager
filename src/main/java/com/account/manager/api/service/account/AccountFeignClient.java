package com.account.manager.api.service.account;

import com.account.manager.api.dto.account.AccountDTO;
import com.account.manager.api.exception.AppsException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "account", url = "http://localhost:8082/")
public interface AccountFeignClient {

    @PostMapping(value = "/account/saveAccount", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    AccountDTO saveAccount(@RequestBody AccountDTO updateAccountDTO) throws AppsException;

    @GetMapping(value = "/account/getAllAccount", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    List<AccountDTO> getAllAccount() throws AppsException;

    @GetMapping(value = "/account/getAccount/{accountID}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    AccountDTO getAccount(@PathVariable Integer accountID) throws AppsException;

    @PutMapping(value = "/account/updateAccount/{accountID}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    AccountDTO updateAccount(@PathVariable Integer accountID, @RequestBody AccountDTO updateAccountDTO) throws AppsException;

    @DeleteMapping(value = "/account/deleteAccount/{accountID}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    Boolean deleteAccount(@PathVariable Integer accountID) throws AppsException;
}
