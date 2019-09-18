package com.learning.sitrageneral;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

public class ProfileActivity extends AppCompatActivity {
TextView profile;
String pro,id;
    String getdata_url="http://lab.sitraonline.org/index.php/api/app_sitra_gen_logged_userdetails";
Button update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getData();
        update=(Button)findViewById(R.id.update);

        try {

            id=getIntent().getStringExtra("id");
            update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(ProfileActivity.this,Profile_update.class);
                    intent.putExtra("id",id);
                    startActivity(intent);
                }
            });
        }catch (NullPointerException e){
            e.printStackTrace();
            Toast.makeText(this, "Please Login to continue", Toast.LENGTH_SHORT).show();
        }

        profile=(TextView)findViewById(R.id.profile);

    }
    public void getData(){
        RequestQueue queue = Volley.newRequestQueue(ProfileActivity.this);
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
                    pro=    "<b>Name   : </b>"+namee+"<br/><br/>"+
                            "<b>Mobile : </b>"+mobileno+"<br/><br/>"+
                            "<b>Mail   : </b>"+emailid+"<br/><br/>"+
                            "<b>Organization : </b>"+organization_millname+"<br/><br/>"+
                            "<b>Contry : </b>"+countryy+"<br/>";
                    profile.setText(Html.fromHtml(pro));



                } catch (
                        JSONException e) {
                    Toast.makeText(ProfileActivity.this, "Credentials Error", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ProfileActivity.this, "Please Check Connectivity :" + error, Toast.LENGTH_LONG).show();
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
    @Override
    public void onBackPressed(){

            Intent intent=new Intent(ProfileActivity.this,MainActivity.class);
            intent.putExtra("id",id);
            startActivity(intent);
    }

}
