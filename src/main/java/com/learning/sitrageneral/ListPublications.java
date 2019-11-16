package com.learning.sitrageneral;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import github.hotstu.zebratextview.ZebraTextView;
import com.sitra.general.R;

public class ListPublications extends AppCompatActivity {
    ListView listView;
    ArrayList<String>sno_list=new ArrayList<>();
    ArrayList<String>bookname_list=new ArrayList<>();
    ArrayList<String>mem_list=new ArrayList<>();
    ArrayList<String>nonmem_list=new ArrayList<>();
    EditText et_search;
    Button search;
    String search_text="";
    Constant constant=new Constant();
    String url=constant.ip+"app_sitragen_listof_publicatons";
    String[] sno={"B1","B12","B14","1","4","5","6","7","8","9","10","11","12","13","14","19","20","21","22","24","26","28","29","31","38","41","42","44","47","48","49","51","53","54","55","57","60","61","62","64","68","70","71","72","73","74","75","76","77","78","79","81","84","85","86","87","89","93","94","102","103","108","109","113","114","115","116","117","118","119"};
    String[] bookname={"50 Years of Growth of SITRA",
            "Practical Guide to Reactive Power Management in Industry",
            "Fundamentals of Electricity Management in Industry (Tamil)",
            "Achievable Levels of Yarn Elongation and Hairiness based on Fibre  Properties &Process Variables",
            "A Study on the Influence of Fibre & Yarn Parameters on Lint Shedding Propensity",
            "A Study on the Properties and Processing Performance of Bt-Cottons",
            "A Study on the Quality of Yarns Made of Man-Made Fibers and its Blends",
            "A Study to Assess the Financial and Operational Strengths and Weakness of Spinning Mills for Rehabilitation of Potentially Viable Spinning Mills",
            "A Study on Two-for-one Twisting",
            "A New Methodology to Arrive at Combing Efficiency Using Single Fibre Length Data",
            "A Study on Packing Materials Cost in Spinning Mills",
            "Achievable Efficiency in Conventional Cone Winding with EYC and Splicers – Ready Reckoner Tables",
            "Achievable Production in Doubler Winding Machines",
            "An Energy Efficient Control System for Water Cooling Towers in Textile Industry – \"SITRA ENERCOOL\"",
            "An Energy Efficient Control System for Humidification Plants - \"SITRA Climoc Control\"",
            "Deviation Rate in Yarn Mass and its Effect on Fabric Appearance",
            "Development of Fire Resistant Yarns & Fabrics by Air-Jet Spinning",
            "Development of a Technology Package for Speciality Polyester Fibres",
            "Development of ASTM Yarn Appearance Standards on EIB for Fine Yarns ",
            "Dynamic Tensile Properties of Yarn and Prediction of Yarn Behavior During Mechanical Processing",
            "Energy Conservation in Overhead Travelling Cleaners Used in Textile Mills-\"SITRA PCRA OHTC ENEROPTIMISERS\"",
            "Energy Efficient Drive Control System for Automatic Cone Winding M/c SITRA ENERCONER",
            "Evaluation of Knitting Behavior Using Artificial Neural Network",
            "Improvement of Light Fastness of Reactive Dyed Cotton Textiles",
            "Measures for Sustaining Profitability of Spinning Mills",
            "Online Monitoring of Yarn Contamination on Weft Knitting and Winding M/c",
            "Operatives Employment Pattern in Spinning Mills",
            "Production Pattern and Product Diversification in Spinning Mills",
            "Qualitative and Quantitative Requirements of Cotton in 2004-5",
            "Quantitative and Qualitative Requirements of Cotton in 2010",
            "Ready Reckoner to Convert Oven Dry Mass to Conditioned Dry Mass of Blended Materials ",
            "SITRA Flexi Mark - A Computerized System For Marker Making in Garment Industry",
            "SITRA Motorised Yarn Appearance Winder",
            "SITRA mini SPIN-Miniature Spinning Frame For Test Runs",
            "Studies on Spinning Behavior, Anti-Fungal and Thermal Properties of Bamboo Fibres ",
            "Weak Spots in Cotton Yarns and Factors Influencing the Same",
            "WTO and its Impact on Indian Textile & Clothing Industry",
            "Yarn Production Pattern, Changes and Trends During 1993-2001",
            "Yarn Quality Improvement with \"SITRA CON-HAIR\" in Manual cone winder",
            "Azoic Dyes - Studies as per German Ban",
            "Processing of Silk Cotton blends in short staple ring spinning system-some studies",
            "A Study on the Cost & Quality of Fabrics Imported by the Garment Industry Vis-a-Vis that of Fabrics Sourced from within the Country ",
            "Highlights of Emerging Technologies at ITMA - 2007, Germany",
            "Design and Development of An Instrument to Evaluate Staple Fibre Processing Propensity ",
            "A Physicochemical Method for the Estimation of Flax content in Flax/cotton Blend",
            "Evaluation of Comfort Properties & Dyeing Characteristics of Fabrics made out of Compact Yarns",
            "Technical Textiles - SITRAs Contributions",
            "Optimum Twist in Roving Based on Fibre Properties & Roving Hank",
            "Optimisation of Roller Settings in Sliver lap, Ribbon lap and Comber Draw box\t",
            "Modernisation of Machines in Spinning Mills",
            "Interaction of the Properties of Individual Cotton Fibres in a Blend",
            "Achievable Machine Efficiency in Automatic Cone Winders –Ready Reckoner",
            "Studies on Gassing and Mercerizing of Combed Cotton Yarns\t",
            "Impact of Power Cut on the Performance of Spinning Mills",
            "Achievable levels of Tenacity and Evenness in Compact Spun Yarns",
            "Energy conservation in compressed air system of textile mills",
            "An Inter-Mill Study on Packing Materials Cost in Spinning Mills",
            "A study on the economics of stationary auto doffers in ring frames",
            "Energy efficient control system for air compressors-\"SITRA PCRA ENERCOMP\"High performance polymer narrow width fabrics as load bearing member in opto-electronics" +
                    "                - sensor system",
            "High performance polymer narrow width fabrics as load bearing member in opto-electronics sensor system",
            "Quantitative and qualitative requirements of cotton in the 12th five year plan period ",
            "How can a participant mill make use of the CPQ Study data to improve its performance? A case study",
            "A Study on Factors Responsible for the Generation of Hard Waste in the Auto Winders",
            "An Insight of ITMA 2015 held at Milan, ITALY   ",
            "33rd Productivity Survey in Spinning Mills 2016",
            "Influence of Combing of Polyester/ Cotton Blended Material on Yarn Quality Compared to the Traditional Process",
            " How to estimate sort-wise yarn to grey woven fabric conversion cost correctly? – SITRA Method",
            "An Inter-Mill Study on Fibre to Yarn Conversion Cost – 7th study",
            "A Study of effect of suction pressure in compact spinning on yarn hairiness and its impact on air consumption in air jet looms",
            "A Novel approach towards improving yarn quality in the manufacture of polyester / viscose blended yarns"

    };
    String[] memrate={"300",
            "250",
            "350",
            "45",
            "10",
            "45",
            "20",
            "15",
            "20",
            "30",
            "45",
            "75",
            "25",
            "20",
            "45",
            "40",
            "10",
            "20",
            "10",
            "10",
            "30",
            "25",
            "40",
            "45",
            "25",
            "15",
            "45",
            "45",
            "10",
            "20",
            "10",
            "25",
            "10",
            "20",
            "30",
            "40",
            "50",
            "20",
            "10",
            "10",
            "60",
            "70",
            "70",
            "50",
            "40",
            "40",
            "50",
            "60",
            "60",
            "130",
            "50",
            "150",
            "60",
            "180",
            "60",
            "60",
            "90",
            "50",
            "40",
            "50",
            "60",
            "50",
            "70",
            "110",
            "600",
            "75",
            "80",
            "110",
            "150",
            "150"


    };
    String[] nonmemrate={"300",
            "300",
            "450",
            "50",
            "15",
            "50",
            "25",
            "20",
            "30",
            "45",
            "70",
            "100",
            "30",
            "25",
            "60",
            "45",
            "15",
            "25",
            "15",
            "15",
            "45",
            "30",
            "50",
            "50",
            "35",
            "25",
            "60",
            "60",
            "15",
            "30",
            "10",
            "30",
            "15",
            "25",
            "40",
            "40",
            "70",
            "25",
            "15",
            "15",
            "80",
            "90",
            "90",
            "70",
            "60",
            "60",
            "80",
            "90",
            "90",
            "180",
            "60",
            "200",
            "80",
            "250",
            "80",
            "80",
            "120",
            "70",
            "60",
            "80",
            "90",
            "75",
            "100",
            "150",
            "800",
            "125",
            "100",
            "150",
            "180",
            "180"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_publications);
        et_search=(EditText)findViewById(R.id.et_search);
        search=(Button)findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sno_list.clear();
                bookname_list.clear();
                mem_list.clear();
                nonmem_list.clear();
                search_text=et_search.getText().toString();
                send();

            }
        });
        send();

        listView=(ListView)findViewById(R.id.listview);

    }
    public void send(){
        RequestQueue queue = Volley.newRequestQueue(ListPublications.this);
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.i("My success", "" + response);
                try {
                    JSONArray ja=new JSONArray(response);
                    for(int i=0;i<ja.length();i++) {
                        JSONObject object = ja.getJSONObject(i);
                        String id=object.getString("id");
                        String sno=object.getString("sno");
                        String publication_name=object.getString("publication_name");
                        String member_rate=object.getString("member_rate");
                        String non_member_rate=object.getString("non_member_rate");
                        Log.i("sno",sno);
                        sno_list.add(sno);
                        bookname_list.add(publication_name);
                        mem_list.add(member_rate);
                        nonmem_list.add(non_member_rate);


                        CustomAdapter customAdapter=new CustomAdapter(ListPublications.this,sno_list,bookname_list,mem_list,nonmem_list);
                        listView.setAdapter(customAdapter);
                    }

                } catch (JSONException e) {
                    Toast.makeText(ListPublications.this, "Credentials Error", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ListPublications.this, "Please Check Connectivity :" + error, Toast.LENGTH_LONG).show();
                Log.i("My error", "" + error);
            }
        }) {
            @Override

            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();

                map.put("publication_name",search_text);
                return map;
            }
        };
        queue.add(request);
    }
    }

