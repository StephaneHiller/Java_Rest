package JPA_REST.Controller;

import JPA_REST.Classes.Character;
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
        this.emf = Persistence.createEntityManagerFactory("H2");
        this.entityManager = emf.createEntityManager();
    }

    public void getAllWeapons() {
        EntityTransaction transac = entityManager.getTransaction();

        transac.begin();

        TypedQuery<Weapon> query = entityManager.createNamedQuery("allWeapons", Weapon.class);
        List<Weapon> weapons = query.getResultList();

        System.out.println("\n List of weapons :");
        for (Weapon weapon : weapons)
            System.out.println(weapon);

        transac.commit();
    }

}
