package JPA_REST.Test;

import JPA_REST.Classes.Person;
import JPA_REST.Classes.Weapon;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stephane on 03/04/17.
 */
public class Test1 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("H2");
        EntityManager em = emf.createEntityManager();

        Person c1 = new Person("Yhujiko", 1 , "Priest");
        Person c2 = new Person("Waemiko", 2, "Druid");
        Person c3 = new Person("Lannae", 3, "Mage");
        Person c4 = new Person("Chaeton", 4, "War");

        Weapon w1 = new Weapon("Dadao","Sword","Sharp");
        Weapon w2 = new Weapon("Morgenstern","Mace","Blunt");
        Weapon w3 = new Weapon("Axe","Axe","Sharp");


        EntityTransaction transac = em.getTransaction();

        transac.begin();
        em.persist(c1);
        em.persist(c2);
        em.persist(c3);
        em.persist(c4);
        em.persist(w1);
        em.persist(w2);
        em.persist(w3);
        transac.commit();
    }
}
