package JPA_REST.Ressource_Response.Ressource;

import JPA_REST.Classes.Character;
import JPA_REST.Controller.CharacterController;
import JPA_REST.UtilS.JsonObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by shiller994 on 20/01/17.
 */

@Path("Character")
public class CharacterRessources {

    CharacterController characterController = new CharacterController();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public void listeCharacters(){
        List<Character> characters = characterController.getAllCharacter();
        System.out.println(characters.toString());
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addCharacter(Character character){
        characterController.addCharacterInList(character);
        return "Character add ! \n";
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getChien(@PathParam("id") int id){
        Character character = characterController.getCharacter(id);
        String parameters = JsonObject.genCharacterJSON(character);
        return parameters;
    }

    @DELETE
    @Path("/Delete/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteChien(@PathParam("id") int id){
        characterController.deleteCharacter(id);
        return "Character deleted !";
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String changeName(@PathParam("id") int id , Character newCharacter) {
        characterController.changeCharacter(id,newCharacter);
        return "Character changed !";
    }


}
