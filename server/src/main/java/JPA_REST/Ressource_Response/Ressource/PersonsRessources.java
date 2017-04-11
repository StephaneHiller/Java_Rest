package JPA_REST.Ressource_Response.Ressource;

import JPA_REST.Classes.Person;
import JPA_REST.Controller.PersonController;
import JPA_REST.UtilS.JsonObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


/**
 * Created by stephane on 08/04/17.
 */
@Path("/Persons")
public class PersonsRessources {

    private PersonController PersonController = new PersonController();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String get() {
        List<Person> Persons = PersonController.getAllPerson();
        String paramaters = JsonObject.genPersonsJSON(Persons);
        return paramaters;
    }
}
