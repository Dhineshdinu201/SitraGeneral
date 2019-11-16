package com.learning.sitrageneral;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import com.sitra.general.R;
import android.widget.TextView;

public class TextView_html extends AppCompatActivity {

    TextView txtview,txt_head;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view_html);
        txtview=(TextView)findViewById(R.id.txtview);
        txt_head=(TextView)findViewById(R.id.txt_head);
        String text=getIntent().getStringExtra("message");
        String head=getIntent().getStringExtra("head");
        txtview.setText(Html.fromHtml(text));
        txt_head.setText(head);
    }
}
