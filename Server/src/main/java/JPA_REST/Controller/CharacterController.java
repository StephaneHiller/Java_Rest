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

    public Character getCharacter(int id) {
        EntityTransaction transac = entityManager.getTransaction();

        transac.begin();

        Character character = entityManager.find(Character.class, id);
        transac.commit();
        return character;
    }

    public void deleteCharacter(int id) {
        EntityTransaction transac = entityManager.getTransaction();
        transac.begin();

        Character character = entityManager.find(Character.class, id);
        entityManager.remove(character);
        System.out.println("Character(s) removed !!!");

        transac.commit();
    }

    public Character changeCharacter(int id, Character newCharacter) {
        EntityTransaction transac = entityManager.getTransaction();
        transac.begin();

        Character character = entityManager.find(Character.class, id);
        character.update(newCharacter);
        entityManager.merge(character);
        transac.commit();
        return character;
    }
}
