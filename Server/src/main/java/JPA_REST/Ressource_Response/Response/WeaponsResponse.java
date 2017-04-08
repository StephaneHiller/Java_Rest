package JPA_REST.Ressource_Response.Response;

import JPA_REST.Classes.Weapon;

import java.util.List;

/**
 * Created by stephane on 08/04/17.
 */
public class WeaponsResponse {

    private List<Weapon> weapons;

    public WeaponsResponse(List<Weapon> weapons){
        this.weapons = weapons;
    }
}
