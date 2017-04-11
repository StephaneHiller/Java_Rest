package JPA_REST.Controller;

import JPA_REST.Classes.Weapon;
import JPA_REST.Classes.Weapon;

import javax.persistence.*;
import java.util.List;

/**
 * Created by stephane on 03/04/17.
 */
public class WeaponController {

    EntityManager entityManager;
    EntityManagerFactory emf;

    public WeaponController() {
        this.emf = Persistence.createEntityManagerFactory("jdbc");
        this.entityManager = emf.createEntityManager();
    }

    public void addWeaponInList(Weapon Weapon) {

        EntityTransaction transac = entityManager.getTransaction();
        transac.begin();
        entityManager.persist(Weapon);
        transac.commit();
    }

    public List<Weapon> getAllWeapons() {
        EntityTransaction transac = entityManager.getTransaction();
        transac.begin();
        TypedQuery<Weapon> query = entityManager.createNamedQuery("allWeapon", Weapon.class);
        List<Weapon> weapons = query.getResultList();
        return weapons;
    }

    public Weapon getWeapon(int id) {
        EntityTransaction transac = entityManager.getTransaction();

        transac.begin();

        Weapon weapon = entityManager.find(Weapon.class, id);
        transac.commit();
        return weapon;
    }

    public void deleteWeapon(int id) {
        EntityTransaction transac = entityManager.getTransaction();
        transac.begin();

        Weapon Weapon = entityManager.find(Weapon.class, id);
        entityManager.remove(Weapon);
        transac.commit();
    }

    public Weapon changeWeapon(int id, Weapon newWeapon) {
        EntityTransaction transac = entityManager.getTransaction();
        transac.begin();

        Weapon Weapon = entityManager.find(Weapon.class, id);
        Weapon.update(newWeapon);
        entityManager.merge(Weapon);
        transac.commit();
        return Weapon;
    }
}
