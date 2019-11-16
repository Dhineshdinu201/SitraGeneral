package com.learning.sitrageneral;

import android.content.Context;
import android.view.LayoutInflater;
import com.sitra.general.R;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.master.glideimageview.GlideImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomAdapterr extends BaseAdapter {
    Context context;

    ArrayList<String> s_text;
    String[] s_head;
    LayoutInflater inflater;

    public CustomAdapterr(Context applicationContext, ArrayList<String> s_text) {
        this.context = applicationContext;
        this.s_text=s_text;

        inflater = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {

        return s_text.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View con, ViewGroup parent) {
        con = inflater.inflate(R.layout.adapter_list_item, null);
//        GlideImageView image = (GlideImageView) view.findViewById(R.id.glide_image_view);
//        image.loadImageUrl(s_text.get(position));
        ImageView imageView1=(ImageView)con.findViewById(R.id.imageview1);
        Picasso.get().load(s_text.get(position)).into(imageView1);
        return con;
    }

}
