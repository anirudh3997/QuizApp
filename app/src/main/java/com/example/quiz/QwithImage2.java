package com.example.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class QwithImage2 extends AppCompatActivity {

    JSONArray jsnobject;
    TextView ctr;
    TextView q;
    int counter,id;
    Button b1,b2,b3,b4;
    int[] ans = new int[10];
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qwith_image2);
        q = findViewById(R.id.textView4);
        b1 = findViewById(R.id.btnop1);
        b2 = findViewById(R.id.btnop2);
        b3 = findViewById(R.id.btnop3);
        b4 = findViewById(R.id.btnop4);
        ctr= findViewById(R.id.tv_count1);
        Intent data = getIntent();
        count =data.getIntExtra("counter",0);
        Log.d("QwithImage2 Oncreate", String.valueOf(count));

        //Bundle b = getIntent().getExtras();
        ctr.setText(String.valueOf(count));
        Log.d("QwithImage2 Oncreate2", "working here");

    }

    public void onClick(View view) {

        //startActivity(intent0);

        id = 0;
        ans[counter-1] = id;
        Log.i("QwithImage2 onClick",String.valueOf(counter));

        counter++;
        Intent intent= new Intent(QwithImage2.this,QwithImage.class);
        intent.putExtra("counter",counter);
        Log.i("QwithImage2 onClick2", String.valueOf(counter));
        startActivity(intent);
        Log.i("QwithImage2 ans", String.valueOf(ans[0]));
        Log.i("QwithImage2 ans", String.valueOf(counter));
    }
/*
   public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.btnop1: Intent intent0= new Intent(this,QwithImage.class);

                                id = 0;
                                ans[counter-1] = id;
                                counter++;
                                startActivity(intent0.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
                                break;
            case R.id.btnop2: Intent intent1 = new Intent(QwithImage.this,QwithImage.class);
                 id = 1;
                ans[counter-1] = id;
                counter++;
                startActivity(intent1);
                break;

            case R.id.btnop3: Intent intent2 = new Intent(QwithImage.this,QwithImage.class);
                 id = 2;
                ans[counter-1] = id;
                counter++;
                startActivity(intent2);
                break;

            case R.id.btnop4: Intent intent3 = new Intent(QwithImage.this,QwithImage.class);
                 id = 3;
                ans[counter-1] = id;
                counter++;
                startActivity(intent3);
                break;


        }
    } */


}