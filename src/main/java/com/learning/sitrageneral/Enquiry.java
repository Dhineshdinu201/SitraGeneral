package com.learning.sitrageneral;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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
import java.util.List;
import java.util.Map;

public class Enquiry extends AppCompatActivity {
    EditText et_name,et_mobile,et_mail,et_org,et_country;
    Button btn_submit;
    String name,mail,org,country;
    String mobile;
    String value,id,value_category;
    String iid;
    String getdata_url="http://lab.sitraonline.org/index.php/api/app_sitragen_deparment_lists";
    String GetUrl="http://lab.sitraonline.org/index.php/api/app_sitra_gen_logged_userdetails";
    String url="http://lab.sitraonline.org/index.php/api/app_sitragen_enquiry_category_lists";
    List<String> list_dept=new ArrayList<>(),list_category=new ArrayList<>();
    List<String> list_dept_value=new ArrayList<>();
    Spinner spinner_dept,spinner_category;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enquiry);
        try {

            iid=getIntent().getStringExtra("id");
            Log.i("enId",iid);
            getData();
        }catch (NullPointerException e){
            Log.i("enId","noId");
            e.printStackTrace();
        }
        list_dept.add("Select Dept");
        list_dept_value.add("0");
        list_category.add("Select Category");
        et_name=(EditText)findViewById(R.id.et_name);
        et_mobile=(EditText)findViewById(R.id.et_mobile);
        et_mail=(EditText)findViewById(R.id.et_mail);
        et_org=(EditText)findViewById(R.id.et_org);
        et_country=(EditText)findViewById(R.id.et_country);
        btn_submit=(Button)findViewById(R.id.btn_submit);
        spinner_dept=(Spinner)findViewById(R.id.spinner_dept);
        spinner_category=(Spinner)findViewById(R.id.spinner_category);
        Get();
        getcategory();



        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=et_name.getText().toString();
                mail=et_mail.getText().toString();
                org=et_org.getText().toString();
                country=et_country.getText().toString();
                mobile=et_mobile.getText().toString();
                Log.i("name", name + mail + mobile + org + country + value_category + value);
                if (name.isEmpty() || mail.isEmpty() || mobile.isEmpty() || org.isEmpty() || country.isEmpty() || value_category.isEmpty() || value.isEmpty()) {
                    Toast.makeText(Enquiry.this, "All Fields Must Be Filled", Toast.LENGTH_SHORT).show();
                } else {


                    Log.i("Send email", "");

                    String[] TO = {value};
                    Intent emailIntent = new Intent(Intent.ACTION_SEND);
                    emailIntent.setData(Uri.parse("mailto:"));
                    emailIntent.setType("text/plain");


                    emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Query from Sitra General");
                    emailIntent.putExtra(Intent.EXTRA_TEXT, "Name :" + name + "\n" + "Mail :" + mail + "\n" + "Mobile :" + mobile + "\n" + "Organization" + " :" + org + "\n" + "Country :" + country + "\n" + "Category :" + value_category);

                    try {
                        startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                        finish();
                    } catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(Enquiry.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        ArrayAdapter<String> spinAdapter=new ArrayAdapter<String>(Enquiry.this,android.R.layout.simple_spinner_dropdown_item,list_dept);
        spinner_dept.setAdapter(spinAdapter);
        spinner_dept.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                value=list_dept_value.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<String> spinAdapterCategory=new ArrayAdapter<String>(Enquiry.this,android.R.layout.simple_spinner_dropdown_item,list_category);
        spinner_category.setAdapter(spinAdapterCategory);
        spinner_category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                value_category=list_category.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void Get(){
        RequestQueue queue = Volley.newRequestQueue(Enquiry.this);
        StringRequest request = new StringRequest(Request.Method.POST, getdata_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.i("My success", "" + response);
                try {
                    JSONArray ja=new JSONArray(response);
                    for(int i=0;i<=ja.length();i++){
                        JSONObject jsonObject=ja.getJSONObject(i);
                        String department_name=jsonObject.getString("department_name");
                        String mail_id=jsonObject.getString("mail_id");
                        list_dept.add(department_name);
                        list_dept_value.add(mail_id);
                        Log.i("dept",list_dept.get(i));
                        Log.i("dept_value",list_dept_value.get(i));
                    }


                } catch (
                        JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
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
    public void getcategory(){
        RequestQueue queue = Volley.newRequestQueue(Enquiry.this);
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.i("My success", "" + response);
                try {
                    JSONArray ja=new JSONArray(response);
                    for(int i=0;i<=ja.length();i++){
                        JSONObject jsonObject=ja.getJSONObject(i);
                        String category_name=jsonObject.getString("category_name");
                        list_category.add(category_name);
                    }


                } catch (
                        JSONException e) {

                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
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

    public void getData(){
        RequestQueue queue = Volley.newRequestQueue(Enquiry.this);
        StringRequest request = new StringRequest(Request.Method.POST, GetUrl, new Response.Listener<String>() {
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
                    Log.i("result",name+mobileno+emailid+organization_millname+country);
                    et_name.setText(namee);
                    et_mobile.setText(mobileno);
                    et_mail.setText(emailid);
                    et_org.setText(organization_millname);
                    et_country.setText(countryy);
                    name=namee;
                    mail=emailid;
                    org=organization_millname;
                    country=countryy;
                    mobile=mobileno;


                } catch (
                        JSONException e) {

                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("My error", "" + error);
            }
        }) {
            @Override

            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();

                map.put("id",""+iid);

                return map;
            }
        };
        queue.add(request);
    }
}
