package engine.pp.service_ww_p.controller;

import engine.pp.service_ww_p.model.Person;
import engine.pp.service_ww_p.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component // Indicates this is a Spring-managed component
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }


    public Optional<Person> getPersonById(Long id) {
        return personService.getPersonById(id);
    }


    public Person createPerson(Person person) {
        return personService.createPerson(person);
    }


    public Optional<Person> updatePerson(Long id, Person personDetails) {
        return personService.updatePerson(id, personDetails);
    }


    public boolean deletePerson(Long id) {
        return personService.deletePerson(id);
    }
}
