package JPA_REST.UtilS;

import JPA_REST.Classes.Character;
import JPA_REST.Classes.Weapon;
import JPA_REST.Ressource_Response.Response.CharactersResponse;
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

    public static String genCharacterJSON(Character character) {
        Gson gson = new Gson();
        return gson.toJson(character);
    }

    public static String genCharactersJSON(List<Character> characters) {
        Gson gson = new Gson();
        CharactersResponse charactersResponse = new CharactersResponse(characters);
        return gson.toJson(charactersResponse);
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
