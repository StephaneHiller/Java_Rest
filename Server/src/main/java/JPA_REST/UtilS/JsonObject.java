package JPA_REST.UtilS;

import JPA_REST.Classes.Character;
import JPA_REST.Ressource.CharactersResponse;
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
    public static String genCharactersJSON(List<Character> characters) {
        Gson gson = new Gson();
        CharactersResponse charactersResponse = new CharactersResponse(characters);
        return gson.toJson(charactersResponse);
    }




}
