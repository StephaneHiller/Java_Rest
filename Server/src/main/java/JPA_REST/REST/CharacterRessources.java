package JPA_REST.REST;

import JPA_REST.Classes.Character;
import JPA_REST.Controller.CharacterController;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by shiller994 on 20/01/17.
 */

@Path("Character")
public class CharacterRessources {

    CharacterController characterController = new CharacterController();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public void listeCharacters(){
        characterController.getAllCharacter();
    }

    @POST
    @Path("/{nameCharacter}")
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

    /*
    @DELETE
    @Path("/Delete/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public void deleteChien(@PathParam("name") String name){
        Character.deleteCharacter(name);
    }

    @PUT
    @Path("/{name}/to/{rename}")
    @Produces(MediaType.TEXT_PLAIN)
    public void changeName(@PathParam("name") String name , @PathParam("rename") String rename) {

        String response = Character.changeCharacterName(name,rename);
        System.out.println(response.toString());
    }
*/

}
