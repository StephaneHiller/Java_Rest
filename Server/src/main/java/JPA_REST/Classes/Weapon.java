package JPA_REST.Classes;

import javax.persistence.*;

/**
 * Created by stephane on 03/04/17.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "allWeapons", query = "select d from Weapon ")
})
public class Weapon {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    private String name;
    private String type;
    private String damageType;

    public Weapon() {
    }

    public Weapon(String name, String type, String damageType) {
        this.name = name;
        this.type = type;
        this.damageType = damageType;
    }


}
