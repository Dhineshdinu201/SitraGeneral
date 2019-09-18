package com.learning.sitrageneral;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

public class AboutUs extends AppCompatActivity {
TextView general,general_text,org,contact,org_text,contact_text;
ImageView close_general,close_org,close_contact,orgchart;
int i=1,j=2,k=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        close_general=(ImageView)findViewById(R.id.close_general);
        general=(TextView)findViewById(R.id.general);
        general_text=(TextView)findViewById(R.id.general_text);
        close_org=(ImageView)findViewById(R.id.close_org);
        orgchart=(ImageView)findViewById(R.id.orgchart);
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
                    general_text.setText("      SITRA, an acronym for The South India Textile Research Association, and established in the year 1956, is governed by a Council of Administration consisting of member representatives of the Industry, Government and Scientists. SITRA is sponsored by the Industry and is supported by the Ministry of Textiles, Government of India.\n" +
                            "\n" +
                            "       Sprawling in a campus of about 13.14 hectares, SITRA is within easy access of a large number of textile mills. With a floor space of about 15,000 sq. m., SITRA houses its well equipped testing, electronics and calibration laboratories, pilot mills, library, etc. SITRA has a full range of sophisticated textile testing instruments and modern machines and is one of the best equipped textile research organizations in the World.\n" +
                            "\n");
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
                    orgchart.setVisibility(View.VISIBLE);
                    String orgg_text="<h1><b>"+"MEMBERSHIP"+"</b></h1>"+"<br>" +
                            "<h5>"+"<b>"+ "A. REGULAR MEMBERSHIP"+"</b>"+"</h2>"+ "<br>" +
                            "The following categories of regular membership are available:" +"<br>" +
                            "<h5>"+"<b>"+"1. FULL MEMBER"+"</b>"+"</h2>"+"  Textile units situated in SITRA Region can become full members" +"<br>" +
                            "<h5>"+"<b>"+"2. ASSOCIATE MEMBER"+"</b>"+"</h2>"+"  Textile units situated outside SITRA Region as well as in foreign countries may become associate members"+"<br>" +
                            "<h5>"+"<b>"+"MEMBERSHIP BENEFITS" +"</b>"+"</h2>" +"<br>" +
                            "The membership facilities as well as services available to full members and associate members are identical except that associate members do not have any voting rights." +"<br>" +
                            "<h5>"+"<b>"+ "B. TECHNICAL SERVICE CARD (TSC) HOLDERS" +"</b>"+"</h2>" +"<br>" +
                            "Limited membership facilities are extended to Small Scale Spinning Mills, Allied and Non-Textile units under Technical Service Card."+"<br>" ;
                    org_text.setText(Html.fromHtml(orgg_text));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        org_text.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
                    }
                    close_org.setImageResource(R.drawable.sub);
                }else{
                    org_text.setVisibility(View.GONE);
                    orgchart.setVisibility(View.GONE);
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
                    String con="<h1>"+"<b> <font color=blue>"+"THE SOUTH INDIA TEXTILE RESEARCH ASSOCIATION"+"</b></font"+"</h1>"+"<br>" +
                            "<p>"+"13/37, Avinashi Road," +"<br>"+
                            "<br>" +
                            "Coimbatore Aerodrome Post," +"<br>"+"<br>"+
                            "Coimbatore – 641 014"
                            +"<br>"+
                            "Phone: 0422-2574367-9, 4215333" +"<br>"
                            +"<br>" +
                            "Fax: 0422-2571896, 4215300"  +"<br>" +
                            "E-Mail: <a href='info@sitra.org.in' target='_blank'> info@sitra.org.in"+"</a>"  +"<br>"
                            +"<br>" +
                            "Website: www.sitra.org.in"+"</p>";
                    contact_text.setText(Html.fromHtml(con));
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
