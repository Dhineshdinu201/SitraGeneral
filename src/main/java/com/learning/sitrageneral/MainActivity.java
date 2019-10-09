package com.learning.sitrageneral;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterViewFlipper;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.master.glideimageview.GlideImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {
    ImageView about,consultancy,coe,employment,plsc,testing,training,publications,payments,special_service,enquiry,contactus;
    Context context=this;
    String deviceid="";
    Constant constant=new Constant();
    String android_id;
    ImageView norms;
    String GET_URL=constant.ip+"app_registration";
    View view1,view2;
    TextView txt_enquiry,txt_profile,txt_logout;
    ArrayAdapter arrayAdapter;
    ArrayList<String>images=new ArrayList<>();
    ArrayList<String>announcement=new ArrayList<>();
    TextView notification;
    ImageView profile,logout;
    LinearLayout log,log1;
    String url=constant.ip+"app_sitragen_announcement_lists";
    private SharedPreferences mpref;
    private static final String PREF_NAME="SP_NAME";
    String unique_id="";
    String id;
    String idd;
    AdapterViewFlipper adapterViewFlipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        api();
        WifiManager manager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = manager.getConnectionInfo();
        android_id = Settings.Secure.getString(getContentResolver(),
                Settings.Secure.ANDROID_ID);
        Log.i("add",android_id);
        // splash=(ImageButton) findViewById(R.id.splash);
        //Splash Screen
        deviceid=android_id;

        view1=(View)findViewById(R.id.view1);
        view2=(View)findViewById(R.id.view2);
        txt_enquiry=(TextView)findViewById(R.id.txt_enquiry);
        txt_profile=(TextView)findViewById(R.id.txt_profile);
        txt_logout=(TextView)findViewById(R.id.txt_logout);
        log=(LinearLayout)findViewById(R.id.log);
        norms=(ImageView)findViewById(R.id.norms);
        log1=(LinearLayout)findViewById(R.id.log1);
        adapterViewFlipper=(AdapterViewFlipper)findViewById(R.id.adapterViewFlipper_phy);
        slider();
        Log.i("Mainactivity","working");
        notification=(TextView)findViewById(R.id.notification);
        about=(ImageView)findViewById(R.id.about);
        consultancy=(ImageView)findViewById(R.id.consultancy);
        coe=(ImageView)findViewById(R.id.coe);
        employment=(ImageView)findViewById(R.id.employment);
        plsc=(ImageView)findViewById(R.id.plsc);
        testing=(ImageView)findViewById(R.id.testing);
        training=(ImageView)findViewById(R.id.training);
        publications=(ImageView)findViewById(R.id.publications);
        payments=(ImageView)findViewById(R.id.payment);
        special_service=(ImageView)findViewById(R.id.special_service);

                norms.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(intent);
                    }
                });
                payments.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(MainActivity.this,Employment.class);
                        intent.putExtra("link","http://lab.sitraonline.org/index.php/payment/techprocess/");
                        startActivity(intent);
                    }
                });




                about.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(MainActivity.this,CardActivity.class);

                        startActivity(intent);


                    }
                });
                consultancy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showconsultancy();
                    }
                });
                coe.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(MainActivity.this,Coe.class);
                        startActivity(intent);
                    }
                });
                employment.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showemp();
                    }
                });
                plsc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showplsc();
                    }
                });
                testing.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showtesting();
                    }
                });
                training.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(MainActivity.this,webview.class);
                        intent.putExtra("name","training.html");
                        startActivity(intent);
                    }


                });
                publications.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.i("pub","working");
                        showpublications();
                    }
                });


        contactus=(ImageView)findViewById(R.id.contactus);
        contactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,TextView_html.class);
                intent.putExtra("message",
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
                        "Website: www.sitra.org.in"+"</p>");
                intent.putExtra("head","THE SOUTH INDIA TEXTILE RESEARCH ASSOCIATION");
                startActivity(intent);
            }
        });
        profile=(ImageView) findViewById(R.id.profile);
        logout=(ImageView) findViewById(R.id.logout);
        try {

            id=getIntent().getStringExtra("id");
            Log.i("id",""+id);
        }catch (NullPointerException e){
            txt_profile.setVisibility(View.INVISIBLE);
            txt_logout.setVisibility(View.INVISIBLE);
            view1.setVisibility(View.INVISIBLE);
            view2.setVisibility(View.INVISIBLE);
            special_service.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "Please Login", Toast.LENGTH_SHORT).show();
                }


            });
            e.printStackTrace();
        }


        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ProfileActivity.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onBackPressed();
            }
        });
        enquiry=(ImageView)findViewById(R.id.enquiry);
        enquiry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Enquiry.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });


        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.i("My success", response);
                try {
//                    JSONObject obj=new JSONObject(response);
////
////                    JSONArray itemArray=obj.getJSONArray("announcements");
////                    for (int i = 0; i < itemArray.length(); i++) {
////                        int j=itemArray.length();
////                        notification.setText(""+j);
////                        String value=itemArray.getString(i);
////                        Log.e("json", i+"="+value);
////                        announcement.add(value);
////                    }
////
////                    String cache=obj.getString("cache_unique_no");
////                    unique_id=cache;
                        JSONArray ja=new JSONArray(response);
                        for(int i=0;i<ja.length();i++){
                            JSONObject jo=ja.getJSONObject(i);
                            String id=jo.getString("id");
                            String message=jo.getString("message");
                            announcement.add(message);

                        }
                    notification.setText(""+ja.length());
                    notification.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Log.i("noti","working");
                            Activity activity = null;
                            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
                            ListView a_listview ;
                            TextView a_head;

                            final AlertDialog alertDialog = dialogBuilder.create();
                            LayoutInflater factory = LayoutInflater.from(context);
                            final View vi = factory.inflate(R.layout.alert_payment_mode_image, null);
                            String[] dept={"asd","asd","asd","asd","asd","asd","asd","asd","asd","asd","asd"};

                            a_listview=(ListView)vi.findViewById(R.id.list_item);
                            a_head=(TextView)vi.findViewById(R.id.head);
                            a_head.setText("Announcements");
                            Log.i("mmm","++"+announcement);
                            arrayAdapter = new ArrayAdapter(context, android.R.layout.simple_list_item_1, announcement );
                            a_listview.setAdapter(arrayAdapter);






                            alertDialog.setView(vi);
                            alertDialog.show();
                            alertDialog.setCancelable(true);



                        }
                    });



                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(MainActivity.this, "No Network Connection", Toast.LENGTH_LONG).show();
                Log.i("My error", "" + error);
            }
        }) {
            @Override

            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();



                return map;
            }
        };
        queue.add(request);

        mpref=getApplicationContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        idd=mpref.getString("u_id","");
        Log.i("u_id","value"+idd);
        if(idd.equals(unique_id)) {
            Log.i("equal","equal");
        }
        else {
            Log.i("not_equal","not_equal");
            deleteCache(context);

        }
        SharedPreferences.Editor editor=mpref.edit();
        editor.putString("u_id", String.valueOf(unique_id));
        editor.commit();




    }

