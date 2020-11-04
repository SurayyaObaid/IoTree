package com.example.iotree;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class PlantDescription extends AppCompatActivity {

    ImageView image;
    TextView title, price;
    Toolbar toolbar;
    Button layoutButton;
    Calendar c;
    String todaysDate, currentTime;
    BottomNavigationView btm_nav;
    EditText quantity;

    Button addtocart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_description);
        title = findViewById(R.id.protitle);
        price = findViewById(R.id.proprice);
        image = findViewById(R.id.proimg);
        quantity = findViewById(R.id.quantity);
        String quantitytext= quantity.getText().toString();
        //toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent in= getIntent();
        Bundle desc = getIntent().getExtras();
        title.setText(desc.getString("title"));
        price.setText(desc.getString("price"));
        //layoutButton = findViewById(R.id.buttonLayout);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int resId = bundle.getInt("image");
            image.setImageResource(resId);

        }
        addtocart = findViewById(R.id.addtocart);
        addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String url = "http://hibabintetariq.stig.pk/addtocart.php";
                StringRequest stringRequest = new StringRequest(1, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(PlantDescription.this, response,
                                Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                })
                {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> map = new HashMap<>();
                        map.put("namekey" , title.getText().toString());
                        map.put("price" , price.getText().toString());
                        map.put("quantity" , quantity.getText().toString());
                        String iid="10"; String pid ="5"; String uid= "66";
                        map.put("itemid",iid);
                        map.put("userid",uid);
                        map.put("plantid",pid);
                        return map;
                    };

            };
                RequestQueue rq = Volley.newRequestQueue(PlantDescription.this);
                rq.add(stringRequest);

            }
    });
    }
}