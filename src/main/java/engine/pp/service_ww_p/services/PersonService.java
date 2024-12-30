package engine.pp.service_ww_p.services;

import engine.pp.service_ww_p.dao.PersonDAO;
import engine.pp.service_ww_p.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonDAO personDao;

    @Autowired
    public PersonService(PersonDAO personDao) {
        this.personDao = personDao;
    }

    public List<Person> getAllPersons() {
        return personDao.findAll();
    }

    public Optional<Person> getPersonById(Long id) {
        return personDao.findById(id);
    }

    public Person createPerson(Person person) {
        personDao.save(person);
        return person;
    }

    public Optional<Person> updatePerson(Long id, Person personDetails) {
        Optional<Person> personOptional = personDao.findById(id);
        if(personOptional.isPresent()){
            personDetails.setId(id);
            personDao.update(personDetails);
            return  Optional.of(personDetails);
        }
        return Optional.empty();
    }

    public boolean deletePerson(Long id) {
        Optional<Person> personOptional = personDao.findById(id);
        if(personOptional.isPresent()){
            personDao.deleteById(id);
            return true;
        }
        return false;
    }
}
