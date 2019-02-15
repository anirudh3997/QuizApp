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



public class QwithImage extends AppCompatActivity {

    JSONArray jsnobject;
    TextView ctr;
    TextView q;
    String Array;
    int counter = 1,id;
    Button b1,b2,b3,b4;
    int[] ans = new int[10];
    Intent data = getIntent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qwith_image);
        Log.d("hi", "working here");
        Intent data = getIntent();
        Bundle b = getIntent().getExtras();
        q = findViewById(R.id.textView4);
        b1 = findViewById(R.id.btnop1);
        b2 = findViewById(R.id.btnop2);
        b3 = findViewById(R.id.btnop3);
        b4 = findViewById(R.id.btnop4);
        ctr = findViewById(R.id.tv_count);

        counter=data.getIntExtra("counter",counter);
        Log.e("counter val", String.valueOf(counter));
        ctr.setText(String.valueOf(counter));


        Array = b.getString("Array");
        if(counter>2)
        {
            Array=data.getStringExtra("array");
            Log.e("Array on intent",Array);

        }
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

        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("error", String.valueOf(e));
        }



    }

    public void onClick(View view) {
        Intent intent0= new Intent(QwithImage.this,QwithImage2.class);

        Log.i("Executed","Working");

        id = 0;
        ans[counter-1] = id;
        counter++;
        intent0.putExtra("counter",counter);
        intent0.putExtra("ans",ans);
        intent0.putExtra("array", Array);
        startActivity(intent0);
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