package com.sdProject.scoreDEI.Person;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public void addPerson(Person person) {
        personRepository.save(person);
    }

    public List<Person> getAllUsers() {
        List<Person> users = new ArrayList<>();
        personRepository.findAll().forEach(users::add);
        return users;
    }
}
