package com.learning.sitrageneral;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

public class Testing_Calibration extends AppCompatActivity {
TextView linkone,linktwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing__calibration);
        linkone=(TextView)findViewById(R.id.link_one);
        linktwo=(TextView)findViewById(R.id.link_two);
        String linkk="<a href=Testing Charges>Testing Charges</a>";
        linkone.setText(Html.fromHtml(linkk));
        linkone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pdf="http://cliqinnovations.com/projects/sitra/wp-content/uploads/2018/07/Calibration-charges.pdf";
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(pdf));
                startActivity(browserIntent);
            }
        });

        String link_two="<a href=List of Instruments Calibrated>List of Instruments Calibrated</a>";
        linktwo.setText(Html.fromHtml(link_two));
        linktwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Testing_Calibration.this,Employment.class);
                intent.putExtra("link","http://cliqinnovations.com/projects/sitra/list-of-instruments-calibrated/");
                startActivity(intent);

            }
        });
    }
}
