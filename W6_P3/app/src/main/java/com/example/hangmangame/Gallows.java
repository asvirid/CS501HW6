package com.example.hangmangame;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Gallows extends Fragment {

    View view;

    private ImageView hangmanFrame;
    private ImageView hangmanHead;
    private ImageView hangmanTorso;
    private ImageView hangmanLeftArm;
    private ImageView hangmanRightArm;
    private ImageView hangmanLeftLeg;
    private ImageView hangmanRightLeg;
    private ImageView[] hangmanBody;

    public Gallows() {
        // required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_gallows, container, false);

        hangmanFrame = (ImageView) getView().findViewById(R.id.hangmanFrame);
        hangmanHead = (ImageView) getView().findViewById(R.id.hangmanHead);
        hangmanTorso = (ImageView) getView().findViewById(R.id.hangmanTorso);
        hangmanLeftArm = (ImageView) getView().findViewById(R.id.hangmanLeftArm);
        hangmanRightArm = (ImageView) getView().findViewById(R.id.hangmanRightArm);
        hangmanLeftLeg = (ImageView) getView().findViewById(R.id.hangmanLeftLeg);
        hangmanRightLeg = (ImageView) getView().findViewById(R.id.hangmanRightLeg);

        hangmanBody = new ImageView[]{hangmanLeftLeg, hangmanRightLeg, hangmanLeftArm, hangmanRightArm, hangmanTorso, hangmanHead};


        // Inflate the layout for this fragment
        return view;
    }
}