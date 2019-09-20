package com.learning.sitrageneral;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TableRow;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
EditText et_usermail,et_password;
Button login,new_reg;
CheckBox checkBox;
    private SharedPreferences mpref;
    private static final String PREF_NAME="SP_NAME";
    String userid,password;
    Constant constant=new Constant();
    String getdata_url=constant.ip+"app_sitra_gen_login";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mpref=this.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        userid=mpref.getString("USERID","");
        et_usermail=(EditText)findViewById(R.id.et_login_mail);
        password=mpref.getString("PASSWORD","");
        et_password=(EditText)findViewById(R.id.et_login_password);
        et_usermail.setText(userid);
        et_password.setText(password);
        checkBox=(CheckBox)findViewById(R.id.check);
        new_reg=(Button)findViewById(R.id.new_reg);
        new_reg.setPaintFlags(new_reg.getPaintFlags() |   Paint.UNDERLINE_TEXT_FLAG);
        login=(Button)findViewById(R.id.btn_login);
        checkBox.setChecked(true);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox.isChecked()==true){
                userid=et_usermail.getText().toString();
                password=et_password.getText().toString();
                    if(TextUtils.isEmpty(userid)||TextUtils.isEmpty(password)){
                        Toast.makeText(LoginActivity.this, "All Fields Must Be filled", Toast.LENGTH_SHORT).show();
                    }else {
                        SharedPreferences.Editor editor=mpref.edit();
                        editor.putString("USERID",userid);
                        editor.putString("PASSWORD",password);
                        editor.apply();

                    }
                }
                userid=et_usermail.getText().toString();
                password=et_password.getText().toString();
                getData();
                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        new_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,Registeration.class);
                startActivity(intent);
            }
        });    }
    @Override
    public void onBackPressed(){
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory( Intent.CATEGORY_HOME );
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);

    }

    public void getData(){
        RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
        StringRequest request = new StringRequest(Request.Method.POST, getdata_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.i("My success", "" + response);
                try {
                    JSONObject object=new JSONObject(response);
                    String id=object.getString("id");
                    String name=object.getString("name");
                    String mobileno=object.getString("mobileno");
                    String emailid=object.getString("emailid");
                    String organization_millname=object.getString("organization_millname");
                    String country=object.getString("country");
                    Log.i("result",id+name+mobileno+emailid+organization_millname+country);
                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    intent.putExtra("id",id);
//                    intent.putExtra("name",name);
//                    intent.putExtra("mobileno",mobileno);
//                    intent.putExtra("emailid",emailid);
//                    intent.putExtra("organization_millname",organization_millname);
//                    intent.putExtra("country",country);
                    startActivity(intent);

                } catch (
                        JSONException e) {
                    Toast.makeText(LoginActivity.this, "Credentials Error", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LoginActivity.this, "Please Check Connectivity :" + error, Toast.LENGTH_LONG).show();
                Log.i("My error", "" + error);
            }
        }) {
            @Override

            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put("emailid",userid);
                map.put("password",""+password);

                return map;
            }
        };
        queue.add(request);
    }
}
