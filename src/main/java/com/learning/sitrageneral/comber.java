package com.learning.sitrageneral;

import android.app.Activity;
import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
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

public class comber extends AppCompatActivity {
EditText count;
Button get_result;
String str_count;
    ArrayList<String> para_name=new ArrayList<>();
    ArrayList<String>results=new ArrayList<>();
    Constant constant=new Constant();
    String getdata_url=constant.ip+"app_sitragen_norms_productivity_comber";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comber);
        count=(EditText)findViewById(R.id.count);
        get_result=(Button)findViewById(R.id.get_result);
        get_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str_count=count.getText().toString();
                api();
            }
        });

    }
    public void api(){
        RequestQueue queue = Volley.newRequestQueue(comber.this);
        StringRequest request = new StringRequest(Request.Method.POST, getdata_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.i("My success", "" + response);
                try {
                    JSONArray ja=new JSONArray(response);

                    JSONObject object=ja.getJSONObject(0);
                    String count_group,d_speed,effy,lapwt,prodn,feedpernip;
                    count_group=object.getString("count_group");
                    lapwt=object.getString("lapwt");
                    d_speed=object.getString("speed");
                    effy=object.getString("effy");
                    prodn=object.getString("prate");
                    feedpernip=object.getString("feedpernip");

                    showwdialog();
                    para_name.add("count group");
                    para_name.add("Lap Weight (g/m)");
                    para_name.add("speed (npm)");
                    para_name.add("Feed per nip (mm)");
                    para_name.add("Machine Efficiency (%)");
                    para_name.add("Production / comber / 8hours (kg)");
                    results.add(count_group);
                    results.add(lapwt);
                    results.add(d_speed);
                    results.add(feedpernip);
                    results.add(effy);
                    results.add(prodn);

                } catch (
                        JSONException e) {
                    Toast.makeText(comber.this, "Something went wrong please try again", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(comber.this, "Please Check Connectivity :" + error, Toast.LENGTH_LONG).show();
                Log.i("My error", "" + error);
            }
        }) {
            @Override

            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();

                map.put("count",count.getText().toString());

                return map;
            }
        };
        queue.add(request);
    }
    public void showwdialog(){
        Activity activity = null;
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        ListView a_listview ;

        final AlertDialog alertDialog = dialogBuilder.create();
        LayoutInflater factory = LayoutInflater.from(this);
        final View v = factory.inflate(R.layout.alert_view_result, null);
        a_listview=(ListView)v.findViewById(R.id.a_listview);
        list_alert_view_result listAlertViewResult=new list_alert_view_result(this,para_name,results);
        a_listview.setAdapter(listAlertViewResult);




        alertDialog.setView(v);
        alertDialog.show();
        alertDialog.setCancelable(true);




    }
}
    
