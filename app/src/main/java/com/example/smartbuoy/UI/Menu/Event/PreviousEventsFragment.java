package com.example.smartbuoy.UI.Menu.Event;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.smartbuoy.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PreviousEventsFragment extends Fragment {


    public PreviousEventsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_previous_events, container, false);
    }

}