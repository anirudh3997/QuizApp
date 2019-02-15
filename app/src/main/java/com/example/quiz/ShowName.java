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
public class ShowName extends AppCompatActivity {
    private RequestQueue queue;
    private String url = "http://8eb53f7e.ngrok.io/api/questions";
    String pass="";
    StringBuilder s = new StringBuilder();


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

                s.append(response);

                Log.e("pass string", String.valueOf(s));


                Log.e("pass value", String.valueOf(s));
                Intent showname = new Intent(ShowName.this, QwithImage.class);
                Bundle b = new Bundle();
                b.putString("Array",s.toString());
                showname.putExtras(b);
                startActivity(showname);
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
