package com.learning.sitrageneral;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {
EditText name,org,mobile,email;
Button register;
Constant constant=new Constant();
String GET_URL=constant.ip+"app_registration";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name=(EditText)findViewById(R.id.name);
        org=(EditText)findViewById(R.id.org);
        mobile=(EditText)findViewById(R.id.number);
        email=(EditText)findViewById(R.id.email);
        register=(Button)findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().isEmpty()&&org.getText().toString().isEmpty()&&mobile.getText().toString().isEmpty()){

                }else{

                }
            }
        });

    }
    public void api(){
        RequestQueue queue = Volley.newRequestQueue(Register.this);
        StringRequest request = new StringRequest(Request.Method.POST, GET_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.i("My success", response);
                try {
                    JSONObject jo = new JSONObject(response);

                } catch(JSONException e){
                    e.printStackTrace();
                    Toast.makeText(Register.this, "No Result Found", Toast.LENGTH_SHORT).show();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(Register.this, "No Network Connection", Toast.LENGTH_LONG).show();
                Log.i("My error", "" + error);
            }
        }) {
            @Override

            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put("name", name.getText().toString());
                map.put("org", org.getText().toString());
                map.put("mobile", mobile.getText().toString());
                map.put("email", email.getText().toString());


                return map;
            }
        };
        queue.add(request);
    }
}
