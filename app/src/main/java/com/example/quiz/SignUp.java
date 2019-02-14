package com.example.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class SignUp extends AppCompatActivity {
    private RequestQueue requestQueue;

    EditText name,mail;
    String URL = "http://28663af4.ngrok.io/api/insertparticipant";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        name = (EditText) findViewById(R.id.etNameSignUp);
        mail = (EditText) findViewById(R.id.etMailSignUp);
    }

    public void onRegister(View view) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Toast.makeText(SignUp.this,"Success, Sign in now",Toast.LENGTH_SHORT).show();

                Intent signin = new Intent(SignUp.this,SignIn.class);

                startActivity(signin);

                Log.d("Working",response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SignUp.this, error + "", Toast.LENGTH_SHORT).show();
                Log.d("Failed",error.toString());

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Name", name.getText().toString());
                params.put("Email", mail.getText().toString());

                return params;
            }

        };
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
        Log.e("Working Last",name.toString());
    }
}
