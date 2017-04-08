package JPA_REST.Ressource;

import JPA_REST.Controller.WeaponController;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by stephane on 03/04/17.
 */
@Path("Weapon")
public class WeaponRessources {

    WeaponController weaponController = new WeaponController();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public void listeCharacters(){ weaponController.getAllWeapons();
    }

}
