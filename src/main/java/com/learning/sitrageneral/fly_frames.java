package com.learning.sitrageneral;

import android.app.Activity;
import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class fly_frames extends AppCompatActivity {
    Spinner spinner_desc;
    Button btn_result;
    EditText et_count;
    ArrayList<String> para_name=new ArrayList<>();
    ArrayList<String>results=new ArrayList<>();
    String count;
    ArrayList<String> dropdown1=new ArrayList<>();
    Constant constant=new Constant();
    String result1;
    String url=constant.ip+"app_sitragen_norms_productivity_flyframes_parameter_lists";
    String url1=constant.ip+"app_sitragen_norms_productivity_flyframes";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fly_frames);
        spinner_desc=(Spinner)findViewById(R.id.spinner_desc);

        getParmsList();
        btn_result=(Button)findViewById(R.id.get_result);
        et_count=(EditText)findViewById(R.id.count);
        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count=et_count.getText().toString();
                try{
                int i_count= Integer.parseInt(count);
                if(i_count<=10||i_count>=120){
                    Toast.makeText(fly_frames.this, "count should between 10 to 120", Toast.LENGTH_SHORT).show();
                }
                else {
                    api();
                    btn_result.setEnabled(false);
                }
            }catch (Exception e){
                Toast.makeText(fly_frames.this, "Please enter the count", Toast.LENGTH_SHORT).show();
            }


            }
        });
    }
    public void api(){
        btn_result.setEnabled(true);
        para_name.clear();
        results.clear();
        Log.i("url",url1);
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.POST, url1, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.i("My dhinesh", "" + response);


                try {
                    JSONArray jsonArray=new JSONArray(response);
                    for (int i=0;i<jsonArray.length();i++){
                        JSONObject jsonObject=jsonArray.getJSONObject(i);
                        String id=jsonObject.getString("id");
                        String count_group=jsonObject.getString("count_group");
                        String delspeed=jsonObject.getString("speed");
                        String hank=jsonObject.getString("hank");
                        String tm=jsonObject.getString("tm");
                        String tpi=jsonObject.getString("tpi");
                        String effy=jsonObject.getString("effy");
                        String prate_kg=jsonObject.getString("prate_kg");
                        String prate_hanks=jsonObject.getString("prate_hank");
                        String compact=jsonObject.getString("compact");

                        para_name.add("count group");
                        para_name.add("Spindle Speed");
                        para_name.add("Roving hank");
                        para_name.add("Twist multiplier (TM)");
                        para_name.add("Twists per inch");
                        para_name.add("Machine efficiency");
                        para_name.add("production rate in fly frames");
                        para_name.add("KG");
                        para_name.add("Hanks");
                        results.add(count_group);
                        results.add(delspeed);
                        results.add(hank);
                        results.add(tm);
                        results.add(tpi);
                        results.add(effy);
                        results.add("");
                        results.add(prate_kg);
                        results.add(prate_hanks);
                        showwdialog("Productivity:Fly Frames");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(fly_frames.this, "Please Check Connectivity :" + error, Toast.LENGTH_LONG).show();
                Log.i("My error", "" + error);
            }
        }) {
            @Override

            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put("count",count);
                map.put("compact_type",result1);
                Log.i("count",count);
                Log.i("compact_type",result1);

                //search_condition




                return map;
            }
        };
        queue.add(request);


    }
    public void showwdialog(String head){
        Activity activity = null;
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        ListView a_listview ;


        final AlertDialog alertDialog = dialogBuilder.create();
        LayoutInflater factory = LayoutInflater.from(this);
        final View v = factory.inflate(R.layout.alert_view_result, null);
        TextView a_head;
        a_head=(TextView)v.findViewById(R.id.a_head);
        a_head.setText(head);
        a_listview=(ListView)v.findViewById(R.id.a_listview);
        list_alert_view_result listAlertViewResult=new list_alert_view_result(this,para_name,results);
        a_listview.setAdapter(listAlertViewResult);
        alertDialog.setView(v);
        alertDialog.show();
        alertDialog.setCancelable(true);

    }
    public void getParmsList(){
            RequestQueue queue = Volley.newRequestQueue(this);
            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    Log.i("My dhinesh", "" + response);


                    try {
                        JSONArray jsonArray=new JSONArray(response);
                        for(int i=0;i<jsonArray.length();i++){
                            JSONObject jsonObject=jsonArray.getJSONObject(i);
                            String id=jsonObject.getString("key");
                            String value=jsonObject.getString("value");

                            dropdown1.add(id);
                            //ArrayAdapter<String> adapter=new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,dropdown1);
                            ArrayAdapter<String> adapter =
                                    new ArrayAdapter<String>(getApplicationContext(),  android.R.layout.simple_spinner_dropdown_item, dropdown1);
                            adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);
                            spinner_desc.setAdapter(adapter);
                            spinner_desc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView parent, View view, int position, long id) {
                                    switch (position) {
                                        case 0:
                                            result1="";
                                            break;
                                        case 1:
                                            result1 = dropdown1.get(position);
                                            break;
                                        case 2:
                                            result1 = dropdown1.get(position);

                                            break;
                                    }
                                }

                                @Override
                                public void onNothingSelected(AdapterView parent) {

                                }
                            });
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(fly_frames.this, "Please Check Connectivity :" + error, Toast.LENGTH_LONG).show();
                    Log.i("My error", "" + error);
                }
            }) {
                @Override

                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> map = new HashMap<String, String>();
                    return map;
                }
            };
            queue.add(request);



    }
}
