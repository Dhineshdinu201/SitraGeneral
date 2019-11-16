package com.learning.sitrageneral;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.sitra.general.R;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

public class Coe extends AppCompatActivity {

    TextView general,general_text,org,contact,org_text,contact_text;
    ImageView close_general,close_org,close_contact,orgchart;
    int i=1,j=2,k=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coe);
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
                    general_text.setText("•\tPrototype development\n" +
                            "•\tPilot scale production\n" +
                            "•\tTesting and evaluation\n" +
                            "•\tTraining and seminar\n" +
                            "•\tStandard formulation\n" +
                            "•\tIncubation services\n" +
                            "•\tInformation resources\n" +
                            "•\tResearch and development\n" +
                            "•\tTechnical consultancy\n" +
                            "•\tDetailed project report\n");
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
                    String orgg_text="1.\tSurgical Non-woven face masks\n" +
                            "2.\tCrepe Bandages\n" +
                            "3.\tAlcohol Wet Wipes\n" +
                            "4.\tNon Woven Surgical Aprons\n" +
                            "5.\tCompression Stockings\n" +
                            "6.\tSurgeons cap\n" +
                            "7.\tShoe cover\n" +
                            "8.\tWet wipes\n" +
                            "9.\tSanitary napkin\n" +
                            "10.\tSurgical Cotton\n" +
                            "11.\tBuffount Cap\n" +
                            "12.\tSurgical Gauze\n" ;
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
                    String con="MACHINERIES\n" +
                            "•\tSpun lace Non-Woven Plant\n" +
                            "•\tFace mask production unit\n" +
                            "•\tWarp knitting\n" +
                            "•\tCompression knitting\n" +
                            "•\tNarrow width loom\n" +
                            "•\tCartesian braiding machines\n" +
                            "•\tProjectile weaving machine\n" +
                            "•\tElectro spinning\n" +
                            "•\tCoating and laminating machine\n" +
                            "•\tCotton wool roll making machine\n" +
                            "•\tUltrasonic welding machine\n" +
                            "•\tAlcohol Pad & Wet Wipe making machine\n" +
                            "•\tSanitary Napkin machine\n" +
                            "INSTRUMENTS\n" +
                            "1.\tField Emission Scanning Electron Microscope (FESEM)\n" +
                            "2.\tSynthetic Blood Penetration Resistance Tester\n" +
                            "3.\tHydrohead Tester\n" +
                            "4.\tM259 B – Sweating Guarded Hotplate\n" +
                            "5.\tMoisture Management Tester\n" +
                            "6.\tGelbo Flex Tester\n" +
                            "7.\tCapillary Flow Porometer\n" +
                            "8.\tTensiometer\n" +
                            "9.\tCompression Bandage Pressure Measurement System\n" +
                            "10.\tFlushability Tester\n" +
                            "11.\tLister Ac & Wetback\n" +
                            "12.\tRun – Off Tester\n" +
                            "13.\tMartindale abrasion, pilling tester\n" +
                            "14.\tHigh Performance Thin Layer Chromatography\n" +
                            "15.\tGas Chromatography\n" +
                            "16.\tHigh Performance Liquid Chromatography (HPLC)\n" +
                            "17.\tFourier Transform Infrared Spectrophotometer (FTIR)\n" +
                            "18.\tAtomic Absorption Spectroscopy\n" +
                            "19.\tVertical Flammability Tester\n" +
                            "20.\tInductively Coupled Plasma Mass Spectrometry (ICPMS)etc\n";
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
