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
    int counter = 1,id;
    Button b1,b2,b3,b4;
    int[] ans = new int[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qwith_image);
        Log.d("hi2", "working here");
        Intent data = getIntent();
        Bundle b = getIntent().getExtras();
        q = findViewById(R.id.textView4);
        b1 = findViewById(R.id.btnop1);
        b2 = findViewById(R.id.btnop2);
        b3 = findViewById(R.id.btnop3);
        b4 = findViewById(R.id.btnop4);
        ctr = findViewById(R.id.tv_count);
        Intent intent = getIntent();
        Log.d("hi3", "working here");

        String c = intent.getStringExtra("counter");
        ctr.setText(c);
        Log.d("hi4", "Working"+c);

        String Array = b.getString("Array");
        try {
            jsnobject = new JSONArray(Array);

            JSONObject jsonObj = jsnobject.getJSONObject(0);
            q.setText(jsonObj.getString("Qn"));

            JSONArray op = jsonObj.getJSONArray("Options");

            Log.e("option", op.getString(0));
            b1.setText(op.getString(0));
            b2.setText(op.getString(1));
            b3.setText(op.getString(2));
            b4.setText(op.getString(3));
            //b1.setText((CharSequence) op.getJSONObject(0));

        } catch (JSONException e) {
            e.printStackTrace();
        }



    }

    public void onClick(View view) {
        Intent intent0= new Intent(this,QwithImage.class);
        Log.i("Executed","Working");

        id = 0;
        ans[counter-1] = id;
        counter++;
        startActivity(intent0.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
        Log.i("ans", String.valueOf(ans[0]));
        Log.i("ctr", String.valueOf(counter));
    }

   /*public void onClick(View view)
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