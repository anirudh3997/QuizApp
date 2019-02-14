package com.example.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class QwithImage extends AppCompatActivity {

    JSONArray jsnobject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qwith_image);
        Log.d("hi", "working here");
        Intent data = getIntent();
        Bundle b = getIntent().getExtras();
        String Array =b.getString("Array");
        try {
                jsnobject = new JSONArray(Array);

                JSONObject jsonObj = jsnobject.getJSONObject(0);
                Log.e("hi wtf", String.valueOf(jsonObj));
               // System.out.println(jsonObj);

        } catch (JSONException e) {
            e.printStackTrace();
        }



    }

}
