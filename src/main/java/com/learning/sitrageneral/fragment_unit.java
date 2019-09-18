package com.learning.sitrageneral;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.InputFilter;
import android.util.Log;
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

public class fragment_unit extends Fragment {
    Spinner spinner_type,spinner_from;
    EditText count;
    TableLayout tablelayout;
    Button reset,getdata;
    List<String> list,id_list,from_list,from_id_list;
    TextView head,result_head,result,head1,head2,result1,result2;
    String from_value,type_value;
    String url = "http://lab.sitraonline.org/index.php/api/get_unit_conversion_types";
    String getfrom_url="http://lab.sitraonline.org/index.php/api/get_unit_conversion_units";
    String getData="http://lab.sitraonline.org/index.php/api/get_unit_conversion_result_data";
    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstancetate) {
        View view = inflater.inflate(R.layout.fragment_unit, container, false);
        spinner_type=(Spinner)view.findViewById(R.id.spinner_type);
        spinner_from=(Spinner)view.findViewById(R.id.spinner_from);
        count=(EditText)view.findViewById(R.id.count);
        reset=(Button)view.findViewById(R.id.reset);
        getdata=(Button)view.findViewById(R.id.getdata);
        head=(TextView)view.findViewById(R.id.head);
        result_head=(TextView)view.findViewById(R.id.result_head);
        result=(TextView)view.findViewById(R.id.result);

        head.setText("UNIT Conversion");
        getTypes();
        getdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getdata();
                getTypes();

            }
        });


        return view;
    }
    public void getTypes(){
        list=new ArrayList<>();
        id_list=new ArrayList<>();
        list.add("From Unit");
        id_list.add("0");
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.i("My success", "" + response);
                try {
                    JSONArray sample=new JSONArray(response);
                    for(int i=0;i<sample.length();i++){
                        JSONObject jo=sample.getJSONObject(i);
                        String type=jo.getString("type");
                        String id=jo.getString("id");

                        Log.i("type",type);
                        list.add(type);
                        id_list.add(id);
                        ArrayAdapter<String> spinAdapter=new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_dropdown_item,list);
                        spinner_type.setAdapter(spinAdapter);
                        spinner_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                type_value=id_list.get(position);
                                getFrom();
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
    public void getFrom(){
        from_list=new ArrayList<>();
        from_id_list=new ArrayList<>();
        from_list.add("Select From");
        from_id_list.add("0");
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        StringRequest request = new StringRequest(Request.Method.POST, getfrom_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.i("My success", "" + response);
                try {
                    JSONArray sample=new JSONArray(response);
                    for(int i=0;i<sample.length();i++){
                        JSONObject jo=sample.getJSONObject(i);
                        String desc=jo.getString("unit_name");
                        String id=jo.getString("unit_id");

                        Log.i("desc",desc);
                        from_list.add(desc);
                        from_id_list.add(id);
                        ArrayAdapter<String> spinAdapterr=new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_dropdown_item,from_list);
                        spinner_from.setAdapter(spinAdapterr);
                        spinner_from.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                from_value=from_id_list.get(position);
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
                map.put("type_id",type_value);

                return map;
            }
        };
        queue.add(request);
    }
    public void getdata(){
        InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(
                Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(count.getWindowToken(), 0);

        final ArrayList<String>headlist=new ArrayList<>();
        final ArrayList<String>resultlist=new ArrayList<>();
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        StringRequest request = new StringRequest(Request.Method.POST, getData, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.i("My success", "" + response);
                try {
                    JSONArray sample=new JSONArray(response);
                    for(int i=0;i<sample.length();i++){
                        JSONObject jo=sample.getJSONObject(i);
                        String to_conversion_unit_id=jo.getString("to_conversion_unit_id");
                        String unit_name=jo.getString("unit_name");
                        String output_value=jo.getString("output_value");
                        headlist.add(unit_name);
                        resultlist.add(output_value);
                        Log.i("to_conversion_unit_id",to_conversion_unit_id);
                        Log.i("unit_name",unit_name);
                        Log.i("output_value",output_value);



                    }
                    Activity activity = null;
                    AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
                    final AlertDialog alertDialog = dialogBuilder.create();
                    LayoutInflater factory = LayoutInflater.from(getActivity());
                    final View vi = factory.inflate(R.layout.alert_result, null);
                    tablelayout = (TableLayout)vi.findViewById(R.id.tablelayout);
                    tablelayout.removeAllViews();

                    tablelayout.setVisibility(View.VISIBLE);
                    for(int i=0;i<headlist.size();i++) {
                        TableRow tbrowtm = new TableRow(getActivity());
                        TextView tvtm = new TextView(getActivity());
                        tvtm.setText(" UnitName ");
                        tvtm.setTypeface(null, Typeface.BOLD);
                        tvtm.setTextColor(Color.BLACK);
                        tbrowtm.addView(tvtm);
                        TextView tvmr = new TextView(getActivity());
                        tvmr.setText(headlist.get(i));
                        tvmr.setTypeface(null, Typeface.BOLD);
                        tvmr.setTextColor(Color.BLACK);
                        tbrowtm.addView(tvmr);
                        tablelayout.addView(tbrowtm);


                        TableRow tbrowtpi = new TableRow(getActivity());
                        TextView tvtpi = new TextView(getActivity());
                        tvtpi.setText(" Output Value ");
                        tvtpi.setTypeface(null, Typeface.BOLD);
                        tvtpi.setTextColor(Color.BLACK);
                        tbrowtpi.addView(tvtpi);
                        TextView tvtpir = new TextView(getActivity());
                        tvtpir.setText(resultlist.get(i));
                        tvtpir.setTextColor(Color.BLACK);
                        tbrowtpi.addView(tvtpir);
                        tablelayout.addView(tbrowtpi);


                    }

                    alertDialog.setView(vi);
                    alertDialog.show();
                    alertDialog.setCancelable(true);


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
                map.put("type_id",type_value);
                map.put("unit_id",from_value);
                map.put("size",count.getText().toString());

                return map;
            }
        };
        queue.add(request);
    }
}
