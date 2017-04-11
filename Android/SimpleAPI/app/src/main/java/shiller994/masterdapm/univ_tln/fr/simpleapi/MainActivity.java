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
import org.json.JSONException;
import org.json.JSONObject;


@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity  {


    RequestQueue file;

    @ViewById(R.id.b_get)
    Button b_get;

    @ViewById(R.id.b_post)
    Button b_post;

    @ViewById(R.id.b_getAll)
    Button b_getAll;

    @ViewById(R.id.text)
    TextView t_text;

    @ViewById(R.id.e_id)
    EditText e_text;



    @AfterViews
    public void initialize() {
        
        file = Volley.newRequestQueue(this);

    }

    @Click(R.id.b_get)
    void get() {

        String url = "http://192.168.1.88:8080/myapp/Person/" + e_text.getText().toString();
        //String url = "https://www.google.com";

        //Toast.makeText(this, "test", Toast.LENGTH_SHORT).show();

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

        String url = "http://192.168.1.88:8080/myapp/Persons";
        //String url = "https://www.google.com";

        //Toast.makeText(this, "test", Toast.LENGTH_SHORT).show();

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
    void post()  {

        String url = "http://192.168.1.88:8080/myapp/Person";
        String textJson = "{\"name\":\"xyz\",\"level\":55, \"role\":\"TEST33\" }";
        JSONObject json = null;
        try {
            json = new JSONObject(textJson);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        t_text.setText(json.toString());


        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, json, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                t_text.setText("Character add");
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
