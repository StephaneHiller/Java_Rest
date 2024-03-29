package JPA_REST.Classes;

import javax.persistence.*;
import java.util.List;


/**
 * Created by stephane on 03/04/17.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "allPerson" , query = "select d from Person d"),
        @NamedQuery(name = "findPerson", query = "select d from Person d where d.name = :name")
})
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    private String name;
    private int level;
    private String role;

    public Person() {
    }

    public Person(String name, int level, String role) {
        this.name = name;
        this.level = level;
        this.role = role;
    }


    public void update(Person Person) {
        this.name = Person.name;
        this.level = Person.level;
        this.role = Person.role;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public String getRole() {
        return role;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setRole(String role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "Hi! My name is " + name + ", I'm a " + role + " lvl:" + level + ".  || Id : " + Id;
    }
}
