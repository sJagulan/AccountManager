package com.person.controller;

import com.person.exception.AppsException;
import com.person.model.dto.PersonDTO;
import com.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping(value = "/savePerson", headers = "Accept=application/json")
    public ResponseEntity<PersonDTO> savePerson(@RequestBody PersonDTO updatePersonDTO) throws AppsException {

        PersonDTO personDTO = this.personService.savePerson(updatePersonDTO);

        return new ResponseEntity<>(personDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/getAllPerson", headers = "Accept=application/json")
    public ResponseEntity<List<PersonDTO>> getAllPerson() throws AppsException {

        List<PersonDTO> allPersons = this.personService.getAllPerson();

        return new ResponseEntity<>(allPersons, HttpStatus.OK);
    }

    @GetMapping(value = "/getPerson/{personID}", headers = "Accept=application/json")
    public ResponseEntity<PersonDTO> getPerson(@PathVariable Integer personID) throws AppsException {

        PersonDTO personDTO = this.personService.getPerson(personID);

        return new ResponseEntity<>(personDTO, HttpStatus.OK);
    }

    @PutMapping("/updatePerson/{personID}")
    public ResponseEntity<PersonDTO> updatePerson(@PathVariable Integer personID, @RequestBody PersonDTO updatePersonDTO) throws AppsException {

        PersonDTO personDTO = this.personService.updatePerson(personID, updatePersonDTO);

        return new ResponseEntity<>(personDTO, HttpStatus.OK);
    }

    @DeleteMapping("/deletePerson/{personID}")
    public ResponseEntity<Boolean> deletePerson(@PathVariable Integer personID) throws AppsException {

        Boolean isDelete = personService.deletePerson(personID);

        return new ResponseEntity<>(isDelete, HttpStatus.OK);
    }
}
