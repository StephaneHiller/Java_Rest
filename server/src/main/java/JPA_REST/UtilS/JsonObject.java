package JPA_REST.UtilS;

import JPA_REST.Classes.Person;
import JPA_REST.Classes.Weapon;
import JPA_REST.Ressource_Response.Response.PersonsResponse;
import JPA_REST.Ressource_Response.Response.WeaponsResponse;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by stephane on 08/04/17.
 */



public class JsonObject {


    /**
     * Parse parameters to JSON
     * @return Test json.
     */

    public static String genPersonJSON(Person Person) {
        Gson gson = new Gson();
        return gson.toJson(Person);
    }

    public static String genPersonsJSON(List<Person> Persons) {
        Gson gson = new Gson();
        PersonsResponse PersonsResponse = new PersonsResponse(Persons);
        return gson.toJson(PersonsResponse);
    }

    public static String genWeaponJSON(Weapon weapon) {
        Gson gson = new Gson();
        return gson.toJson(weapon);
    }

    public static String genWeaponsJSON(List<Weapon> weapons) {
        Gson gson = new Gson();
        WeaponsResponse weaponsResponse = new WeaponsResponse(weapons);
        return gson.toJson(weaponsResponse);
    }



}
