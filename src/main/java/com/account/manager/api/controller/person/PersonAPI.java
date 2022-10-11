package com.account.manager.api.controller.person;

import com.account.manager.api.dto.common.ResponseDTO;
import com.account.manager.api.dto.person.PersonDTO;
import com.account.manager.api.exception.AppsException;
import com.account.manager.api.service.person.PersonFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonAPI {

    @Autowired
    private PersonFeignClient personFeignClient;

    @PostMapping(value = "/savePerson", headers = "Accept=application/json")
    public ResponseEntity<ResponseDTO<PersonDTO>> savePerson(@RequestBody PersonDTO updatePersonDTO) {
        ResponseDTO<PersonDTO> response = new ResponseDTO<>();

        try {
            PersonDTO personDTO = this.personFeignClient.savePerson(updatePersonDTO);

            response.setResult(personDTO);
            response.setStatus("SUCCESS");
        } catch (AppsException e) {
            response.setStatus("FAILED");
            response.setAppsErrorMessages(e.getAppsErrorMessages());
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/getAllPerson", headers = "Accept=application/json")
    public ResponseEntity<ResponseDTO<List<PersonDTO>>> getAllPerson() {
        ResponseDTO<List<PersonDTO>> response = new ResponseDTO<>();

        try {
            List<PersonDTO> allPersons = this.personFeignClient.getAllPerson();

            response.setResult(allPersons);
            response.setStatus("SUCCESS");
        } catch (AppsException e) {
            response.setStatus("FAILED");
            response.setAppsErrorMessages(e.getAppsErrorMessages());
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/getPerson/{personID}", headers = "Accept=application/json")
    public ResponseEntity<ResponseDTO<PersonDTO>> getPerson(@PathVariable Integer personID) {
        ResponseDTO<PersonDTO> response = new ResponseDTO<>();

        try {
            PersonDTO personDTO = this.personFeignClient.getPerson(personID);

            response.setResult(personDTO);
            response.setStatus("SUCCESS");
        } catch (AppsException e) {
            response.setStatus("FAILED");
            response.setAppsErrorMessages(e.getAppsErrorMessages());
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/updatePerson/{personID}")
    public ResponseEntity<ResponseDTO<PersonDTO>> updatePerson(@PathVariable Integer personID, @RequestBody PersonDTO updatePersonDTO) {
        ResponseDTO<PersonDTO> response = new ResponseDTO<>();

        try {
            PersonDTO personDTO = this.personFeignClient.updatePerson(personID, updatePersonDTO);

            response.setResult(personDTO);
            response.setStatus("SUCCESS");
        } catch (AppsException e) {
            response.setStatus("FAILED");
            response.setAppsErrorMessages(e.getAppsErrorMessages());
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/deletePerson/{personID}")
    public ResponseEntity<ResponseDTO<Boolean>> deletePerson(@PathVariable Integer personID) {
        ResponseDTO<Boolean> response = new ResponseDTO<>();

        try {
            Boolean isDeleted = this.personFeignClient.deletePerson(personID);

            response.setResult(isDeleted);
            response.setStatus("SUCCESS");
        } catch (AppsException e) {
            response.setStatus("FAILED");
            response.setAppsErrorMessages(e.getAppsErrorMessages());
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
