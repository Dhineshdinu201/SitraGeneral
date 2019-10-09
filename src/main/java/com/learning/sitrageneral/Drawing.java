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

public class Drawing extends AppCompatActivity {
    ArrayList<String> para_name=new ArrayList<>();
    ArrayList<String>results=new ArrayList<>();
    Button btn_result;
    Spinner spinner_desc,spinner_machine;
    ArrayList<String>dropdown1=new ArrayList<>();
    ArrayList<String>dropdown2=new ArrayList<>();
    ArrayList<String>dropdown_result=new ArrayList<>();
    String result1,result2,count;
    Constant constant=new Constant();
    EditText et_count;
    String url=constant.ip+"app_sitragen_norms_productivity_drawing_paralists";
    String url1=constant.ip+"app_sitragen_norms_productivity_drawing";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing);

        spinner_desc=(Spinner)findViewById(R.id.spinner_desc);
        spinner_machine=(Spinner)findViewById(R.id.spinner_machine);
        btn_result=(Button)findViewById(R.id.btn_result);
        et_count=(EditText)findViewById(R.id.count);
        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count=et_count.getText().toString();
                api3();

            }
        });

        spinner_desc=(Spinner)findViewById(R.id.spinner_desc);
        api();
        api2();


    }
    public void api(){

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.i("My dhinesh", "" + response);


                try {
                    JSONArray jsonArray=new JSONArray(response);
                    for(int i=0;i<=jsonArray.length();i++){
                        JSONObject jsonObject=jsonArray.getJSONObject(i);
                        String id=jsonObject.getString("id");
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
                                        result1 = dropdown1.get(position);
                                        break;
                                    case 1:
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
                Toast.makeText(Drawing.this, "Please Check Connectivity :" + error, Toast.LENGTH_LONG).show();
                Log.i("My error", "" + error);
            }
        }) {
            @Override

            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put("type","1");

                //search_condition




                return map;
            }
        };
        queue.add(request);


    }
    public void api2(){

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.i("My dhinesh", "" + response);


                try {
                    JSONArray jsonArray=new JSONArray(response);
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject jsonObject=jsonArray.getJSONObject(i);
                        String id=jsonObject.getString("id");
                        String value=jsonObject.getString("value");
                        dropdown2.add(id);
                        dropdown_result.add(value);
                        //ArrayAdapter<String> adapter=new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,dropdown1);
                        ArrayAdapter<String> adapter =
                                new ArrayAdapter<String>(getApplicationContext(),  android.R.layout.simple_spinner_dropdown_item, dropdown_result);
                        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);
                        spinner_machine.setAdapter(adapter);
                        spinner_machine.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView parent, View view, int position, long id) {
                                switch (position) {
                                    case 0:
                                        result2 = dropdown2.get(position);
                                        break;
                                    case 1:
                                        result2 = dropdown2.get(position);

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
                Toast.makeText(Drawing.this, "Please Check Connectivity :" + error, Toast.LENGTH_LONG).show();
                Log.i("My error", "" + error);
            }
        }) {
            @Override

            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put("type","2");

                //search_condition




                return map;
            }
        };
        queue.add(request);


    }
    public void api3(){

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
                        String delspeed=jsonObject.getString("delspeed");
                        String hank=jsonObject.getString("hank");
                        String effy=jsonObject.getString("effy");
                        String prate_kg=jsonObject.getString("prate_kg");
                        String prate_hanks=jsonObject.getString("prate_hanks");
                        String deliveries=jsonObject.getString("deliveries");
                        String description=jsonObject.getString("description");

                        para_name.add("count group");
                        para_name.add("Delivery Speed(mpm)");
                        para_name.add("silver hank");
                        para_name.add("Machine efficiency(%)");
                        para_name.add("Production per delivery/8 hours");
                        results.add(count_group);
                        results.add(delspeed);
                        results.add(hank);
                        results.add(effy);
                        results.add(prate_hanks);
                        showwdialog();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Drawing.this, "Please Check Connectivity :" + error, Toast.LENGTH_LONG).show();
                Log.i("My error", "" + error);
            }
        }) {
            @Override

            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put("count",count);
                map.put("description",result1);
                map.put("delivery_type",result2);

                //search_condition




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
