package com.example.iotree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class GetStarted_GardenerActivity extends AppCompatActivity {
    ImageButton gnext;
    Button skip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started__gardener);
        gnext = findViewById(R.id.gnext);
        skip = findViewById(R.id.skip);

            gnext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent in = new Intent(GetStarted_GardenerActivity.this,GetStarted_DonationActivity.class);
                    startActivity(in);
                }
            });
            skip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent in = new Intent(GetStarted_GardenerActivity.this,Registration.class);
                    startActivity(in);
                }
            });
    }
}