package com.example.hangmangame;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Gallows extends Fragment {

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_gallows, container, false);

        ImageView hangmanFrame = (ImageView) getView().findViewById(R.id.hangmanFrame);
        ImageView hangmanHead = (ImageView) getView().findViewById(R.id.hangmanHead);
        ImageView hangmanTorso = (ImageView) getView().findViewById(R.id.hangmanTorso);
        ImageView hangmanLeftArm = (ImageView) getView().findViewById(R.id.hangmanLeftArm);
        ImageView hangmanRightArm = (ImageView) getView().findViewById(R.id.hangmanRightArm);
        ImageView hangmanLeftLeg = (ImageView) getView().findViewById(R.id.hangmanLeftLeg);
        ImageView hangmanRightLeg = (ImageView) getView().findViewById(R.id.hangmanRightLeg);



        // Inflate the layout for this fragment
        return view;
    }
}