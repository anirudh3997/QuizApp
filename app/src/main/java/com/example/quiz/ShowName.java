package com.example.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ShowName extends AppCompatActivity {
    private RequestQueue queue;
    private String url = "http://28663af4.ngrok.io/api/questions";
    JSONArray pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_name);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        TextView tvParticipantName = findViewById(R.id.tvParticipantName);

        tvParticipantName.setText(name);
    }


    public void  StartQuiz(View view){


        Log.e("Hi","working");
        queue = Volley.newRequestQueue(this);
        final JsonArrayRequest objectRequest = new JsonArrayRequest(
                Request.Method.GET,
                url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for ( int i = 0; i < response.length(); i++) {
                        JSONObject participant = response.getJSONObject(i);
                        Log.e("Getfromapi",participant.toString());
                    }
                    Log.e("response", String.valueOf((response)));
                    pass=response;


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

        Log.e("pass value", String.valueOf(pass));
        Intent showname = new Intent(ShowName.this, QwithImage.class);
        showname.putExtra("participant", String.valueOf(pass));
        startActivity(showname);

    }

}
