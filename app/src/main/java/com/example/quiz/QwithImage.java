package com.example.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;


public class QwithImage extends AppCompatActivity {

    StringBuilder a = new StringBuilder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qwith_image);
        Log.d("hi", "working here");
        Intent data = getIntent();
        Bundle b = getIntent().getExtras();
        String Array =b.getString("Array");
        Log.e("hi wtf", Array);
        try {
            JSONArray jsonArray = new JSONArray(Array);
            for (int i=0; i < jsonArray.length();i++)
            {
                
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}