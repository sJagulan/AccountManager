package com.person.model.dto;

import com.person.model.domain.Person;

public class PersonDTO {

    private Integer personID;

    private String name;

    private String address;

    private String postCode;

    private Integer age;

    private String job;

    private String email;

    private String phone;

    public PersonDTO() {
    }

    public PersonDTO(Person person) {
        this.personID = person.getPersonID();
        this.name = person.getName();
        this.address = person.getAddress();
        this.postCode = person.getPostCode();
        this.age = person.getAge();
        this.job = person.getJob();
        this.email = person.getEmail();
        this.phone = person.getPhone();
    }

    public Integer getPersonID() {
        return personID;
    }

    public void setPersonID(Integer personID) {
        this.personID = personID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
