package com.example.iotree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    Button login, signup;
    EditText emailTxt, passwordTxt;
    TextView testemail;
    public static String in_email,in_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = findViewById(R.id.MainActivityLink);
        signup = findViewById(R.id.signup_Link);
        emailTxt = findViewById(R.id.email);
        passwordTxt = findViewById(R.id.password);
        //testemail = findViewById(R.id.testemail);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(LoginActivity.this, Registration.class);
                startActivity(in);
            }
        });
        Intent intent = getIntent();
        Bundle bundle =getIntent().getExtras();
        //in_email = bundle.getString("email");
        //in_password = bundle.getString("password");
        //testemail.setText(in_email);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getData();
                //checkUser();

                Intent in = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(in);
                }

            }
        );
    }

   /* private void checkUser() {
        String fetchuser_url = "http://hibabintetariq.stig.pk/fetchuser.php";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, fetchuser_url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("result");
                    for (int i = 0; i<jsonArray.length(); i++){
                        JSONObject user = jsonArray.getJSONObject(i);
                        Log.d("jsonobj","created");
                        String email = user.getString("User_name");
                        testemail.setText("Your data "+email);
                        Log.d("email",""+email);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
    }

   private void getData() {
        String emailText = email.getText().toString();
        //String passwordText = password.getText().toString();
        if(emailText ==""){
            Toast.makeText(this,"Empty field",Toast.LENGTH_SHORT).show();
            return;
        }
        String fetchuser_url = Config.DATA_URL + email.getText();
        StringRequest sr = new StringRequest(fetchuser_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                showJSONS(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText(this,error.getMessage().toString(),Toast.LENGTH_LONG).show();
            }
        }
        );

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(sr);
    }

    private void showJSONS(String response) {
        String name = "";
        try {

            Log.d("email",""+email);
            JSONObject jsObject = new JSONObject(response);
            JSONArray result = jsObject.getJSONArray(Config.USER_JSON_ARRAY);
            JSONObject op = result.getJSONObject(0);
            name = op.getString(Config.KEY_NAME);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        testemail.setText(""+name);
    }*/
   private void getData() {


       String id = emailTxt.getText().toString().trim();


       if (id.equals("")) {

           Toast.makeText(this, "Check Detail!", Toast.LENGTH_LONG).show();
           return;
       }

       String url = Config.DATA_URL + emailTxt.getText().toString().trim();

       StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
           @Override
           public void onResponse(String response) {

               showJSONS(response);
           }
       },
               new Response.ErrorListener() {
                   @Override
                   public void onErrorResponse(VolleyError error) {
                       Toast.makeText(LoginActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                   }
               });

       RequestQueue requestQueue = Volley.newRequestQueue(this);
       requestQueue.add(stringRequest);

   }

    private void showJSONS(String response) {
        String name = "";


        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray(Config.USER_JSON_ARRAY);
            JSONObject collegeData = result.getJSONObject(0);
            name = collegeData.getString(Config.KEY_NAME);


        } catch (JSONException e) {
            e.printStackTrace();
        }

        testemail.setText("" + name);
    }
}


