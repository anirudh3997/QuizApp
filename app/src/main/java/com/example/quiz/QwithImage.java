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
    Intent intent0;
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
        if(counter>1)
        {
            Array=data.getStringExtra("array");
            Log.e("Array on intent",Array);

        }
        try {
            jsnobject = new JSONArray(Array);

            JSONObject jsonObj = jsnobject.getJSONObject(counter-1);
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

   /* public void onClick(View view) {
        if (counter<10)
        {
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
        else {
            Intent intent1= new Intent(QwithImage.this,DisplayScore.class);
            startActivity(intent1);

        }

    } */

    public void onClick(View view) {
        if (counter < 10) {
            switch (view.getId()) {
                case R.id.btnop1:
                    intent0 = new Intent(this,QwithImage2.class);
                    Log.i("Button1","Working");

                    id = 0;
                    ans[counter-1] = id;
                    counter++;
                    intent0.putExtra("counter",counter);
                    intent0.putExtra("ans",ans);
                    intent0.putExtra("array",Array);
                    startActivity(intent0);
                    break;
                case R.id.btnop2:
                    intent0= new Intent(this,QwithImage2.class);
                    Log.i("Button2","Working");

                    id = 1;
                    ans[counter-1] = id;
                    counter++;
                    intent0.putExtra("counter",counter);
                    intent0.putExtra("ans",ans);
                    intent0.putExtra("array",Array);
                    startActivity(intent0);
                    break;

                case R.id.btnop3:
                    intent0= new Intent(this,QwithImage2.class);
                    Log.i("Button3","Working");

                    id = 2;
                    ans[counter-1] = id;
                    counter++;
                    intent0.putExtra("counter",counter);
                    intent0.putExtra("ans",ans);
                    intent0.putExtra("array",Array);
                    startActivity(intent0);
                    break;

                case R.id.btnop4:
                    intent0= new Intent(this,QwithImage2.class);
                    Log.i("Button4","Working");

                    id = 3;
                    ans[counter-1] = id;
                    counter++;
                    intent0.putExtra("counter",counter);
                    intent0.putExtra("ans",ans);
                    intent0.putExtra("array",Array);
                    startActivity(intent0);
                    break;


            }
        }
        else {

            Intent intent1= new Intent(QwithImage.this,DisplayScore.class);
            startActivity(intent1);

        }

    }


}