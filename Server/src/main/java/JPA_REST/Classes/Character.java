package JPA_REST.Classes;

import javax.persistence.*;
import javax.xml.stream.events.Characters;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stephane on 03/04/17.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "allCharacter" , query = "select d from Character d"),
        @NamedQuery(name = "findCharacter", query = "select d from Character d where d.name = :name")
})
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    private String name;
    private int level;

    public Character() {
    }

    public Character(String name, int level) {
        this.name = name;
        this.level = level;
    }




/*


    public static String deleteCharacter(String name) {
        int tailleInit, tailleFinal;
        tailleInit = Characters.size();
        for(int i= 0; i<Characters.size();i++){
            if (Characters.get(i).equals(name)){
                Characters.remove(i);
                i--;
            }
        }
        tailleFinal = Characters.size();
        if(tailleInit > tailleFinal) {
            return "Character delete !! \n";
        }
        else{
            return "No character with this name !! \n";
        }
    }

    public static String changeCharacterName(String name, String rename) {
        int cpt =0;
        for(int i = 0; i< Characters.size();i++){
            if (Characters.get(i).equals(name)){
                Characters.set(i,rename);
                cpt++;
            }
        }
        if(cpt != 0){
            return "Name changed !! \n";
        }
        else {
            return "No character with this name !! \n";
        }
    }
*/
    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
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

    @Override
    public String toString() {
        return "Character{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", level=" + level +
                '}';
    }
}
