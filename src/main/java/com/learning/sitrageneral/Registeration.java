package com.learning.sitrageneral;

import android.content.Intent;
import android.graphics.Paint;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.sitra.general.R;

public class Registeration extends AppCompatActivity {
    EditText et_name,et_mobile,et_mail,et_org,et_country,et_newpass,et_confirmpass;
    Button btn_submit,btn_cancel;
    String name,mail,org,country,password;
    String mobile;
    String url="http://lab.sitraonline.org/index.php/api/app_registration";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);
        et_name=(EditText)findViewById(R.id.et_name);
        et_mobile=(EditText)findViewById(R.id.et_mobile);
        et_mail=(EditText)findViewById(R.id.et_mail);
        et_org=(EditText)findViewById(R.id.et_org);
        et_country=(EditText)findViewById(R.id.et_country);
        et_newpass=(EditText)findViewById(R.id.et_newpass);
        et_confirmpass=(EditText)findViewById(R.id.et_confirmpass);
        btn_submit=(Button)findViewById(R.id.btn_submit);
        btn_cancel=(Button)findViewById(R.id.btn_cancel);
        btn_cancel.setPaintFlags(btn_cancel.getPaintFlags() |   Paint.UNDERLINE_TEXT_FLAG);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = et_name.getText().toString();
                mail = et_mail.getText().toString();
                org = et_org.getText().toString();
                mobile=et_mobile.getText().toString();
                country = et_country.getText().toString();
                password = et_newpass.getText().toString();
                if (!(name.isEmpty() | mail.isEmpty() | org.isEmpty() | country.isEmpty() | password.isEmpty())) {
                    if (et_newpass.getText().toString().equals(et_confirmpass.getText().toString())) {
                        send();
                    }
                    else{
                        Toast.makeText(Registeration.this, "password and confirm should be equal", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(Registeration.this, "All Fields Must Be filled", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent=new Intent(Registeration.this,LoginActivity.class);
              startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed(){
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory( Intent.CATEGORY_HOME );
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);

    }

    public void send(){

        RequestQueue queue = Volley.newRequestQueue(Registeration.this);
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.i("My success", "" + response);
                try {
                    JSONObject object=new JSONObject(response);
                    int reg_id=object.getInt("reg_id");
                    Intent intent=new Intent(Registeration.this,LoginActivity.class);
                    intent.getIntExtra("reg_id",reg_id);
                    startActivity(intent);

                } catch (JSONException e) {
                    Toast.makeText(Registeration.this, "Credentials Error", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Registeration.this, "Please Check Connectivity :" + error, Toast.LENGTH_LONG).show();
                Log.i("My error", "" + error);
            }
        }) {
            @Override

            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put("name",name);
                map.put("mobileno",""+mobile);
                Log.i("mobileno",mobile);
                map.put("emailid",""+mail);
                map.put("password",""+password);
                map.put("organization_millname",""+org);
                map.put("country",""+country);
                return map;
            }
        };
        queue.add(request);
    }
}
