package com.example.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class QwithImage extends AppCompatActivity {

    JSONArray jsnobject;
    TextView ctr;
    TextView q;
    String Array;
    int counter = 1,id;
    Button b1,b2,b3,b4;
    int[] ans = new int[10];
    int[] ques = new int[10];
    Intent intent0;
    String URL="http://8eb53f7e.ngrok.io/api/answers";
    private RequestQueue requestQueue;


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
            ques = data.getIntArrayExtra("quesID");


        }
        try {
            jsnobject = new JSONArray(Array);

            JSONObject jsonObj = jsnobject.getJSONObject(counter-1);
            q.setText(jsonObj.getString("Qn"));
            ques[counter-1] = Integer.parseInt(jsonObj.getString("QnID"));
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
                    intent0.putExtra("quesID",ques);
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
                    intent0.putExtra("quesID",ques);

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
                    intent0.putExtra("quesID",ques);

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
                    intent0.putExtra("quesID",ques);

                    startActivity(intent0);
                    break;


            }
        }
        else {
            final ArrayList<Integer> abc = new ArrayList<Integer>();
            for(int i=0;i<10;i++)
            {
                abc.add(ques[i]);
            }
            final JSONArray push = new JSONArray(abc);
            Log.e("abc", push.toString());

            Intent intent1= new Intent(QwithImage.this,DisplayScore.class);
            final String s = Arrays.toString(ques);
            Log.e("Ques ID 2", s);

            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {

                @Override
                public void onResponse(String response) {
                    //  Toast.makeText(SignUp.this,"Success, Sign in now",Toast.LENGTH_SHORT).show();
                    Log.d("Working",response);

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(QwithImage.this, error + "", Toast.LENGTH_SHORT).show();
                    Log.d("Failed",error.toString());

                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("qIDs", ((Object)(abc)).toString());
                    Log.e("qwe",params.toString());
                    return params;
                }

            };
            requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);
            startActivity(intent1);

        }



    }


}