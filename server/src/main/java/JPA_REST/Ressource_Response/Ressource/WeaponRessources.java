package JPA_REST.Ressource_Response.Ressource;

import JPA_REST.Classes.Weapon;
import JPA_REST.Controller.WeaponController;
import JPA_REST.Controller.WeaponController;
import JPA_REST.UtilS.JsonObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by stephane on 03/04/17.
 */
@Path("Weapon")
public class WeaponRessources {
    WeaponController WeaponController = new WeaponController();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public void getWeapons(){
        List<Weapon> Weapons = WeaponController.getAllWeapons();
        System.out.println(Weapons.toString());
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addWeapon(Weapon Weapon){
        WeaponController.addWeaponInList(Weapon);
        return "Weapon add ! \n";
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getWeapon(@PathParam("id") int id){
        Weapon Weapon = WeaponController.getWeapon(id);
        String parameters = JsonObject.genWeaponJSON(Weapon);
        return parameters;
    }

    @DELETE
    @Path("/Delete/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteWeapon(@PathParam("id") int id){
        WeaponController.deleteWeapon(id);
        return "Weapon deleted !";
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String changeName(@PathParam("id") int id , Weapon newWeapon) {
        WeaponController.changeWeapon(id,newWeapon);
        return "Weapon changed !";
    }
}
