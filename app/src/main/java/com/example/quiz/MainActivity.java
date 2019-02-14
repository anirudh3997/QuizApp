package com.example.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSignUp(View view) {
       // Intent intent=new Intent(MainActivity.this,SignUp.class);
        //startActivity(intent);
    }

    public void onSignIn(View view) {
       // Intent intent=new Intent(MainActivity.this,SignIn.class);
        //startActivity(intent);
    }
}
