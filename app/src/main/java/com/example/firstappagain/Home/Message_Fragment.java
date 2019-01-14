package com.example.firstappagain.Home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.firstappagain.R;


public class Message_Fragment extends Fragment {
    private static final String TAG = "Message_Fragment";

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_message, container, false);
        return view;

    }
}
