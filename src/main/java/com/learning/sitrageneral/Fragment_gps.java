package com.learning.sitrageneral;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.InputFilter;
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
import android.widget.ImageView;
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

public class Fragment_gps extends Fragment {
    Spinner spinner_desc;
    EditText count;
    Button reset,getdata;
    List<String> list;
    TextView head,result_head,result;
    String value;
    TableLayout stk;
    Constant constant=new Constant();
    String url = constant.ip+"get_gps_description_lists";
    String getdata_url=constant.ip+"get_gps_conversion_data";
    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstancetate) {
        View view = inflater.inflate(R.layout.fragment_gps, container, false);
        spinner_desc=(Spinner)view.findViewById(R.id.spinner_desc);
        count=(EditText)view.findViewById(R.id.count);
        count.setFilters(new InputFilter[] {new InputFilter.LengthFilter(3)});
        reset=(Button)view.findViewById(R.id.reset);
        getdata=(Button)view.findViewById(R.id.getdata);
        head=(TextView)view.findViewById(R.id.head);
        result_head=(TextView)view.findViewById(R.id.result_head);
        result=(TextView)view.findViewById(R.id.result);

        head.setText("40s converted Grams / Spindle");
        send();
        ArrayAdapter<String> spinAdapter=new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_dropdown_item,list);
        spinner_desc.setAdapter(spinAdapter);
        spinner_desc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                value=list.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
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
        list.add("Select Count Description");
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.i("My success", "" + response);
                try {
                    JSONArray sample=new JSONArray(response);
                    for(int i=0;i<sample.length();i++){
                        String sample_no=sample.getString(i);
                        Log.i("sample_no",sample_no);
                        list.add(sample_no);
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
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        StringRequest request = new StringRequest(Request.Method.POST, getdata_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.i("My success", "" + response);
                try {
                    JSONObject object=new JSONObject(response);
                    String countdesc=object.getString("countdesc");
                    String speed=object.getString("speed");
                    String tpi=object.getString("tpi");
                    String tm=object.getString("tm");
                    String effy=object.getString("effy");
                    String gps=object.getString("gps");
                    String conversion_factor=object.getString("conversion_factor");
                    String count=object.getString("count");
                    String description=object.getString("description");
                    Activity activity = null;
                    AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
                    final AlertDialog alertDialog = dialogBuilder.create();
                    LayoutInflater factory = LayoutInflater.from(getActivity());
                    final View vi = factory.inflate(R.layout.alert_result, null);
                    stk = (TableLayout)vi.findViewById(R.id.tablelayout);
                    stk.removeAllViews();
                    TableRow tbrow0 = new TableRow(getActivity());
                    TextView tv0 = new TextView(getActivity());
                    tv0.setText(" Count Description ");
                    tv0.setTypeface(null, Typeface.BOLD);
                    tv0.setTextColor(Color.BLACK);
                    tbrow0.addView(tv0);
                    TextView tv1 = new TextView(getActivity());
                    tv1.setText(countdesc);
                    tv1.setTextColor(Color.BLACK);
                    tbrow0.addView(tv1);
                    stk.addView(tbrow0);


                    TableRow tbrowsp = new TableRow(getActivity());
                    TextView tvsp = new TextView(getActivity());
                    tvsp.setText(" Speed ");
                    tvsp.setTypeface(null, Typeface.BOLD);
                    tvsp.setTextColor(Color.BLACK);
                    tbrowsp.addView(tvsp);
                    TextView tvspr = new TextView(getActivity());
                    tvspr.setText(speed);
                    tvspr.setTextColor(Color.BLACK);
                    tbrowsp.addView(tvspr);
                    stk.addView(tbrowsp);


                    TableRow tbrowtpi = new TableRow(getActivity());
                    TextView tvtpi = new TextView(getActivity());
                    tvtpi.setText(" TPI ");
                    tvtpi.setTypeface(null, Typeface.BOLD);
                    tvtpi.setTextColor(Color.BLACK);
                    tbrowtpi.addView(tvtpi);
                    TextView tvtpir = new TextView(getActivity());
                    tvtpir.setText(tpi);
                    tvtpir.setTextColor(Color.BLACK);
                    tbrowtpi.addView(tvtpir);
                    stk.addView(tbrowtpi);


                    TableRow tbrowtm = new TableRow(getActivity());
                    TextView tvtm = new TextView(getActivity());
                    tvtm.setText(" TM ");
                    tvtm.setTypeface(null, Typeface.BOLD);
                    tvtm.setTextColor(Color.BLACK);
                    tbrowtm.addView(tvtm);
                    TextView tvmr = new TextView(getActivity());
                    tvmr.setText(tm);
                    tvmr.setTextColor(Color.BLACK);
                    tbrowtm.addView(tvmr);
                    stk.addView(tbrowtm);



                    TableRow tbroweffy = new TableRow(getActivity());
                    TextView tveffy = new TextView(getActivity());
                    tveffy.setText(" Efficiency ");
                    tveffy.setTypeface(null, Typeface.BOLD);
                    tveffy.setTextColor(Color.BLACK);
                    tbroweffy.addView(tveffy);
                    TextView tveffyr = new TextView(getActivity());
                    tveffyr.setText(effy);
                    tveffyr.setTextColor(Color.BLACK);
                    tbroweffy.addView(tveffyr);
                    stk.addView(tbroweffy);


                    TableRow tbrowgps = new TableRow(getActivity());
                    TextView tvgps = new TextView(getActivity());
                    tvgps.setText(" GPS ");
                    tvgps.setTypeface(null, Typeface.BOLD);
                    tvgps.setTextColor(Color.BLACK);
                    tbrowgps.addView(tvgps);
                    TextView tvgpsr = new TextView(getActivity());
                    tvgpsr.setText(gps);
                    tvgpsr.setTextColor(Color.BLACK);
                    tbrowgps.addView(tvgpsr);
                    stk.addView(tbrowgps);


                    TableRow tbrowcf = new TableRow(getActivity());
                    TextView tvcf = new TextView(getActivity());
                    tvcf.setText(" Conversion Factor ");
                    tvcf.setTypeface(null, Typeface.BOLD);
                    tvcf.setTextColor(Color.BLACK);
                    tbrowcf.addView(tvcf);
                    TextView tvcfr = new TextView(getActivity());
                    tvcfr.setText(conversion_factor);
                    tvcfr.setTextColor(Color.BLACK);
                    tbrowcf.addView(tvcfr);
                    stk.addView(tbrowcf);

                    TableRow tbrowc = new TableRow(getActivity());
                    TextView tvc= new TextView(getActivity());
                    tvc.setText(" Count ");
                    tvc.setTypeface(null, Typeface.BOLD);
                    tvc.setTextColor(Color.BLACK);
                    tbrowc.addView(tvc);
                    TextView tvcr = new TextView(getActivity());
                    tvcr.setText(count);
                    tvcr.setTextColor(Color.BLACK);
                    tbrowc.addView(tvcr);
                    stk.addView(tbrowc);

                    TableRow tbrowd = new TableRow(getActivity());
                    TextView tvd= new TextView(getActivity());
                    tvd.setText(" Description ");
                    tvd.setTypeface(null, Typeface.BOLD);
                    tvd.setTextColor(Color.BLACK);
                    tbrowd.addView(tvd);
                    TextView tvdr = new TextView(getActivity());
                    tvdr.setText(description);
                    tvdr.setTextColor(Color.BLACK);
                    tbrowd.addView(tvdr);
                    stk.addView(tbrowd);





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
                map.put("count",s_count);
                map.put("description",""+value);
                Log.i("count",s_count);
                Log.i("description",""+value);
                return map;
            }
        };
        queue.add(request);
    }
    public void showemp(){



    }
}
