package com.learning.sitrageneral;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fragment_count extends Fragment {
    Spinner spinner_desc;
    EditText count;
    Button reset,getdata;
    Constant constant;
    List<String> list,id_list,head_list,value_list;
    TableLayout stk;
    TextView head,result_head,result;
    String value;
    String url = constant.ip+"get_count_conversion_types";
    String getdata_url=constant.ip+"get_count_conversion_data";
    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstancetate) {
        View view = inflater.inflate(R.layout.fragment_gps, container, false);
        spinner_desc=(Spinner)view.findViewById(R.id.spinner_desc);
        count=(EditText)view.findViewById(R.id.count);
        reset=(Button)view.findViewById(R.id.reset);
        getdata=(Button)view.findViewById(R.id.getdata);
        head=(TextView)view.findViewById(R.id.head);
        result_head=(TextView)view.findViewById(R.id.result_head);
        result=(TextView)view.findViewById(R.id.result);

        head.setText("Count Conversion");
        send();

        getdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getData();
                send();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count.setText("");
            }
        });
        return view;
    }

    public void send(){
        list=new ArrayList<>();
        id_list=new ArrayList<>();
        list.add("Select Source Unit");
        id_list.add("0");
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.i("My success", "" + response);
                try {

                    JSONArray sample=new JSONArray(response);
                    for(int i=0;i<sample.length();i++){
                        JSONObject jo=sample.getJSONObject(i);
                        String desc=jo.getString("desc");
                        String id=jo.getString("id");

                        Log.i("desc",desc);
                        list.add(desc);
                        id_list.add(id);
                        Log.i("idlist",id_list.get(i));
                        ArrayAdapter<String> spinAdapter=new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_dropdown_item,list);
                        spinner_desc.setAdapter(spinAdapter);
                        spinner_desc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                value=id_list.get(position);
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });

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
        InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(
                Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(count.getWindowToken(), 0);
        final String s_count=count.getText().toString();
        list=new ArrayList<>();
        final List<String> conversion_desc_list,output_value_list;
        conversion_desc_list=new ArrayList<>();
        output_value_list=new ArrayList<>();
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        StringRequest request = new StringRequest(Request.Method.POST, getdata_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.i("My success", "" + response);
                try {

                    JSONArray sample=new JSONArray(response);
                    for(int i=0;i<sample.length();i++) {
                        JSONObject jo = sample.getJSONObject(i);
                        String to_conversion_id = jo.getString("to_conversion_id");
                        String conversion_desc = jo.getString("conversion_desc");
                        String output_value = jo.getString("output_value");
                        Log.i("to_conversion_id", to_conversion_id);
                        Log.i("conversion_desc", conversion_desc);
                        Log.i("output_value", output_value);
                        conversion_desc_list.add(conversion_desc);
                        output_value_list.add(output_value);


                    }
                    if(conversion_desc_list.size()!=0) {
                        Activity activity = null;
                        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
                        final AlertDialog alertDialog = dialogBuilder.create();
                        LayoutInflater factory = LayoutInflater.from(getActivity());
                        final View vi = factory.inflate(R.layout.alert_result, null);
                        stk = (TableLayout) vi.findViewById(R.id.tablelayout);
                        stk.removeAllViews();
                        for (int i = 0; i < conversion_desc_list.size(); i++) {
                            TableRow tbrow = new TableRow(getActivity());
                            TextView t1v = new TextView(getActivity());
                            t1v.setText(conversion_desc_list.get(i));
                            t1v.setTextColor(Color.BLACK);
                            t1v.setGravity(Gravity.LEFT);
                            t1v.setTypeface(null, Typeface.BOLD);
                            tbrow.addView(t1v);
                            TextView t2v = new TextView(getActivity());
                            t2v.setText(output_value_list.get(i));
                            t2v.setTextColor(Color.BLACK);
                            t2v.setGravity(Gravity.LEFT);
                            tbrow.addView(t2v);

                            stk.addView(tbrow);

                        }


                        alertDialog.setView(vi);
                        alertDialog.show();
                        alertDialog.setCancelable(true);
                    }
                    else {
                        Toast.makeText(getActivity(), "input error", Toast.LENGTH_SHORT).show();
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
                map.put("entered_value",s_count);
                map.put("from_conversion_type",""+value);
                return map;
            }
        };
        queue.add(request);
    }
}