class CustomAdapter extends ArrayAdapter<String>{
    private final Context context;
    private final ArrayList<String> sno;
    private final ArrayList<String> booknamee;
    private final ArrayList<String> mem__rate;
    private final ArrayList<String> nonmem__rate;


    public CustomAdapter( Context context, ArrayList<String> sno,ArrayList<String> booknamee,ArrayList<String> memrate,ArrayList<String> nonmem_rate) {
        super(context, R.layout.listpub,sno);
        this.context=context;
        this.sno=sno;
        this.booknamee=booknamee;
        this.mem__rate=memrate;
        this.nonmem__rate=nonmem_rate;
        Log.i("nonmem_rate",nonmem_rate.toString());

    }
    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater=(LayoutInflater)getContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View rowView=inflater.inflate(R.layout.listpub,null,true);
        TextView slno=(TextView)rowView.findViewById(R.id.sl);
        TextView bookname=(TextView)rowView.findViewById(R.id.name);
        TextView memrate=(TextView)rowView.findViewById(R.id.memrate);
        TextView nonmemrate=(TextView)rowView.findViewById(R.id.nonmem_rate);
        Log.i("sno_re",""+position);
        slno.setText(sno.get(position));
        Log.i("sno_re",sno.get(position));

        bookname.setText(booknamee.get(position));
        memrate.setText(mem__rate.get(position));
        nonmemrate.setText(nonmem__rate.get(position));
        return rowView;
    }
}