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
import com.learning.sitrageneral.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    List<Ver> vers;
    Context mContext;
    // RecyclerView recyclerView;
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
                Toast.makeText(view.getContext(),"click on item: "+position, Toast.LENGTH_LONG).show();
                if(position==0){
                    Intent intent=new Intent(mContext, CardActivity.class);
                    mContext.startActivity(intent);
                }
                else if(position==1){
                    Intent intent=new Intent(mContext, Drawing.class);
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