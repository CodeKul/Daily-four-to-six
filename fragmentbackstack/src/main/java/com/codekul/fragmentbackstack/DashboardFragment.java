package com.codekul.fragmentbackstack;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {

    public static DashboardFragment getInstance() {
        return new DashboardFragment();
    }

    public DashboardFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        List<String> dataSet = new ArrayList<>();
        dataSet.add("Mobile");
        dataSet.add("Clothings");
        dataSet.add("TV");
        dataSet.add("AC");
        dataSet.add("Watches");
        dataSet.add("Tablets");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, dataSet);
        ((GridView)view.findViewById(R.id.items)).setAdapter(adapter);

        return view;
    }
}
