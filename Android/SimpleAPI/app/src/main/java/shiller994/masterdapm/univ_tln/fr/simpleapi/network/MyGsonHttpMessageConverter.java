package shiller994.masterdapm.univ_tln.fr.simpleapi.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

import java.util.Arrays;
import java.util.List;

import static org.springframework.http.converter.json.GsonHttpMessageConverter.DEFAULT_CHARSET;

/**
 * Created by stephane on 12/04/17.
 */
public class MyGsonHttpMessageConverter extends GsonHttpMessageConverter {
    /**
     * Override MediaType for GsonHttpMessageConverter
     */
    public MyGsonHttpMessageConverter() {
        List<MediaType> types = Arrays.asList(
                new MediaType("text", "html", DEFAULT_CHARSET),
                new MediaType("application", "json", DEFAULT_CHARSET),
                new MediaType("application", "*+json", DEFAULT_CHARSET)
        );

        Gson customGson = new GsonBuilder()
                .create();

        super.setGson(customGson);
        super.setSupportedMediaTypes(types);
    }
}