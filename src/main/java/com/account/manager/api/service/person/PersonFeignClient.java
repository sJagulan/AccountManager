package com.account.manager.api.service.person;

import com.account.manager.api.dto.person.PersonDTO;
import com.account.manager.api.exception.AppsException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "person", url = "http://localhost:8081/")
public interface PersonFeignClient {

    @PostMapping(value = "/person/savePerson", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    PersonDTO savePerson(@RequestBody PersonDTO updatePersonDTO) throws AppsException;

    @GetMapping(value = "/person/getAllPerson", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    List<PersonDTO> getAllPerson() throws AppsException;

    @GetMapping(value = "/person/getPerson/{personID}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    PersonDTO getPerson(@PathVariable Integer personID) throws AppsException;

    @PutMapping(value = "/person/updatePerson/{personID}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    PersonDTO updatePerson(@PathVariable Integer personID, @RequestBody PersonDTO updatePersonDTO) throws AppsException;

    @DeleteMapping(value = "/person/deletePerson/{personID}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    Boolean deletePerson(@PathVariable Integer personID) throws AppsException;
}
