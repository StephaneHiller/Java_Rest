package JPA_REST.Ressource;

import JPA_REST.Classes.Character;
import JPA_REST.Controller.CharacterController;
import JPA_REST.UtilS.JsonObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


/**
 * Created by stephane on 08/04/17.
 */
@Path("/Characters")
public class CharactersRessources {

    private CharacterController characterController = new CharacterController();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String get() {
        List<Character> characters = characterController.getAllCharacter();
        String paramaters = JsonObject.genCharactersJSON(characters);
        return paramaters;
    }
}
