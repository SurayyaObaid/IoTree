package com.example.iotree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class GetStarted_PredictionActivity extends AppCompatActivity {
    ImageButton pnext;
    Button skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started__prediction);
        pnext = findViewById(R.id.pnext);
        skip = findViewById(R.id.skip);

        pnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(GetStarted_PredictionActivity.this,GetStarted_MaintencanceActivity.class);
                startActivity(in);
            }
        });
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(GetStarted_PredictionActivity.this,Registration.class);
                startActivity(in);
            }
        });
    }
}