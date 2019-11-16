package com.learning.sitrageneral.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.annotation.Nullable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;

import com.learning.sitrageneral.CardActivity;
import com.learning.sitrageneral.Drawing;
import com.learning.sitrageneral.R;
import com.learning.sitrageneral.activity_two_for_one_twister;
import com.learning.sitrageneral.lap_former;
import com.learning.sitrageneral.comber;
import com.learning.sitrageneral.fly_frames;
import com.learning.sitrageneral.ring_frame;
import com.learning.sitrageneral.twist_contraction;
import com.learning.sitrageneral.work_assignment;
import com.learning.sitrageneral.autowinding;
import com.learning.sitrageneral.double_winding;

import java.util.ArrayList;
import java.util.List;


/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    Context context;
    private PageViewModel pageViewModel;
    List vers;
    RecyclerView recy1;
    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        context=getActivity();
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {


        //productivity







        if (getArguments().getInt(ARG_SECTION_NUMBER) == 1){
            ImageView carding,drawing,lap_former,comber,fly_frames,ring_frames,twist_contraction,work_assignment,auto_winding,double_winding,two_for_one_twister;

            View rootView = inflater.inflate(R.layout.fragment_main2, container, false);
            recy1=(RecyclerView)rootView.findViewById(R.id.recy1);
            recy1.setHasFixedSize(true);
            LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
            recy1.setLayoutManager(layoutManager);
            data();
            adapter();
            return rootView;
        }
        else if(getArguments().getInt(ARG_SECTION_NUMBER) == 2){
            View rootView = inflater.inflate(R.layout.fragment_tab_two, container, false);
            recy1=(RecyclerView)rootView.findViewById(R.id.recy1);
            recy1.setHasFixedSize(true);
            LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
            recy1.setLayoutManager(layoutManager);
            data1();
            adapter1();
            return rootView;
        }
        else if(getArguments().getInt(ARG_SECTION_NUMBER) == 3){
            View rootView = inflater.inflate(R.layout.fragment_tab_three, container, false);
            return rootView;
        }
        else {

            View rootView = inflater.inflate(R.layout.fragment_tab_three, container, false);
            return rootView;
        }

    }
    private void data(){
        vers=new ArrayList();
        vers.add(new Ver("CARDING","Carding is a mechanical preocess"));
        vers.add(new Ver("DRAWING","Carding is a mechanical preocess"));
        vers.add(new Ver("LAP FORMER","Carding is a mechanical preocess"));
        vers.add(new Ver("COMBER","Carding is a mechanical preocess"));
        vers.add(new Ver("FLY FRAMES","Carding is a mechanical preocess"));
        vers.add(new Ver("RING FRAMES","Carding is a mechanical preocess"));
        vers.add(new Ver("AUTO WINDING","Carding is a mechanical preocess"));
        vers.add(new Ver("DOUBLER WINDING","Carding is a mechanical preocess"));
        vers.add(new Ver("TWIST CONTRACTION","Carding is a mechanical preocess"));
        vers.add(new Ver("WORK ASSIGNMENT","Carding is a mechanical preocess"));
        vers.add(new Ver("TWO FOR ONE TWISTER","Carding is a mechanical preocess"));
    }
    private void data1(){
        vers=new ArrayList();
        vers.add(new Ver("INPUT1","Carding is a mechanical preocess"));
        vers.add(new Ver("INPUT2","Carding is a mechanical preocess"));
        vers.add(new Ver("INPUT3","Carding is a mechanical preocess"));
        vers.add(new Ver("INPUT4","Carding is a mechanical preocess"));
    }
    private void adapter(){
        RecyclerViewAdapter recyclerViewAdapter=new RecyclerViewAdapter(context,vers);
        recy1.setAdapter(recyclerViewAdapter);
    }
    private void adapter1(){
        RecyclerViewAdapter2 recyclerViewAdapter=new RecyclerViewAdapter2(context,vers);
        recy1.setAdapter(recyclerViewAdapter);
    }
}