package com.example.tabuto.keepfit.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tabuto.keepfit.R;

public class FragmentBeslenme extends android.support.v4.app.Fragment {
        TextView textView ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beslenme,container,false);
        textView = (TextView) view.findViewById(R.id.textView);

        return view;
    }
}
