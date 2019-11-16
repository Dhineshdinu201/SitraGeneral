package com.learning.sitrageneral;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.sitra.general.R;
import android.widget.TextView;

public class Con_Engg extends AppCompatActivity {
TextView txtview,txt_head;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_con__engg);
        txtview=(TextView)findViewById(R.id.txtview);
        txt_head=(TextView)findViewById(R.id.txt_head);
        String text=getIntent().getStringExtra("message");
        String head=getIntent().getStringExtra("head");
        txtview.setText(text);
        txt_head.setText(head);
    }
}
