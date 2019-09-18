package com.learning.sitrageneral.ui.main;

import android.content.Intent;
import android.os.Bundle;
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


/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

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
//            carding=(ImageView)rootView.findViewById(R.id.carding);
//            drawing=(ImageView)rootView.findViewById(R.id.drawing);
//            lap_former=(ImageView)rootView.findViewById(R.id.lap_former);
//            comber=(ImageView)rootView.findViewById(R.id.comber);
//            fly_frames=(ImageView)rootView.findViewById(R.id.fly_frames);
//            ring_frames=(ImageView)rootView.findViewById(R.id.ring_frames);
//            twist_contraction=(ImageView)rootView.findViewById(R.id.twist_contraction);
//            work_assignment=(ImageView)rootView.findViewById(R.id.work_assignment);
//            auto_winding=(ImageView)rootView.findViewById(R.id.auto_winding);
//            double_winding=(ImageView)rootView.findViewById(R.id.double_winding);
//            two_for_one_twister=(ImageView)rootView.findViewById(R.id.two_for_one_twister);
//            carding.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent=new Intent(getActivity(), CardActivity.class);
//                    startActivity(intent);
//                }
//            });
//            drawing.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent=new Intent(getActivity(), Drawing.class);
//                    startActivity(intent);
//                }
//            });
//            lap_former.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent=new Intent(getActivity(), lap_former.class);
//                    startActivity(intent);
//                }
//            });
//            comber.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent=new Intent(getActivity(), comber.class);
//                    startActivity(intent);
//                }
//            });
//            fly_frames.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent=new Intent(getActivity(), fly_frames.class);
//                    startActivity(intent);
//                }
//            });
//            ring_frames.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent=new Intent(getActivity(), ring_frame.class);
//                    startActivity(intent);
//                }
//            });
//            twist_contraction.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent=new Intent(getActivity(), twist_contraction.class);
//                    startActivity(intent);
//                }
//            });
//            work_assignment.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent=new Intent(getActivity(), work_assignment.class);
//                    startActivity(intent);
//                }
//            });
//            auto_winding.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent=new Intent(getActivity(), autowinding.class);
//                    startActivity(intent);
//                }
//            });
//            double_winding.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent=new Intent(getActivity(), double_winding.class);
//                    startActivity(intent);
//                }
//            });
//            two_for_one_twister.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent=new Intent(getActivity(), activity_two_for_one_twister.class);
//                    startActivity(intent);
//                }
//            });

            return rootView;
        }













        else if(getArguments().getInt(ARG_SECTION_NUMBER) == 2){
            View rootView = inflater.inflate(R.layout.fragment_tab_two, container, false);
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
}