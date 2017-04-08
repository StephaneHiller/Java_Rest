package JPA_REST.Ressource_Response.Response;

import JPA_REST.Classes.Character;

import java.util.List;

/**
 * Created by stephane on 08/04/17.
 */
public class CharactersResponse {

    private List<Character> characters;

    public CharactersResponse(List<Character> characters){
        this.characters = characters;
    }
}
