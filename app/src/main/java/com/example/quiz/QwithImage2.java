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
    String Array;
    int counter,id;
    Button b1,b2,b3,b4;
    int[] ans = new int[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qwith_image);
        Log.d("hi2", "working here");
        Intent data = getIntent();
        q = findViewById(R.id.textView4);
        b1 = findViewById(R.id.btnop1);
        b2 = findViewById(R.id.btnop2);
        b3 = findViewById(R.id.btnop3);
        b4 = findViewById(R.id.btnop4);

        Array = data.getStringExtra("array");
        counter=data.getIntExtra("counter",counter);

        Log.e("Array vakue in qwi2",Array);
        ctr=findViewById(R.id.tv_count);
        ctr.setText(String.valueOf(counter));
        int a[]= data.getIntArrayExtra("ans");

    }

    public void onClick(View view) {
        Intent intent0= new Intent(this,QwithImage.class);
        Log.i("Executed","Working");

        id = 0;
        ans[counter-1] = id;
        counter++;
        intent0.putExtra("counter",counter);
        intent0.putExtra("ans",ans);
        intent0.putExtra("array",Array);
        startActivity(intent0);
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