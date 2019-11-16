package com.learning.sitrageneral;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;
import com.sitra.general.R;

public class Plsc_consultancy extends AppCompatActivity {
    TextView general,general_text,org,contact,org_text,contact_text;
    ImageView close_general,close_org,close_contact,orgchart;
    int i=1,j=2,k=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plsc_consultancy);
        close_general=(ImageView)findViewById(R.id.close_general);
        general=(TextView)findViewById(R.id.general);
        general_text=(TextView)findViewById(R.id.general_text);
        close_org=(ImageView)findViewById(R.id.close_org);
        org=(TextView)findViewById(R.id.org);
        org_text=(TextView)findViewById(R.id.org_text);
        close_contact=(ImageView)findViewById(R.id.close_contact);
        contact=(TextView)findViewById(R.id.contact);
        contact_text=(TextView)findViewById(R.id.contact_text);

        close_general.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=i+1;
                if(i%2==0) {
                    general_text.setVisibility(View.VISIBLE);
                    close_general.setVisibility(View.VISIBLE);
                    general_text.setText("       \u2022\tProduct diversification.\n" +
                            "       \u2022\tTechnology upgradation and modernisation of looms.\n" +
                            "       \u2022\tImproving quality and productivity.\n" +
                            "       \u2022\tMinimising waste.\n" +
                            "       \u2022\tMaintenance of machinery to prevent break downs.\n" +
                            "       \u2022\tAttaching mechanisms like drill, satin, dobby, jacquard, dropbox, terry etc., to produce variety of fabrics.\n" +
                            "       \u2022\tGuidance for exporters.");
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        general_text.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
                    }
                    close_general.setImageResource(R.drawable.sub);
                }else{
                    general_text.setVisibility(View.GONE);
                    close_general.setImageResource(R.drawable.add);
                }

            }
        });


        close_org.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=i+1;
                if(i%2==0) {
                    org_text.setVisibility(View.VISIBLE);
                    close_org.setVisibility(View.VISIBLE);
                    String orgg_text="     Seminars and workshops are organised periodically on the following topics:\n" +
                            "\n" +
                            "       \u2022\tEntrepreneur development programme\n" +
                            "       \u2022\tQuality control\n" +
                            "       \u2022\tTUF scheme\n" +
                            "       \u2022\tExport procedures\n" +
                            "       \u2022\tProcess control in sizing\n" +
                            "       \u2022\tWTO and its implications\n" +
                            "       \u2022\tEco friendly textiles\n" +
                            "       \u2022\tTechnical textiles" ;
                    org_text.setText(orgg_text);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        org_text.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
                    }
                    close_org.setImageResource(R.drawable.sub);
                }else{
                    org_text.setVisibility(View.GONE);
                    close_org.setImageResource(R.drawable.add);
                }

            }
        });
        close_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                j=j+1;
                if(j%2==0) {
                    contact_text.setVisibility(View.VISIBLE);
                    close_contact.setVisibility(View.VISIBLE);
                    String con="        The following training programs are conducted for upgrading the skills of powerloom owners, weavers and jobbers:\n" +
                            "\n" +
                            "       \u2022\tPowerloom mechanism\n" +
                            "       \u2022\tDropbox mechanism\n" +
                            "       \u2022\tDobby mechanism\n" +
                            "       \u2022\tWeaving calculations\n" +
                            "       \u2022\tFabric designs\n" +
                            "       \u2022\tEco friendly dyeing of reactive colours\n" +
                            "       \u2022\tDyeing of vat colours";
                    contact_text.setText(con);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        general_text.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
                    }
                    close_contact.setImageResource(R.drawable.sub);
                }else{
                    contact_text.setVisibility(View.GONE);
                    close_contact.setImageResource(R.drawable.add);
                }

            }
        });

    }
}
