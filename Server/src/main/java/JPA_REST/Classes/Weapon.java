package JPA_REST.Classes;

import javax.persistence.*;

/**
 * Created by stephane on 03/04/17.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "allWeapon" , query = "select d from Weapon d")
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

    public void update(Weapon weapon) {
        this.name = weapon.name;
        this.type = weapon.type;
        this.damageType = weapon.damageType;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDamageType() {
        return damageType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDamageType(String damageType) {
        this.damageType = damageType;
    }
}
