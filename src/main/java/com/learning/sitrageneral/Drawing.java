package com.learning.sitrageneral;

import android.app.Activity;
import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Drawing extends AppCompatActivity {
    ArrayList<String> para_name=new ArrayList<>();
    ArrayList<String>results=new ArrayList<>();
    Button btn_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing);
        btn_result=(Button)findViewById(R.id.btn_result);
        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showwdialog();
            }
        });
        para_name.add("count group");
        para_name.add("Delivery Speed(mpm)");
        para_name.add("silver hank");
        para_name.add("Machine efficiency(%)");
        para_name.add("Production per delivery/8 hours");
        results.add("35s-45s");
        results.add("150");
        results.add("0.12");
        results.add("43");
        results.add("43");

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
