package com.person.service;

import com.person.dao.PersonDao;
import com.person.exception.AppsException;
import com.person.model.domain.Person;
import com.person.model.dto.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonDao personDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public PersonDTO savePerson(PersonDTO updatePersonDTO) throws AppsException {
        Person person = new Person();

        person.setName(updatePersonDTO.getName());
        person.setAddress(updatePersonDTO.getAddress());
        person.setPostCode(updatePersonDTO.getPostCode());
        person.setAge(updatePersonDTO.getAge());
        person.setJob(updatePersonDTO.getJob());
        person.setEmail(updatePersonDTO.getEmail());
        person.setPhone(updatePersonDTO.getPhone());

        person = this.personDao.saveAndFlush(person);

        return new PersonDTO(person);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public PersonDTO getPerson(Integer personID) throws AppsException {
        Person person = this.personDao.getById(personID);

        if (person == null) {
            throw new AppsException("Can't find person for this ID");
        }

        return new PersonDTO(person);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<PersonDTO> getAllPerson() throws AppsException {
        List<PersonDTO> personDTOS = new ArrayList<>();
        List<Person> persons = this.personDao.findAll();

        for (Person person : persons) {
            personDTOS.add(new PersonDTO(person));
        }

        return personDTOS;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public PersonDTO updatePerson(Integer personID, PersonDTO updatePersonDTO) throws AppsException {
        Person person = this.personDao.getById(personID);

        if (person == null) {
            throw new AppsException("Can't find person for this ID");
        } else {
            person.setName(updatePersonDTO.getName());
            person.setAddress(updatePersonDTO.getAddress());
            person.setPostCode(updatePersonDTO.getPostCode());
            person.setAge(updatePersonDTO.getAge());
            person.setJob(updatePersonDTO.getJob());
            person.setEmail(updatePersonDTO.getEmail());
            person.setPhone(updatePersonDTO.getPhone());

            person = this.personDao.saveAndFlush(person);

            return new PersonDTO(person);
        }
    }

    public Boolean deletePerson(Integer personID) throws AppsException {
        Person person = this.personDao.getById(personID);

        if (person == null) {
            throw new AppsException("Can't find person for this ID");
        } else {
            this.personDao.delete(person);
            return true;
        }
    }
}
