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

    public List<Character> getAllCharacter() {
        EntityTransaction transac = entityManager.getTransaction();
        transac.begin();
        TypedQuery<Character> query = entityManager.createNamedQuery("allCharacter", Character.class);
        List<Character> characters = query.getResultList();
        return characters;
    }


    /*
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
*/
    public void getCharacter(String name) {
        EntityTransaction transac = entityManager.getTransaction();

        transac.begin();

        TypedQuery<Character> query = entityManager.createNamedQuery("findCharacter", Character.class);
        query.setParameter("name", name);
        List<Character> characters = query.getResultList();

        System.out.println("\n Character :");
        for (Character character : characters)
            System.out.println(character);

        transac.commit();
    }

    public void deleteCharacter(String name) {
        EntityTransaction transac = entityManager.getTransaction();
        transac.begin();

        TypedQuery<Character> query = entityManager.createNamedQuery("findCharacter", Character.class);
        query.setParameter("name", name);
        List<Character> characters = query.getResultList();

        for (Character character : characters)
            entityManager.remove(character);

        System.out.println("Character(s) removed !!!");

        transac.commit();
    }

    public void changeCharacterName(String name, String rename) {
        EntityTransaction transac = entityManager.getTransaction();
        transac.begin();

        TypedQuery<Character> query = entityManager.createNamedQuery("findCharacter", Character.class);
        query.setParameter("name", name);
        List<Character> characters = query.getResultList();

        for (Character character : characters) {
            character.setName(rename);
            System.out.println(character.toString());
        }

        System.out.println("Character(s) renamed !!! ");

        transac.commit();

    }
}
