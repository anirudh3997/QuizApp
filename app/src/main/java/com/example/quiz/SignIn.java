package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SignIn extends AppCompatActivity {

    private RequestQueue queue;
    private String url = "http://28663af4.ngrok.io/api/getparticipants";
    EditText Name,EMail;
    int i;
    //StringBuilder ApiName=new StringBuilder();
    // String ApiMobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        Name=(EditText)findViewById(R.id.etNameSignIn);
        EMail=(EditText)findViewById(R.id.etMailSignIn);
    }

    public void Validate(View view){


        queue = Volley.newRequestQueue(this);
        final JsonArrayRequest objectRequest = new JsonArrayRequest(
                Request.Method.GET,
                url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for ( i = 0; i < response.length(); i++) {
                        Log.e("forloop",String.valueOf(i));
                        JSONObject user = response.getJSONObject(i);
                        Log.e("Getfromapi",user.toString());
                        Log.e("GetfromapiName",user.getString("Name"));
                        Log.d("Api",Name.getText().toString());
                        Log.d("Api",user.getString("Email"));

                        Log.d("Count",String.valueOf(response.length()));
                        if(Name.getText().toString().equals(user.getString("Name")) &&
                                EMail.getText().toString().equals(user.getString("Email"))){
                            Intent Goto = new Intent(SignIn.this, ShowName.class);
                           // Log.i("executed1","finished");
                            Goto.putExtra("name",user.getString("Name"));
                            setResult(RESULT_OK, Goto);
                            startActivity(Goto);
                            Toast.makeText(SignIn.this,"Welcome "+user.getString("Name"),Toast.LENGTH_LONG).show();

                        }
                        if(i >= (response.length())){
                            Toast.makeText(SignIn.this,"Sorry Wrong Name or Email. Please Try Again",Toast.LENGTH_LONG).show();
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.e("onResponse: ", e.toString());
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Not Working", error.toString());
            }
        }

        );

        // Add the request to the RequestQueue.
        queue.add(objectRequest);


    }


}
