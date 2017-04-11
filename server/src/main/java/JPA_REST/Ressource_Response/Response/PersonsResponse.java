package JPA_REST.Ressource_Response.Response;

import JPA_REST.Classes.Person;

import java.util.List;

/**
 * Created by stephane on 08/04/17.
 */
public class PersonsResponse {

    private List<Person> Persons;

    public PersonsResponse(List<Person> Persons){
        this.Persons = Persons;
    }
}
