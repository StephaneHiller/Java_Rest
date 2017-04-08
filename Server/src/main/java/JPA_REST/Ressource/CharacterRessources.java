package JPA_REST.Ressource;

import JPA_REST.Classes.Character;
import JPA_REST.Controller.CharacterController;

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
    @Path("/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public void getChien(@PathParam("name") String name){
        characterController.getCharacter(name);
    }


    @DELETE
    @Path("/Delete/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public void deleteChien(@PathParam("name") String name){
        characterController.deleteCharacter(name);
    }

    @PUT
    @Path("/{name}/to/{rename}")
    @Produces(MediaType.TEXT_PLAIN)
    public void changeName(@PathParam("name") String name , @PathParam("rename") String rename) {
        characterController.changeCharacterName(name,rename);
    }


}
