package com.learning.sitrageneral;

import android.app.Activity;
import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
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

public class work_assignment extends AppCompatActivity {
    Spinner spinner_desc;
    Button btn_result;
    EditText et_count,tm;
    ArrayList<String> para_name=new ArrayList<>();
    ArrayList<String>results=new ArrayList<>();
    String count;
    ArrayList<String> dropdown1=new ArrayList<>();
    Constant constant=new Constant();
    String result1;
    String url=constant.ip+"app_sitragen_norms_productivity_work_assignment_parameter_lists";
    String url1=constant.ip+"app_sitragen_norms_productivity_work_assignment";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_assignment);
        spinner_desc=(Spinner)findViewById(R.id.spinner_desc);
        getParmsList();
        btn_result=(Button)findViewById(R.id.get_result);
        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                api();
                btn_result.setEnabled(false);
            }
        });
    }
    public void api(){

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.POST, url1, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.i("My dhinesh", "" + response);


                try {
                    JSONArray jsonArray=new JSONArray(response);
                    for (int i=0;i<jsonArray.length();i++){
                        JSONObject jsonObject=jsonArray.getJSONObject(i);
                        String html_code=jsonObject.getString("html_code");

                        showwdialog(html_code);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(work_assignment.this, "Please Check Connectivity :" + error, Toast.LENGTH_LONG).show();
                Log.i("My error", "" + error);
            }
        }) {
            @Override

            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();

                map.put("opertype",result1);

                //search_condition




                return map;
            }
        };
        queue.add(request);


    }
    public void showwdialog(String html){
        Activity activity = null;
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        TextView result_view,a_head;

        final AlertDialog alertDialog = dialogBuilder.create();
        LayoutInflater factory = LayoutInflater.from(this);
        final View v = factory.inflate(R.layout.alert_result_html, null);
        a_head=(TextView)v.findViewById(R.id.a_head);
        a_head.setText("Productivity:Work Assignment");
        result_view=(TextView)v.findViewById(R.id.result_view);
        result_view.setText(Html.fromHtml(html));

        alertDialog.setView(v);
        alertDialog.show();
        alertDialog.setCancelable(true);
        btn_result.setEnabled(true);
    }
    public void getParmsList(){

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.i("My dhinesh", "" + response);


                try {
                    JSONArray jsonArray=new JSONArray(response);
                    for(int i=0;i<=jsonArray.length();i++){
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
                Toast.makeText(work_assignment.this, "Please Check Connectivity :" + error, Toast.LENGTH_LONG).show();
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
