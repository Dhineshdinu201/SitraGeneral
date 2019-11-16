package com.learning.sitrageneral;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.bumptech.glide.load.model.UrlLoader;
import com.github.barteksc.pdfviewer.PDFView;
import java.net.URI;


public class PdfViewer extends AppCompatActivity {
   PDFView pdfView;
     String url= "http://cliqinnovations.com/projects/sitra/wp-content/uploads/2019/02/physical-Testing-Std.pdf";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_viewer);
        Log.i("URI-URL",String.valueOf(Uri.parse(url)) );
        pdfView.fromUri(Uri.parse(url));
    }
}
