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

public class CardActivity extends AppCompatActivity {
    ArrayList<String> para_name=new ArrayList<>();
    ArrayList<String>results=new ArrayList<>();
    Button btn_result;
    EditText card_count;
    String count;
    Constant constant=new Constant();
    String getdata_url=constant.ip+"app_sitragen_norms_productivity_carding";
    String GET_URL=constant.ip+"app_registration";
    String count_group,d_speed,silver_hank,prodn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        //123456789
        card_count=(EditText)findViewById(R.id.card_count);
        btn_result=(Button)findViewById(R.id.btn_result);
        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count=card_count.getText().toString();
                try {
                    int i_count = Integer.parseInt(count);
                    if(i_count<=10||i_count>=120){
                        Toast.makeText(CardActivity.this, "count should between 10 to 120", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        getData();
                        btn_result.setEnabled(false);
                    }
                }catch (Exception e){
                    Toast.makeText(CardActivity.this, "Please enter the count", Toast.LENGTH_SHORT).show();
                }


            }
        });


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
        btn_result.setEnabled(true);



    }
    public void getData(){
        para_name.clear();
        results.clear();
        RequestQueue queue = Volley.newRequestQueue(CardActivity.this);
        StringRequest request = new StringRequest(Request.Method.POST, getdata_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.i("My success", "" + response);
                try {
                    JSONArray ja=new JSONArray(response);

                        JSONObject object=ja.getJSONObject(0);
                        count_group=object.getString("count_group");
                        d_speed=object.getString("delspeed");
                        silver_hank=object.getString("hank");
                        prodn=object.getString("prate");






                    showwdialog("Productivity:Carding");
                    para_name.add("count group");
                    para_name.add("Delivery Speed");
                    para_name.add("silver hank");
                    para_name.add("production rate in chute feed cards");
                    results.add(count_group);
                    results.add(d_speed);
                    results.add(silver_hank);
                    results.add(prodn);

                } catch (
                        JSONException e) {
                    Toast.makeText(CardActivity.this, "Something went wrong please try again", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(CardActivity.this, "Please Check Connectivity :" + error, Toast.LENGTH_LONG).show();
                Log.i("My error", "" + error);
            }
        }) {
            @Override

            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();

                map.put("count",count);

                return map;
            }
        };
        queue.add(request);
    }
}
