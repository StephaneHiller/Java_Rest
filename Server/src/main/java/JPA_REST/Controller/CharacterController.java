package JPA_REST.Controller;

import JPA_REST.Classes.Character;

import javax.persistence.*;
import java.util.List;

/**
 * Created by stephane on 03/04/17.
 */
public class CharacterController {

    EntityManager entityManager;
    EntityManagerFactory emf;

    public CharacterController() {
        this.emf = Persistence.createEntityManagerFactory("H2");
        this.entityManager = emf.createEntityManager();
    }

    public void addCharacterInList(Character character) {

        EntityTransaction transac = entityManager.getTransaction();

        transac.begin();
        entityManager.persist(character);
        transac.commit();
    }

    public void getAllCharacter() {


        EntityTransaction transac = entityManager.getTransaction();

        transac.begin();

        TypedQuery<Character> query = entityManager.createNamedQuery("allCharacter", Character.class);
        List<Character> characters = query.getResultList();

        System.out.println("\n List of character :");
        for (Character item : characters)
            System.out.println(item);

        transac.commit();
    }

    public void getCharacter(String name) {
        EntityTransaction transac = entityManager.getTransaction();

        transac.begin();

        TypedQuery<Character> query = entityManager.createNamedQuery("findCharacter", Character.class);
        query.setParameter("name", name);
        List<Character> characters = query.getResultList();

        System.out.println("\n Character :");
        for (Character item : characters)
            System.out.println(item);

        transac.commit();
    }
}
