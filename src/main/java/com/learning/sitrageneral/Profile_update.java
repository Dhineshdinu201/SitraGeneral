package com.learning.sitrageneral;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Profile_update extends AppCompatActivity {
    EditText et_name,et_mobile,et_mail,et_org,et_country,et_newpass,et_confirmpass;
    Button btn_submit;
    String name,mail,org,country,password;
    String mobile;
    String id;
    Constant constant=new Constant();
    String getdata_url=constant.ip+"app_sitra_gen_logged_userdetails";
    String url=constant.ip+"app_registration";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_update);
        getData();
        try {

            id=getIntent().getStringExtra("id");
            Log.i("dhinesh",id);
        }catch (NullPointerException e){
            e.printStackTrace();
        }

        et_name=(EditText)findViewById(R.id.et_name);
        et_mobile=(EditText)findViewById(R.id.et_mobile);
        et_mail=(EditText)findViewById(R.id.et_mail);
        et_org=(EditText)findViewById(R.id.et_org);
        et_country=(EditText)findViewById(R.id.et_country);
        et_newpass=(EditText)findViewById(R.id.et_newpass);
        btn_submit=(Button)findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("isub","working");
                name = et_name.getText().toString();
                mail = et_mail.getText().toString();
                org = et_org.getText().toString();
                country = et_country.getText().toString();
                password = et_newpass.getText().toString();
                mobile=et_mobile.getText().toString();
                if (!(name.isEmpty() | mail.isEmpty() | org.isEmpty() | country.isEmpty() | password.isEmpty()| mobile.isEmpty())) {
                    Log.i("fsub","working");



                    send();
                }else{
                    Toast.makeText(Profile_update.this, "All Fields Must Be filled", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void getData(){
        RequestQueue queue = Volley.newRequestQueue(Profile_update.this);
        StringRequest request = new StringRequest(Request.Method.POST, getdata_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.i("My success", "" + response);
                try {
                    JSONObject object=new JSONObject(response);
                    String namee=object.getString("name");
                    String mobileno=object.getString("mobileno");
                    String emailid=object.getString("emailid");
                    String organization_millname=object.getString("organization_millname");
                    String countryy=object.getString("country");
                    String passwordd=object.getString("password");
                    Log.i("result",id+name+mobileno+emailid+organization_millname+country+password);
                    et_name.setText(namee);
                    int mob=0;

                        et_mobile.setText(mobileno, TextView.BufferType.EDITABLE);

                    et_mail.setText(emailid);
                    et_org.setText(organization_millname);
                    et_country.setText(countryy);
                    et_newpass.setText(passwordd);


                } catch (
                        JSONException e) {
                    Toast.makeText(Profile_update.this, "Credentials Error", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Profile_update.this, "Please Check Connectivity :" + error, Toast.LENGTH_LONG).show();
                Log.i("My error", "" + error);
            }
        }) {
            @Override

            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();

                map.put("id",""+id);

                return map;
            }
        };
        queue.add(request);
    }
    public void send(){

        RequestQueue queue = Volley.newRequestQueue(Profile_update.this);
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.i("My success", "" + response);
                try {
                    JSONObject object=new JSONObject(response);
                    int reg_id=object.getInt("reg_id");
                    Intent intent=new Intent(Profile_update.this,ProfileActivity.class);
                    intent.putExtra("id",id);
                    startActivity(intent);
                   Log.i("reg_id",""+reg_id);

                } catch (JSONException e) {
                    Toast.makeText(Profile_update.this, "Credentials Error", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Profile_update.this, "Please Check Connectivity :" + error, Toast.LENGTH_LONG).show();
                Log.i("My error", "" + error);
            }
        }) {
            @Override

            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put("id",id);
                map.put("name",name);
                map.put("mobileno",""+mobile);
                map.put("emailid",""+mail);
                map.put("password",""+password);
                map.put("organization_millname",""+org);
                map.put("country",""+country);
                Log.i("print det",id+name+mobile+mail+password+org+country);
                return map;
            }
        };
        queue.add(request);
    }
}
