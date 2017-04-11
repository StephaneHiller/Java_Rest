package JPA_REST.Ressource_Response.Ressource;

import JPA_REST.Classes.Person;
import JPA_REST.Controller.PersonController;
import JPA_REST.UtilS.JsonObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by shiller994 on 20/01/17.
 */

@Path("Person")
public class PersonRessources {

    PersonController PersonController = new PersonController();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public void listePersons(){
        List<Person> Persons = PersonController.getAllPerson();
        System.out.println(Persons.toString());
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addPerson(Person Person){
        PersonController.addPersonInList(Person);
        return "Person add ! \n";
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getChien(@PathParam("id") int id){
        Person Person = PersonController.getPerson(id);
        String parameters = JsonObject.genPersonJSON(Person);
        return parameters;
    }

    @DELETE
    @Path("/Delete/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteChien(@PathParam("id") int id){
        PersonController.deletePerson(id);
        return "Person deleted !";
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String changeName(@PathParam("id") int id , Person newPerson) {
        PersonController.changePerson(id,newPerson);
        return "Person changed !";
    }


}
