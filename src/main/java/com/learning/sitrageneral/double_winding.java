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

public class double_winding extends AppCompatActivity {
    EditText count;
    Button get_result;
    String str_count;
    ArrayList<String> para_name=new ArrayList<>();
    ArrayList<String>results=new ArrayList<>();
    Constant constant=new Constant();
    String getdata_url=constant.ip+"app_sitragen_norms_productivity_doubler_winding";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_double_winding);
        count=(EditText)findViewById(R.id.count);
        get_result=(Button)findViewById(R.id.get_result);
        get_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str_count=count.getText().toString();
                api();
                get_result.setEnabled(false);
            }
        });

    }
    public void api(){
        para_name.clear();
        results.clear();
        Log.i("url",getdata_url);
        RequestQueue queue = Volley.newRequestQueue(double_winding.this);
        StringRequest request = new StringRequest(Request.Method.POST, getdata_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.i("My success", "" + response);
                try {
                    JSONArray ja=new JSONArray(response);

                    JSONObject object=ja.getJSONObject(0);
                    String count,effy,prate,drums;
                    count=object.getString("count");
                    effy=object.getString("effy");
                    prate=object.getString("prate");
                    drums=object.getString("drums");

                    showwdialog("Productivity:Doubler Winding");
                    para_name.add("count group");
                    para_name.add("Machine efficiency");
                    para_name.add("production per tenter");
                    para_name.add("Drums per tenter");
                    results.add(count);
                    results.add(effy);
                    results.add(prate);
                    results.add(drums);

                } catch (
                        JSONException e) {
                    Toast.makeText(double_winding.this, "Something went wrong please try again", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(double_winding.this, "Please Check Connectivity :" + error, Toast.LENGTH_LONG).show();
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
        get_result.setEnabled(true);



    }
}
    
        