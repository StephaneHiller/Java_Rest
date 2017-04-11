package JPA_REST.Controller;

import JPA_REST.Classes.Person;

import javax.persistence.*;
import java.util.List;

/**
 * Created by stephane on 03/04/17.
 */
public class PersonController {

    EntityManager entityManager;
    EntityManagerFactory emf;

    public PersonController() {
        this.emf = Persistence.createEntityManagerFactory("jdbc");
        this.entityManager = emf.createEntityManager();
    }

    public void addPersonInList(Person Person) {

        EntityTransaction transac = entityManager.getTransaction();
        transac.begin();
        entityManager.persist(Person);
        transac.commit();
    }

    public List<Person> getAllPerson() {
        EntityTransaction transac = entityManager.getTransaction();
        transac.begin();
        TypedQuery<Person> query = entityManager.createNamedQuery("allPerson", Person.class);
        List<Person> Persons = query.getResultList();
        return Persons;
    }

    public Person getPerson(int id) {
        EntityTransaction transac = entityManager.getTransaction();

        transac.begin();

        Person Person = entityManager.find(Person.class, id);
        transac.commit();
        return Person;
    }

    public void deletePerson(int id) {
        EntityTransaction transac = entityManager.getTransaction();
        transac.begin();

        Person Person = entityManager.find(Person.class, id);
        entityManager.remove(Person);
        System.out.println("Person(s) removed !!!");

        transac.commit();
    }

    public Person changePerson(int id, Person newPerson) {
        EntityTransaction transac = entityManager.getTransaction();
        transac.begin();

        Person Person = entityManager.find(Person.class, id);
        Person.update(newPerson);
        entityManager.merge(Person);
        transac.commit();
        return Person;
    }
}
