package com.learning.sitrageneral;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;
import com.sitra.general.R;

public class plsc_contact extends AppCompatActivity {
   TextView chennimalaitext,karur_text,komarapalayam_text,palladam_text,rajapalayam_text,salem_text,somanur_text,tiruchengode_text,plsc_head_text;
    int a=2,b=2,c=2,d=2,e=2,f=2,g=2,h=2,i=2;
   ImageView close_chennimalai,close_karur,close_komarapalayam,close_palladam,close_rajapalayam,close_salem,close_somanur,close_tiruchengode,close_plsce_head;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plsc_contact);
        close_plsce_head=(ImageView)findViewById(R.id.close_plsc_head);
        close_chennimalai=(ImageView)findViewById(R.id.close_chennimalai);
        close_karur=(ImageView)findViewById(R.id.close_karur);
        close_komarapalayam=(ImageView)findViewById(R.id.close_komarapalayam);
        close_palladam=(ImageView)findViewById(R.id.close_palladam);
        close_rajapalayam=(ImageView)findViewById(R.id.close_rajapalayam);
        close_salem=(ImageView)findViewById(R.id.close_selam);
        close_somanur=(ImageView)findViewById(R.id.close_somanur);
        close_tiruchengode=(ImageView)findViewById(R.id.close_tiruchengode);
        chennimalaitext=(TextView)findViewById(R.id.chennimalai_text);
        karur_text=(TextView)findViewById(R.id.karur_text);
        komarapalayam_text=(TextView)findViewById(R.id.komarapalayam_text);
        palladam_text=(TextView)findViewById(R.id.palladam_text);
        rajapalayam_text=(TextView)findViewById(R.id.rajapalayam_text);
        salem_text=(TextView)findViewById(R.id.selam_text);
        somanur_text=(TextView)findViewById(R.id.somanur_text);
        tiruchengode_text=(TextView)findViewById(R.id.tiruchengode_text);
        plsc_head_text=(TextView)findViewById(R.id.plsc_head_text);

        close_plsce_head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=i+1;
                if(i%2==0) {
                    plsc_head_text.setVisibility(View.VISIBLE);
                    close_plsce_head.setVisibility(View.VISIBLE);
                    plsc_head_text.setText("A Sankaranamasivam\n" +
                            "\n" +
                            "No.4, Ragavendra Street,\n" +
                            "\n" +
                            "KOMARAPALAYAM-638 183.\n" +
                            "\n" +
                            "Phone  : (04288) 261019\n" +
                            "\n" +
                            "Telefax : (04288) 261019\n" +
                            "\n" +
                            "E-mail   : p lsc@sitra.org.i");
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        plsc_head_text.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
                    }
                    close_plsce_head.setImageResource(R.drawable.sub);
                }else{
                    plsc_head_text.setVisibility(View.GONE);
                    close_plsce_head.setImageResource(R.drawable.add);
                }

            }
        });
        close_chennimalai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a=a+1;
                if(a%2==0) {
                    chennimalaitext.setVisibility(View.VISIBLE);
                    close_chennimalai.setVisibility(View.VISIBLE);
                    chennimalaitext.setText("T.Karthikeyan \n" +
                            "\n" +
                            "SITRA Textile Service Centre\n" +
                            "\n" +
                            "24, Ground Floor\n" +
                            "\n" +
                            "Uthukuli Road,\n" +
                            "\n" +
                            "Chennimalai- 638 051\n" +
                            "\n" +
                            "Tamil Nadu\n" +
                            "\n" +
                            "Phone: (042940) 250575");
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        chennimalaitext.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
                    }
                    close_chennimalai.setImageResource(R.drawable.sub);
                }else{
                    chennimalaitext.setVisibility(View.GONE);
                    close_chennimalai.setImageResource(R.drawable.add);
                }

            }
        });
        close_karur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b=b+1;
                if(b%2==0) {
                    karur_text.setVisibility(View.VISIBLE);
                    close_karur.setVisibility(View.VISIBLE);
                    karur_text.setText("T.Karthikeyan\n" +
                            "\n" +
                            "3A, Ramakrishnapuram North,\n" +
                            "\n" +
                            "Karur- 639 001\n" +
                            "\n" +
                            "Tamil Nadu\n" +
                            "\n" +
                            "Phone  : (04324) 230829\n" +
                            "\n" +
                            "Telefax : (04324) 230829\n" +
                            "\n" +
                            "E-mail   : plsckru@sitra.org.i");
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        karur_text.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
                    }
                    close_karur.setImageResource(R.drawable.sub);
                }else{
                    karur_text.setVisibility(View.GONE);
                    close_karur.setImageResource(R.drawable.add);
                }

            }
        });
        close_komarapalayam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c=c+1;
                if(c%2==0) {
                    komarapalayam_text.setVisibility(View.VISIBLE);
                    close_komarapalayam.setVisibility(View.VISIBLE);
                    komarapalayam_text.setText("G.Panneer Selvam\n" +
                            "\n" +
                            "No.4, Ragavendra Street,\n" +
                            "\n" +
                            "KOMARAPALAYAM-638 183.\n" +
                            "\n" +
                            "Phone  : (04288) 261019\n" +
                            "\n" +
                            "Telefax : (04288) 261019\n" +
                            "\n" +
                            "E-mail   : p lsckpm@sitra.org.in");
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        komarapalayam_text.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
                    }
                    close_komarapalayam.setImageResource(R.drawable.sub);
                }else{
                    komarapalayam_text.setVisibility(View.GONE);
                    close_komarapalayam.setImageResource(R.drawable.add);
                }

            }
        });
        close_palladam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d=d+1;
                if(d%2==0) {
                    palladam_text.setVisibility(View.VISIBLE);
                    close_palladam.setVisibility(View.VISIBLE);
                    palladam_text.setText("K.Kanagaraj\n" +
                            "\n" +
                            "2/363-B, Near Kongu Vellalar\n" +
                            "\n" +
                            "Kalyana Mandapam,\n" +
                            "\n" +
                            "Kalivelampatti Pirivu, Trichy Road,\n" +
                            "\n" +
                            "PALLADAM-641 662.Tirupur District.\n" +
                            "\n" +
                            "Phone : (04255) 253153\n" +
                            "\n" +
                            "Telefax: (04255) 253153\n" +
                            "\n" +
                            "E-mail  : plscpdm@sitra.org.");
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        palladam_text.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
                    }
                    close_palladam.setImageResource(R.drawable.sub);
                }else{
                    palladam_text.setVisibility(View.GONE);
                    close_palladam.setImageResource(R.drawable.add);
                }

            }
        });
        close_rajapalayam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e=e+1;
                if(e%2==0) {
                    rajapalayam_text.setVisibility(View.VISIBLE);
                    close_rajapalayam.setVisibility(View.VISIBLE);
                    rajapalayam_text.setText("P.Subramanian\n" +
                            "\n" +
                            "10-B, Pugalenthi Road,\n" +
                            "\n" +
                            "(Opp. Ramalinga Ginning Mills),\n" +
                            "\n" +
                            "Cotton Market,\n" +
                            "\n" +
                            "Rajapalayam-626 117.\n" +
                            "\n" +
                            "Phone   : (04563) 226487\n" +
                            "\n" +
                            "Telefax  : (04563) 226487\n" +
                            "\n" +
                            "E-mail   :   plscrjpm@sitra.org");
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        rajapalayam_text.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
                    }
                    close_rajapalayam.setImageResource(R.drawable.sub);
                }else{
                    rajapalayam_text.setVisibility(View.GONE);
                    close_rajapalayam.setImageResource(R.drawable.add);
                }

            }
        });
        close_salem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f=f+1;
                if(f%2==0) {
                    salem_text.setVisibility(View.VISIBLE);
                    close_salem.setVisibility(View.VISIBLE);
                    salem_text.setText("S.Muralitharen\n" +
                            "\n" +
                            "J.K.K.Nataraja Nilayam,\n" +
                            "\n" +
                            "1st Floor, Old No.158 / New No.477,\n" +
                            "\n" +
                            "Trichy Main Road, Gugai,\n" +
                            "\n" +
                            "SALEM-636 006.\n" +
                            "\n" +
                            "Phone   : (0427) 2219486\n" +
                            "\n" +
                            "Telefax  : (0427) 2219486\n" +
                            "\n" +
                            "E-mail   : p lscslm@sitra.org.in");
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        salem_text.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
                    }
                    close_salem.setImageResource(R.drawable.sub);
                }else{
                   salem_text.setVisibility(View.GONE);
                    close_salem.setImageResource(R.drawable.add);
                }

            }
        });
        close_somanur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                g=g+1;
                if(g%2==0) {
                    somanur_text.setVisibility(View.VISIBLE);
                    close_somanur.setVisibility(View.VISIBLE);
                    somanur_text.setText("B. Nandhagopal\n" +
                            "\n" +
                            "24, Nachimuthu Street,\n" +
                            "\n" +
                            "Ganesapuram,\n" +
                            "\n" +
                            "SOMANUR-641 668,\n" +
                            "\n" +
                            "Coimbatore District.\n" +
                            "\n" +
                            "Phone   :  (0421) 2333158\n" +
                            "\n" +
                            "E-mail    : plscsmr@sitra.org.in");
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        somanur_text.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
                    }
                    close_somanur.setImageResource(R.drawable.sub);
                }else{
                    somanur_text.setVisibility(View.GONE);
                    close_somanur.setImageResource(R.drawable.add);
                }

            }
        });
        close_tiruchengode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                h=h+1;
                if(h%2==0) {
                    tiruchengode_text.setVisibility(View.VISIBLE);
                    close_tiruchengode.setVisibility(View.VISIBLE);
                    tiruchengode_text.setText("V.Kumar\n" +
                            "\n" +
                            "1/1 Sanarpalayam Road,\n" +
                            "\n" +
                            "Near BSNL Telecom,\n" +
                            "\n" +
                            "Erode Main Road,\n" +
                            "\n" +
                            "Suriyampalayam Post,\n" +
                            "\n" +
                            "Tiruchengode-637 209.\n" +
                            "\n" +
                            "Phone   :  (04288) 255104\n" +
                            "\n" +
                            "Telefax  :  (04288) 255104\n" +
                            "\n" +
                            "E-mail   :   plsctgode@sitra.org.in");
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        tiruchengode_text.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
                    }
                    close_tiruchengode.setImageResource(R.drawable.sub);
                }else{
                    tiruchengode_text.setVisibility(View.GONE);
                    close_tiruchengode.setImageResource(R.drawable.add);
                }

            }
        });




    }
}
