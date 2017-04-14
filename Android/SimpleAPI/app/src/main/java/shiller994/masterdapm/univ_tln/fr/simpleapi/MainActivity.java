package shiller994.masterdapm.univ_tln.fr.simpleapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.rest.spring.annotations.RestService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

import shiller994.masterdapm.univ_tln.fr.simpleapi.network.PersonAPI;


@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity  {


    RequestQueue file;

    @ViewById(R.id.b_get)
    Button b_get;

    @ViewById(R.id.b_post)
    Button b_post;

    @ViewById(R.id.b_put)
    Button b_put;


    @ViewById(R.id.b_getAll)
    Button b_getAll;

    @ViewById(R.id.text)
    TextView t_text;

    @ViewById(R.id.e_id)
    EditText e_id;

    @ViewById(R.id.e_name)
    EditText e_name;

    @ViewById(R.id.e_Level)
    EditText e_level;

    @ViewById(R.id.e_role)
    EditText e_role;

    @RestService
    PersonAPI personAPI;

    private static final String TAG = MainActivity.class.getSimpleName();

    @AfterViews
    public void initialize() {
        
        file = Volley.newRequestQueue(this);

    }

    @Click(R.id.b_get)
    void get() {

        String url = "http://10.21.128.98:8080/myapp/Person/" + e_id.getText().toString();

        StringRequest request = new StringRequest(Request.Method.GET, url,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Display the first 500 characters of the response string.
                t_text.setText("Response is: "+ response.toString());
                //Log.d("test","ici");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                t_text.setText("That didn't work!");
            }
        });
        file.add(request);
    }

    @Click(R.id.b_getAll)
    void getAll() {

        String url = "http://10.21.128.98:8080/myapp/Persons";

        StringRequest request = new StringRequest(Request.Method.GET, url,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Display the first 500 characters of the response string.
                t_text.setText("Response is: "+ response.toString());
                //Log.d("test","ici");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                t_text.setText("That didn't work!");
            }
        });
        file.add(request);


    }


    @Click(R.id.b_post)
    void post(){

        try {
            String url = "http://10.21.128.98:8080/myapp/Person/"/* + e_text.getText().toString()*/;
            final JSONObject json;
            json = new JSONObject("{\"name\":\""+ e_name.getText().toString() +"\",\"level\":" + e_level.getText().toString() +",\"role\":\" " + e_role.getText().toString() + " \"}");

            t_text.setText(json.toString());

            Log.i("TEST",json.toString());

            JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, json, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    t_text.setText("Character add !");
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    t_text.setText("That doesn't work!");
                    Log.i("TEST",error.toString());

                }
            });
            file.add(request);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Click(R.id.b_put)
    void changeCharacter(){

        try {
            String url = "http://10.21.128.98:8080/myapp/Person/" + e_id.getText().toString();
            final JSONObject json;
            json = new JSONObject("{\"name\":\""+ e_name.getText().toString() +"\",\"level\":" + e_level.getText().toString() +",\"role\":\" " + e_role.getText().toString() + " \"}");

            Log.i("TEST",json.toString());

            JsonObjectRequest request = new JsonObjectRequest(Request.Method.PUT, url, json, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    t_text.setText("Character changed");
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    t_text.setText("That doesn't work!");
                    Log.i("TEST",error.toString());

                }
            });
            file.add(request);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Click(R.id.b_delete)
    void delete() {
        String url = "http://10.21.128.98:8080/myapp/Person/Delete/" + e_id.getText().toString();

        StringRequest request = new StringRequest(Request.Method.DELETE, url,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Display the first 500 characters of the response string.
                t_text.setText("Character deleted !");
                //Log.d("test","ici");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                t_text.setText("That didn't work!");
            }
        });
        file.add(request);

    }

}
