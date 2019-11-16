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


import com.learning.sitrageneral.Input1;
import com.learning.sitrageneral.Input2;
import com.learning.sitrageneral.Input3;
import com.learning.sitrageneral.Input4;
import com.learning.sitrageneral.R;

import java.util.List;
public class RecyclerViewAdapter2 extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    List<Ver> vers;
    Context mContext;
    public RecyclerViewAdapter2(Context context, List<Ver> vers) {
        this.mContext = context;
        this.vers = vers;
    }
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.norms_menu, parent, false);
        RecyclerViewAdapter.ViewHolder viewHolder = new RecyclerViewAdapter.ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, final int position) {
        holder.head.setText(vers.get(position).head);
        holder.content.setText(vers.get(position).content);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position==0){
                    Intent intent=new Intent(mContext, Input1.class);
                    mContext.startActivity(intent);
                }
                else if(position==1){
                    Intent intent=new Intent(mContext, Input2.class);
                    mContext.startActivity(intent);
                }
                else if(position==2){
                    Intent intent=new Intent(mContext, Input3.class);
                    mContext.startActivity(intent);
                }
                else if(position==3){
                    Intent intent=new Intent(mContext, Input4.class);
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