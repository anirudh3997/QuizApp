package com.example.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShowName extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_name);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        TextView tvParticipantName = findViewById(R.id.tvParticipantName);

        tvParticipantName.setText(name);
    }


    public void  StartQuiz(View view){
        Intent intent = new Intent(ShowName.this, QwithImage.class);
    }

}
