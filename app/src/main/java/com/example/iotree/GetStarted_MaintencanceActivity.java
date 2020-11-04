package com.example.iotree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class GetStarted_MaintencanceActivity extends AppCompatActivity {
    ImageButton mnext;
    Button skip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started__maintencance);

        mnext = findViewById(R.id.mnext);
        skip = findViewById(R.id.skip);

            mnext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent in = new Intent(GetStarted_MaintencanceActivity.this,GetStarted_GardenerActivity.class);
                    startActivity(in);
                }
            });
            skip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent in = new Intent(GetStarted_MaintencanceActivity.this,Registration.class);
                    startActivity(in);
                }
            });
    }

}