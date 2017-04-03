package JPA_REST.Test;

import JPA_REST.Classes.Character;

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
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("testh2");
        EntityManager em = emf.createEntityManager();

        Character c1 = new Character("name1", 1);
        Character c2 = new Character("name2", 2);
        Character c3 = new Character("name3", 3);
        Character c4 = new Character("name4", 4);



        EntityTransaction transac = em.getTransaction();

        transac.begin();
        em.persist(c1);
        em.persist(c2);
        em.persist(c3);
        em.persist(c4);
        transac.commit();
    }
}
