package com.learning.sitrageneral;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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

public class Reg extends AppCompatActivity {
    EditText name,org,mobile,email,password,country;
    Button Register;
    Spinner spinner;

    String deviceid="";
    String android_id;
    String id;
    Constant constant=new Constant();
    String getdata_url=constant.ip+"app_sitra_gen_logged_userdetails";
    String GET_URL=constant.ip+"app_registration";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        try {

            id=getIntent().getStringExtra("id");
            getData();
            Log.i("dhinesh",id);
        }catch (NullPointerException e){
            id="";
            e.printStackTrace();
        }
        name=(EditText)findViewById(R.id.name);
        org=(EditText)findViewById(R.id.org);
        mobile=(EditText)findViewById(R.id.number);
        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        country=(EditText)findViewById(R.id.Country);
        Register=(Button)findViewById(R.id.register);

        WifiManager manager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = manager.getConnectionInfo();
        android_id = Settings.Secure.getString(getContentResolver(),
                Settings.Secure.ANDROID_ID);
        Log.i("add",android_id);
        // splash=(ImageButton) findViewById(R.id.splash);
        //Splash Screen
        deviceid=android_id;
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().isEmpty()&&org.getText().toString().isEmpty()&&mobile.getText().toString().isEmpty()&&password.getText().toString().isEmpty()&&country.getText().toString().isEmpty()){

                }else {
                    api();
                }
            }
        });

    }
    public void api(){
        RequestQueue queue = Volley.newRequestQueue(Reg.this);
        StringRequest request = new StringRequest(Request.Method.POST, GET_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.i("Registeration", "" + response);


                try {
                    //will receive id when the Reg is success
                    JSONObject js=new JSONObject(response);
                    Boolean status=js.getBoolean("status");
                    String id=js.getString("id");
                        Intent intent = new Intent(Reg.this, MainActivity.class);
                        intent.putExtra("id", id);
                        startActivity(intent);
                        String msg=js.getString("msg");
                    Toast.makeText(Reg.this, msg, Toast.LENGTH_SHORT).show();
                    //************parsing response object**********
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(Reg.this, "Somewhere went wrong", Toast.LENGTH_SHORT).show();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(Reg.this, "Please check connectivity", Toast.LENGTH_SHORT).show();
                Log.i("My error", "" + error);
            }
        }) {
            @Override

            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                //send your params here
                map.put("type", "2");
                map.put("device_id", deviceid);
                map.put("name", name.getText().toString());
                map.put("organization_millname", org.getText().toString());
                map.put("mobileno", mobile.getText().toString());
                map.put("emailid", email.getText().toString());
                map.put("country",country.getText().toString());
                map.put("password",password.getText().toString());
                map.put("id",id);

                return map;
            }
        };
        queue.add(request);

    }
    @Override
    public void onBackPressed(){
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory( Intent.CATEGORY_HOME );
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);

    }
    public void getData(){
        RequestQueue queue = Volley.newRequestQueue(Reg.this);
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
                    name.setText(namee);
                    int mob=0;

                    mobile.setText(mobileno, TextView.BufferType.EDITABLE);

                    email.setText(emailid);
                    org.setText(organization_millname);
                    country.setText(countryy);
                    password.setText(passwordd);


                } catch (
                        JSONException e) {
                    Toast.makeText(Reg.this, "Credentials Error", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Reg.this, "Please Check Connectivity :" + error, Toast.LENGTH_LONG).show();
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
}