public void slider(){
    String[]images={
            "http://lab.sitraonline.org/sitra_common_app/banner_images/image-1.jpg",
            "http://lab.sitraonline.org/sitra_common_app/banner_images/image-2.jpg",
            "http://lab.sitraonline.org/sitra_common_app/banner_images/image-3.jpg",
            "http://lab.sitraonline.org/sitra_common_app/banner_images/image-4.jpg",
            "http://lab.sitraonline.org/sitra_common_app/banner_images/image-5.jpg",
    };
ArrayList<String>imagesarray=new ArrayList<>();
imagesarray.add("http://lab.sitraonline.org/sitra_common_app/banner_images/image-1.jpg");
    imagesarray.add("http://lab.sitraonline.org/sitra_common_app/banner_images/image-2.jpg");
    imagesarray.add("http://lab.sitraonline.org/sitra_common_app/banner_images/image-3.jpg");
    imagesarray.add("http://lab.sitraonline.org/sitra_common_app/banner_images/image-4.jpg");
    imagesarray.add("http://lab.sitraonline.org/sitra_common_app/banner_images/image-5.jpg");
    CustomAdapterr customAdapter=new CustomAdapterr(MainActivity.this,imagesarray);
    adapterViewFlipper.setAdapter(customAdapter);
    adapterViewFlipper.setFlipInterval(3000);
    adapterViewFlipper.setAutoStart(true);
}
@Override
public void onResume(){
        super.onResume();
        slider();
}
    @Override
    public void onBackPressed(){


                final android.support.v7.app.AlertDialog.Builder builder=new android.support.v7.app.AlertDialog.Builder(this);
                builder.setCancelable(false);
                builder.setTitle("Logout");
                builder.setMessage("Are you want to logout?");
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                            Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                            homeIntent.addCategory( Intent.CATEGORY_HOME );
                            homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(homeIntent);
                    }
                });
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();


        }

    public void showconsultancy(){
        Activity activity = null;
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        Button close;

        final AlertDialog alertDialog = dialogBuilder.create();
        LayoutInflater factory = LayoutInflater.from(this);
        final View vi = factory.inflate(R.layout.alert_consultancy, null);
        ImageView img_engg,img_landc,img_spinning,img_chemistry,img_weav;
        img_engg=(ImageView)vi.findViewById(R.id.img_eng);
        img_landc=(ImageView)vi.findViewById(R.id.img_landc);
        img_spinning=(ImageView)vi.findViewById(R.id.img_spinning);
        img_chemistry=(ImageView)vi.findViewById(R.id.img_chemistry);
        img_weav=(ImageView)vi.findViewById(R.id.img_weav);
        img_engg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,webview.class);
                intent.putExtra("name","consultancy_engineering.html");
                startActivity(intent);
            }
        });
        img_landc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,webview.class);
                intent.putExtra("name","consultancy_lc.html");
                startActivity(intent);
            }
        });
        img_spinning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,webview.class);
                intent.putExtra("name","consultancy_spinning.html");
                startActivity(intent);
            }
        });
        img_weav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,webview.class);
                intent.putExtra("name","consultancy_weaving.html");
                startActivity(intent);
            }
        });
        img_chemistry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,webview.class);
                intent.putExtra("name","consultancy_chemistry.html");
                startActivity(intent);
            }
        });








        alertDialog.setView(vi);
        alertDialog.show();
        alertDialog.setCancelable(true);


    }
    //kl
    public void showSpecialService(){
        Activity activity = null;
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        Button close;

        final AlertDialog alertDialog = dialogBuilder.create();
        LayoutInflater factory = LayoutInflater.from(this);
        final View vi = factory.inflate(R.layout.alert_conversions, null);
        ImageView img_engg,img_landc,img_spinning,img_chemistry,img_cpq;
        img_engg=(ImageView)vi.findViewById(R.id.img_eng);
        img_landc=(ImageView)vi.findViewById(R.id.img_landc);
        img_spinning=(ImageView)vi.findViewById(R.id.img_spinning);
        img_chemistry=(ImageView)vi.findViewById(R.id.img_chemistry);
        img_cpq=(ImageView)vi.findViewById(R.id.img_cpq);

        img_cpq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Employment.class);
                intent.putExtra("link","http://rmcysp.sitraonline.org/cpqreport/login.php");
                startActivity(intent);
            }
        });


        img_engg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Conversions.class);
                intent.putExtra("id",id);
                intent.putExtra("value","1");
                startActivity(intent);
            }
        });
        img_landc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Conversions.class);
                intent.putExtra("id",id);
                intent.putExtra("value","2");
                startActivity(intent);
            }
        });
        img_spinning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Conversions.class);
                intent.putExtra("id",id);
                intent.putExtra("value","3");
                startActivity(intent);
            }
        });
        img_chemistry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Conversions.class);
                intent.putExtra("id",id);
                intent.putExtra("value","4");
                startActivity(intent);
            }
        });








        alertDialog.setView(vi);
        alertDialog.show();
        alertDialog.setCancelable(true);


    }

    public void showemp(){
        Activity activity = null;
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        Button close;

        final AlertDialog alertDialog = dialogBuilder.create();
        LayoutInflater factory = LayoutInflater.from(this);
        final View vi = factory.inflate(R.layout.alert_employment, null);
        ImageView job_reg,jobatsitra,mill_reg;
        job_reg=(ImageView)vi.findViewById(R.id.job_reg);
        jobatsitra=(ImageView)vi.findViewById(R.id.jobatsitra);


        job_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,Employment.class);
                intent.putExtra("link","http://cliqinnovations.com/projects/sitra/employment/");
                startActivity(intent);
            }
        });

        jobatsitra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Coming Soon...", Toast.LENGTH_SHORT).show();
            }
        });






        alertDialog.setView(vi);
        alertDialog.show();
        alertDialog.setCancelable(true);


    }
    public void showplsc(){
        Activity activity = null;
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        Button close;

        final AlertDialog alertDialog = dialogBuilder.create();
        LayoutInflater factory = LayoutInflater.from(this);
        final View vi = factory.inflate(R.layout.alert_plsc, null);
        ImageView img_plsc_consultancy,img_plsc_seminar,img_plsc_training,img_plsc_testing,img_plsc_contacts;
        img_plsc_consultancy=(ImageView)vi.findViewById(R.id.img_plsc_consultancy);
        img_plsc_seminar=(ImageView)vi.findViewById(R.id.img_plsc_seminar);
        img_plsc_training=(ImageView)vi.findViewById(R.id.img_plsc_training);
        img_plsc_testing=(ImageView)vi.findViewById(R.id.img_plsc_testing);
        img_plsc_contacts=(ImageView)vi.findViewById(R.id.img_plsc_contacts);
        img_plsc_consultancy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,Plsc_consultancy.class);
                intent.putExtra("message","CONSULTANCY"+"\n"+"\n"+"       \u2022\tProduct diversification.\n" +
                        "       \u2022\tTechnology upgradation and modernisation of looms.\n" +
                        "       \u2022\tImproving quality and productivity.\n" +
                        "       \u2022\tMinimising waste.\n" +
                        "       \u2022\tMaintenance of machinery to prevent break downs.\n" +
                        "       \u2022\tAttaching mechanisms like drill, satin, dobby, jacquard, dropbox, terry etc., to produce variety of fabrics.\n" +
                        "       \u2022\tGuidance for exporters.");
                startActivity(intent);
            }
        });
        img_plsc_seminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,Plsc_consultancy.class);
                intent.putExtra("message","SEMINAR"+"\n"+"\n"+"     Seminars and workshops are organised periodically on the following topics:\n" +
                        "\n" +
                        "       \u2022\tEntrepreneur development programme\n" +
                        "       \u2022\tQuality control\n" +
                        "       \u2022\tTUF scheme\n" +
                        "       \u2022\tExport procedures\n" +
                        "       \u2022\tProcess control in sizing\n" +
                        "       \u2022\tWTO and its implications\n" +
                        "       \u2022\tEco friendly textiles\n" +
                        "       \u2022\tTechnical textiles");
                startActivity(intent);
            }
        });
        img_plsc_training.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,Plsc_consultancy.class);
                intent.putExtra("message","TRAINING"+"\n"+"\n"+"        The following training programs are conducted for upgrading the skills of powerloom owners, weavers and jobbers:\n" +
                        "\n" +
                        "       \u2022\tPowerloom mechanism\n" +
                        "       \u2022\tDropbox mechanism\n" +
                        "       \u2022\tDobby mechanism\n" +
                        "       \u2022\tWeaving calculations\n" +
                        "       \u2022\tFabric designs\n" +
                        "       \u2022\tEco friendly dyeing of reactive colours\n" +
                        "       \u2022\tDyeing of vat colours");
                startActivity(intent);
            }
        });
        img_plsc_testing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,plsc_testing.class);
                startActivity(intent);
            }
        });
        img_plsc_contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,plsc_contact.class);
                startActivity(intent);
            }
        });








        alertDialog.setView(vi);
        alertDialog.show();
        alertDialog.setCancelable(true);


    }
    public void showtesting(){
        Activity activity = null;
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        Button close;

        final AlertDialog alertDialog = dialogBuilder.create();
        LayoutInflater factory = LayoutInflater.from(this);
        final View vi = factory.inflate(R.layout.alert_testing, null);
        ImageView acc,cal,phy,che,wev;
        acc=(ImageView)vi.findViewById(R.id.acc);
        cal=(ImageView)vi.findViewById(R.id.con);
        phy=(ImageView)vi.findViewById(R.id.phy);
        che=(ImageView)vi.findViewById(R.id.che);
        wev=(ImageView)vi.findViewById(R.id.wev);
        acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,webview.class);
                intent.putExtra("name","testing_accessories.html");
                startActivity(intent);
            }
        });
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,TestingChemistry.class);
                intent.putExtra("name","testing_chemistry.html");
                startActivity(intent);
            }
        });
        phy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pdf="http://cliqinnovations.com/projects/sitra/wp-content/uploads/2019/02/physical-Testing-Std.pdf";
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(pdf));
                startActivity(browserIntent);

            }
        });
        che.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,TestingChemistry.class);

                startActivity(intent);
            }
        });
        wev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent=new Intent(MainActivity.this,Testint_Weaving.class);
            startActivity(intent);
            }
        });







        alertDialog.setView(vi);
        alertDialog.show();
        alertDialog.setCancelable(true);


    }



    public void showtraining(){
        Activity activity = null;
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        Button close;

        final AlertDialog alertDialog = dialogBuilder.create();
        LayoutInflater factory = LayoutInflater.from(this);
        final View vi = factory.inflate(R.layout.alert_training, null);








        alertDialog.setView(vi);
        alertDialog.show();
        alertDialog.setCancelable(true);


    }
    public void showpublications(){
        Activity activity = null;
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        Button close;

        final AlertDialog alertDialog = dialogBuilder.create();
        LayoutInflater factory = LayoutInflater.from(this);
        final View vi = factory.inflate(R.layout.alert_publications, null);
        ImageView new_pub,list_pub,e_tech;
        new_pub=(ImageView)vi.findViewById(R.id.new_pub);
        list_pub=(ImageView)vi.findViewById(R.id.list_pub);
        e_tech=(ImageView)vi.findViewById(R.id.e_tech);
        e_tech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,E_tech.class);
                startActivity(intent);
            }
        });
        new_pub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,NewPublication.class);
                startActivity(intent);
            }
        });
        list_pub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,ListPublications.class);
                startActivity(intent);
            }
        });








        alertDialog.setView(vi);
        alertDialog.show();
        alertDialog.setCancelable(true);


    }
    public static void deleteCache(Context context) {
        try {
            File dir = context.getCacheDir();
            deleteDir(dir);
        } catch (Exception e) { e.printStackTrace();}
    }

    public static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
            return dir.delete();
        } else if(dir!= null && dir.isFile()) {
            return dir.delete();
        } else {
            return false;
        }
    }
    public void api(){
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        StringRequest request = new StringRequest(Request.Method.POST, GET_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.i("reg", "" + response);


                try {
                    //will receive id when the register is success

                    JSONObject js=new JSONObject(response);
                    Boolean status=js.getBoolean("status");
                    Log.i("stat",""+status);
                    String err_msg=js.getString("msg");
                    id=js.getString("id");

                    if(id.equals("0")){
                        Toast.makeText(context, "Device NOt Registered Yet", Toast.LENGTH_SHORT).show();
                    }else{
                        log.setVisibility(View.VISIBLE);
                        txt_logout.setVisibility(View.VISIBLE);
                        txt_profile.setVisibility(View.VISIBLE);
                        view1.setVisibility(View.VISIBLE);
                        view2.setVisibility(View.VISIBLE);
                        profile.setVisibility(View.VISIBLE);
                        logout.setVisibility(View.VISIBLE);
                        log1.setVisibility(View.VISIBLE);
                        special_service.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                showSpecialService();
                            }


                        });

                    }

                    if(status==false){
                        Intent intent=new Intent(MainActivity.this,Reg.class);
                        startActivity(intent);
                        Toast.makeText(context, err_msg, Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(context, err_msg, Toast.LENGTH_SHORT).show();
                    }
                    //************parsing response object**********
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Somewhere went wrong", Toast.LENGTH_SHORT).show();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(MainActivity.this, "Please check connectivity", Toast.LENGTH_SHORT).show();
                Log.i("My error", "" + error);
            }
        }) {
            @Override

            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                //send your params here
                map.put("type","1");
                map.put("device_id",deviceid);

                return map;
            }
        };
        queue.add(request);

    }


}