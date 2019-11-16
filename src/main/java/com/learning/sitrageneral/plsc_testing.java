package com.learning.sitrageneral;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class plsc_testing extends AppCompatActivity {
    TextView textview;
    String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plsc_testing);
        textview=(TextView)findViewById(R.id.textview);
       message="<h1>"+"<b>"+"TESTING"+"</b>"+"</h1>"+"<br>" +
               "<b>"+
               "a) Analysis of cloth"+"</b>"+"<br>" +
               "<br>" +
               "<pre>Cloth samples are analysed for design and construction and the technical know-how for bulk production is given to the Entrepreneurs. Requirement of warp and weft is also calculated. Creative designs are also developed and the assistance is given for manufacturing the same."+"<br>" +
               "<br>" +"<b>"+
               "b) Sample warping in the automatic sectional warping machine"+"</b>"+"<br>" +
               "(this facility is available at selected centres only)\n" +
               "<br>" +
               "<pre>As the high speed weaving machines require good quality warp and the small weavers cannot have a sectional warping machine due to high cost and space problems good quality sectional wrapper beams are produced on job work basis and supplied. Short lengths of samples are also produced."+"<br>" +
               "<br>" +"<b>"+
               "c) Sample weaving in the shuttleless loom."+"</b>"+"<br>" +
               "(this facility is available at selected centres only)"+"<br>" +
               "<br>" +
               "<pre>Fabric samples can be woven, on request, in shuttleless looms on job work basis.\n" +
               "<br>" +"<b>"+
               "d) Physical testing" +"</b>"+
               "<br>" +"<b>"+
               "Yarn"+"</b>"+"<br>" +
               "<ul>"+
               "<li>"+"Count"+"</li>"+"</br>" +
               "<li>"+"Lea strength and CSP"+"</li>"+"</br>" +
               "<li>"+"Single yarn strength"+"</li>"+"</br>" +
               "<li>"+"Twists per inch"+"</li>"+"</br>" +
               "<li>"+"Length of yarn (Hank/Cone)"+"</li>"+"</ul>"+"</br>" +
               "<b>"+"e) Chemical testing"+"</b>"+"<br>" +
               "<ul>"+
               "<li>"+"Fibre identification and blend analysis" +
               "<li>"+"Size pick up %" +"</li>"+"</br>" +
               "<li>"+"Water hardness analysis" +"</li>"+"</br>" +
               "<li>"+"Colour fastness to" +"</li>"+"</br>" +
               "<li>"+"Washing (40s/60s C)" +"</li>"+"</br>" +
               "<li>"+"Rubbing (wet & dry)" +"</li>"+"</br>" +
               "<li>"+"Bleaching" +"</li>"+"</br>" +
               "<li>"+"Perspiration" +"</li>"+"</br>" +
               "<li>"+"Light (at selected centres only)" +"</li>"+"</br>" +
               "<li>"+"Shrinkage to washing" +"</li>"+"</br>" +
               "<li>"+"Dye identification" +"</li>"+"</br>" +
               "<li>"+"Sample dyeing" +"</li>"+"</br>" +
               "<li>"+"pH value" +"</li>"+"</br>" +
               "<li>"+"Wettability test for wetting oil" +"</li>"+"</br>" +"</ul>"+
               "<b>"+"Fabric" +"</b>"+"<br>"+
               "<li>"+"Warp and weft count" +"</li>"+"</br>" +
               "<li>"+"Ends and picks per inch" +"</li>"+"</br>" +
               "<li>"+"Fabric thickness" +"</li>"+"</br>" +
               "<li>"+"Crease recovery" +"</li>"+"</br>" +
               "<li>"+"Tearing strength" +"</li>"+"</br>" +
               "<li>"+"Tensile strength" +"</li>"+"</br>" +
               "<li>"+"Bursting strength" +"</li>"+"</br>" +
               "<li>"+"Pilling"+"</li>"+"</br>" ;
            textview.setText(Html.fromHtml(message));

    }
}
