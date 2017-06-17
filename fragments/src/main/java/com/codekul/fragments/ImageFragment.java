package com.codekul.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ImageFragment extends Fragment {

    public static final String KEY_IMG = "img";

    public static ImageFragment getInstance(int img) {
        ImageFragment fragment = new ImageFragment(); //bad
        Bundle bundle = new Bundle();
        bundle.putInt(ImageFragment.KEY_IMG,img);
        fragment.setArguments(bundle); //imp
        return fragment;
    }
    public ImageFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_image, container, false);

        final Bundle bundle = getArguments();
        if(bundle != null) {
            int img = bundle.getInt(KEY_IMG);
            ((ImageView) rootView.findViewById(R.id.imageView)).setImageResource(img);
        }
        return rootView;
    }
}
