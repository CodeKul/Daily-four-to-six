package com.codekul.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class PanelFragment extends Fragment {


    public PanelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_panel, container, false);
        view.findViewById(R.id.btnBike).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageFragment fragment = new ImageFragment(); //bad
                Bundle bundle = new Bundle();
                bundle.putInt(ImageFragment.KEY_IMG, R.drawable.ic_boy);
                fragment.setArguments(bundle); //imp
                ((MainActivity)getActivity()).loadFragment(fragment);
            }
        });

        view.findViewById(R.id.btnPlane).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //((MainActivity)getActivity()).loadFragment(new PlaneFragment());
                ((MainActivity)getActivity()).loadFragment(ImageFragment.getInstance(R.drawable.ic_rocket));
            }
        });

        view.findViewById(R.id.btnTruck).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //((MainActivity)getActivity()).loadFragment(new TruckFragment());
                ((MainActivity)getActivity()).loadFragment(ImageFragment.getInstance(R.drawable.ic_buses));
            }
        });

        return view;
    }

}
