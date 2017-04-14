package shiller994.masterdapm.univ_tln.fr.simpleapi.network;

import com.google.gson.JsonObject;

import org.androidannotations.rest.spring.annotations.Accept;
import org.androidannotations.rest.spring.annotations.Get;
import org.androidannotations.rest.spring.annotations.Path;
import org.androidannotations.rest.spring.annotations.Rest;
import org.androidannotations.rest.spring.api.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

/**
 * Created by stephane on 12/04/17.
 */

@Rest(rootUrl = "http://10.21.128.98:8080/myapp", converters = {GsonHttpMessageConverter.class})
@Accept(MediaType.APPLICATION_JSON)
public interface PersonAPI {

    @Get("/Persons")
    ResponseEntity<JsonObject> allCharacter();

    @Get("/Person/{name}")
    ResponseEntity<JsonObject> person(@Path String name);
}
