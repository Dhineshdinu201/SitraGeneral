package com.learning.sitrageneral;

import android.app.Activity;
import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import java.util.ArrayList;

public class Input1 extends AppCompatActivity {
    //declaration
    Spinner sp_mode,sp_type;
    EditText span_length,bundle_strength,micronaire_value,yarn_count,comber_noil;
    Button get_result;
    ArrayList<String> dropdown_mode,dropdown_type;
    String str_span_length,str_bundle_strength,str_micronaire_value,str_yarn_count,str_comber_noil,result_mode,result_type;

    int i_span_length,i_bundle_strength,i_micrnaire_value,i_yarn_count,i_comber_noil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input1);
        sp_mode=(Spinner)findViewById(R.id.spinner_mode);
        sp_type=(Spinner)findViewById(R.id.spinner_type);
        span_length=(EditText)findViewById(R.id.span_length);
        bundle_strength=(EditText)findViewById(R.id.bundle_strength);
        micronaire_value=(EditText)findViewById(R.id.micronaire);
        yarn_count=(EditText)findViewById(R.id.yarn_count);
        comber_noil=(EditText)findViewById(R.id.comber_noil);
        get_result=(Button)findViewById(R.id.get_result);
        getSpinnerMode();
        getSpinnerType();
        get_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validation();
            }
        });
    }
    public void getSpinnerMode(){
        dropdown_mode=new ArrayList<>();
        dropdown_mode.add("ICC");
        dropdown_mode.add("HVI");
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(getApplicationContext(),  android.R.layout.simple_spinner_dropdown_item, dropdown_mode);
        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);
        sp_mode.setAdapter(adapter);
        sp_mode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        result_type = dropdown_mode.get(position);
                        break;
                    case 1:
                        result_type = dropdown_mode.get(position);

                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView parent) {

            }
        });
    }
    public void getSpinnerType(){
        dropdown_type=new ArrayList<>();
        dropdown_type.add("Carded");
        dropdown_type.add("Combed");
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(getApplicationContext(),  android.R.layout.simple_spinner_dropdown_item, dropdown_type);
        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);
        sp_type.setAdapter(adapter);
        sp_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        result_mode = dropdown_type.get(position);
                        break;
                    case 1:
                        result_mode = dropdown_type.get(position);

                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView parent) {

            }
        });
    }
    public void validation(){
        str_span_length=span_length.getText().toString();
        str_bundle_strength=bundle_strength.getText().toString();
        str_micronaire_value=micronaire_value.getText().toString();
        str_yarn_count=yarn_count.getText().toString();
        str_comber_noil=comber_noil.getText().toString();
        try{
            i_span_length= Integer.parseInt(str_span_length);
            i_bundle_strength= Integer.parseInt(str_bundle_strength);
            i_micrnaire_value= Integer.parseInt(str_micronaire_value);
            i_yarn_count= Integer.parseInt(str_yarn_count);
            i_comber_noil= Integer.parseInt(str_comber_noil);
            if(i_span_length<=10||i_span_length>=120){
                Toast.makeText(Input1.this, "Span length value should between 10 to 120", Toast.LENGTH_SHORT).show();
            }
            else if(i_bundle_strength<=10||i_bundle_strength>=120){
                Toast.makeText(Input1.this, "Bundle strength value should between 10 to 120", Toast.LENGTH_SHORT).show();
            }
            else if(i_micrnaire_value<=10||i_micrnaire_value>=120){
                Toast.makeText(Input1.this, "Micronaire value should between 10 to 120", Toast.LENGTH_SHORT).show();
            }
            else if(i_yarn_count<=10||i_yarn_count>=120){
                Toast.makeText(Input1.this, "Yarn count should between 10 to 120", Toast.LENGTH_SHORT).show();
            }
            else if(i_comber_noil<=10||i_comber_noil>=120){
                Toast.makeText(Input1.this, "Comber noil value should between 10 to 120", Toast.LENGTH_SHORT).show();
            }
            else {
                get_result.setEnabled(false);
                Calculation();
            }
        }catch (Exception e){
            Toast.makeText(Input1.this, "please enter valid input", Toast.LENGTH_SHORT).show();
        }
    }

    public void Calculation(){
        showDialog("Result","2950");
    }
    public void showDialog(String s_result_head,String s_result_value){
        get_result.setEnabled(true);
        Activity activity = null;
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        ListView a_listview ;


        final AlertDialog alertDialog = dialogBuilder.create();
        LayoutInflater factory = LayoutInflater.from(this);
        final View v = factory.inflate(R.layout.alert_input_result, null);
        TextView result_head,result_value;
        result_head=(TextView)v.findViewById(R.id.result_head);
        result_value=(TextView)v.findViewById(R.id.result_text);
        result_head.setText(s_result_head);
       result_value.setText(s_result_value);
        alertDialog.setView(v);
        alertDialog.show();
        alertDialog.setCancelable(true);

    }
}
