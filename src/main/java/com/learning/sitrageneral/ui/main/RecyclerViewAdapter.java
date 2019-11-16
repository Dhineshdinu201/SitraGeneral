package com.learning.sitrageneral.ui.main;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.learning.sitrageneral.CardActivity;
import com.learning.sitrageneral.Drawing;
import com.sitra.general.R;
import com.learning.sitrageneral.activity_two_for_one_twister;
import com.learning.sitrageneral.autowinding;
import com.learning.sitrageneral.comber;
import com.learning.sitrageneral.double_winding;
import com.learning.sitrageneral.fly_frames;
import com.learning.sitrageneral.lap_former;
import com.learning.sitrageneral.ring_frame;
import com.learning.sitrageneral.twist_contraction;
import com.learning.sitrageneral.work_assignment;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    List<Ver> vers;
    Context mContext;
    public RecyclerViewAdapter(Context context, List<Ver> vers) {
        this.mContext = context;
        this.vers = vers;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.norms_menu, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.head.setText(vers.get(position).head);
        holder.content.setText(vers.get(position).content);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position==0){
                    Intent intent=new Intent(mContext, CardActivity.class);
                    mContext.startActivity(intent);
                }
                else if(position==1){
                    Intent intent=new Intent(mContext, Drawing.class);
                    mContext.startActivity(intent);
                }
                else if(position==2){
                    Intent intent=new Intent(mContext, lap_former.class);
                    mContext.startActivity(intent);
                }
                else if(position==3){
                    Intent intent=new Intent(mContext, comber.class);
                    mContext.startActivity(intent);
                }
                else if(position==4){
                    Intent intent=new Intent(mContext, fly_frames.class);
                    mContext.startActivity(intent);
                }
                else if(position==5){
                    Intent intent=new Intent(mContext, ring_frame.class);
                    mContext.startActivity(intent);
                }
                else if(position==6){
                    Intent intent=new Intent(mContext, autowinding.class);

                    mContext.startActivity(intent);
                }
                else if(position==7){
                    Intent intent=new Intent(mContext, double_winding.class);

                    mContext.startActivity(intent);
                }
                else if(position==8){
                    Intent intent=new Intent(mContext, twist_contraction.class);
                    mContext.startActivity(intent);
                }
                else if(position==9){
                    Intent intent=new Intent(mContext, work_assignment.class);
                    mContext.startActivity(intent);
                }
                else if(position==10){
                    Intent intent=new Intent(mContext, activity_two_for_one_twister.class);
                    mContext.startActivity(intent);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return vers.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView head;
        public TextView content;
        public CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            this.head = (TextView) itemView.findViewById(R.id.head);
            this.content = (TextView) itemView.findViewById(R.id.content);
            cardView = (CardView) itemView.findViewById(R.id.cardview);
        }
    }
}