package com.learning.sitrageneral;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
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
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class E_tech extends AppCompatActivity {
ImageView nov17,jan18,may18,sep18,jan19;
Constant constant=new Constant();

String url=constant.ip+"app_sitragen_etech_letter_lists";
ArrayList<String> img_name_list=new ArrayList<>();
    ArrayList<String> pdf_name_list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e_tech);
        nov17=(ImageView)findViewById(R.id.nov17);
        jan18=(ImageView)findViewById(R.id.jan18);
        may18=(ImageView)findViewById(R.id.may18);
        sep18=(ImageView)findViewById(R.id.sep18);
        jan19=(ImageView)findViewById(R.id.jan19);
       send();
    }
    public void send(){
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.i("My success", response);
                try {
                    JSONArray ja=new JSONArray(response);
                    for(int i=0;i<ja.length();i++){
                        JSONObject jo=ja.getJSONObject(i);
                        String pdf_name=jo.getString("pdf_name");
                        String img_name=jo.getString("img_name");
                        pdf_name_list.add(pdf_name);
                        img_name_list.add(img_name);

                    }
                    Picasso.get().load("http://lab.sitraonline.org/sitra_common_app/e-tech-letters/"+img_name_list.get(0)).into(nov17);
                    Picasso.get().load("http://lab.sitraonline.org/sitra_common_app/e-tech-letters/"+img_name_list.get(1)).into(jan18);
                    Picasso.get().load("http://lab.sitraonline.org/sitra_common_app/e-tech-letters/"+img_name_list.get(2)).into(may18);
                    Picasso.get().load("http://lab.sitraonline.org/sitra_common_app/e-tech-letters/"+img_name_list.get(3)).into(sep18);
                    Picasso.get().load("http://lab.sitraonline.org/sitra_common_app/e-tech-letters/"+img_name_list.get(4)).into(jan19);



                    nov17.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
//                Intent intent=new Intent(E_tech.this,PdfActivity.class);
//                intent.putExtra("pdfname","novs.pdf");
//                startActivity(intent);


                            String pdf="http://lab.sitraonline.org/sitra_common_app/e-tech-letters/"+pdf_name_list.get(0);
                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(pdf));
                            startActivity(browserIntent);

                        }
                    });
                    jan18.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {


                            String pdf="http://lab.sitraonline.org/sitra_common_app/e-tech-letters/"+pdf_name_list.get(1);
                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(pdf));
                            startActivity(browserIntent);


                        }
                    });
                    may18.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
//                Intent intent=new Intent(E_tech.this,PdfActivity.class);
//                intent.putExtra("pdfname","mayn.pdf");
//                startActivity(intent);

                            String pdf="http://lab.sitraonline.org/sitra_common_app/e-tech-letters/"+pdf_name_list.get(2);
                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(pdf));
                            startActivity(browserIntent);


                        }
                    });
                    sep18.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
//                Intent intent=new Intent(E_tech.this,PdfActivity.class);
//                intent.putExtra("pdfname","sepe.pdf");
//                startActivity(intent);



                            String pdf="http://lab.sitraonline.org/sitra_common_app/e-tech-letters/"+pdf_name_list.get(3);
                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(pdf));
                            startActivity(browserIntent);


                        }
                    });
                    jan19.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
//                Intent intent=new Intent(E_tech.this,PdfActivity.class);
//                intent.putExtra("pdfname","jann.pdf");
//                startActivity(intent);


                            String pdf="http://lab.sitraonline.org/sitra_common_app/e-tech-letters/"+pdf_name_list.get(4);
                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(pdf));
                            startActivity(browserIntent);


                        }
                    });

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                catch (IndexOutOfBoundsException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(E_tech.this, "No Network Connection", Toast.LENGTH_LONG).show();
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
    }


    }

