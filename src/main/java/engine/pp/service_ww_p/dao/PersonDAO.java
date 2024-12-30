package engine.pp.service_ww_p.dao;

import engine.pp.service_ww_p.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonDAO {

    private List<Person> osoby = new ArrayList<>();
    private Long nextId = 1L; // Prosta symulacja autoinkrementacji ID

    public void save(Person osoba) {
        osoba.setId(nextId++); // Automatyczne nadawanie ID
        osoby.add(osoba);
    }

    public Optional<Person> findById(Long id) {
        return osoby.stream()
                .filter(osoba -> osoba.getId().equals(id))
                .findFirst();
    }

    public List<Person> findAll() {
        return new ArrayList<>(osoby); // Zwracamy kopię listy, aby uniknąć modyfikacji z zewnątrz
    }

    public void update(Person osoba) {
        for (int i = 0; i < osoby.size(); i++) {
            if (osoby.get(i).getId().equals(osoba.getId())) {
                osoby.set(i, osoba);
                return;
            }
        }
    }

    public void deleteById(Long id) {
        osoby.removeIf(osoba -> osoba.getId().equals(id));
    }
}
