package com.learning.sitrageneral;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

public class Testint_Weaving extends AppCompatActivity {
TextView link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testint__weaving);
        link=(TextView)findViewById(R.id.link);
        String linkk="<center><a href=woven and knitted fabric testing charges>woven and knitted fabric testing charges</a></center>";
        link.setText(Html.fromHtml(linkk));
        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pdf="http://cliqinnovations.com/projects/sitra/wp-content/uploads/2018/07/KnitingTestingcharges.pdf";
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(pdf));
                startActivity(browserIntent);
            }
        });
    }
}
