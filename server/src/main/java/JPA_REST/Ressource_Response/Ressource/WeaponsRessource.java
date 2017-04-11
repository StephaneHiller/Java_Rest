package JPA_REST.Ressource_Response.Ressource;

import JPA_REST.Classes.Weapon;
import JPA_REST.Controller.WeaponController;
import JPA_REST.UtilS.JsonObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by stephane on 08/04/17.
 */

@Path("/Weapons")
public class WeaponsRessource {

    private WeaponController weaponController = new WeaponController();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String get() {
        List<Weapon> weapons = weaponController.getAllWeapons();
        String paramaters = JsonObject.genWeaponsJSON(weapons);
        return paramaters;
    }
}
