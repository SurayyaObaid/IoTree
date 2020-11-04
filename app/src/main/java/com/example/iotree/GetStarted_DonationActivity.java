package com.example.iotree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class GetStarted_DonationActivity extends AppCompatActivity {
    Button skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started__donation);
        skip = findViewById(R.id.register);
        skip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent in = new Intent(GetStarted_DonationActivity.this,Registration.class);
                    startActivity(in);
                }
            });
    }
}