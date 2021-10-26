package com.example.hangmangame;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

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

        for (int iter = 0; iter < hangmanBody.length; iter++) {
            hangmanBody[iter].setVisibility(View.INVISIBLE);
        }

        // Inflate the layout for this fragment
        return view;
    }

    /* takes button onclick to update game counters and UI */
    private void letterChecker(char fromButton) {
        // linear search to check if input letter is in the word
        boolean check = false;
        for (char c : randomWordArray) {
            if (c == fromButton) {
                check = true;
            }
        }
        List<Integer> indexList = new ArrayList<Integer>();

        if (!check) {
            // negative value means not in the word -> wrong -> set next body part visible
            hangmanBody[countWrong].setVisibility(View.VISIBLE);
            countWrong++;

            // 6 wrongs = end game -> Toast & turn off keyboard
            if (countWrong == hangmanBody.length) {
                keyboard.setVisibility(View.INVISIBLE);
                Toast.makeText(getApplicationContext(), "OH NO! You killed Hangman! Game Over. Try again :)", Toast.LENGTH_LONG).show();
            }

        } else {
            // else user got it right -> update underscore(s)

            // getting the array indexes of letter instance in word
            for (int iter = 0; iter < randomWordArray.length; iter++) {
                if (randomWordArray[iter] == fromButton) {
                    indexList.add(iter);
                }
            }

            // updating the array of underscores
            for (int iter = 0; iter < indexList.size(); iter++) {
                wordSelectedUnderscoresArr.set(indexList.get(iter), fromButton);
            }
            StringBuilder sb = new StringBuilder();
            for (Character ch : wordSelectedUnderscoresArr) {
                sb.append(ch);
            }
            wordSelected.setText(sb.toString());

            // whole word completed
            boolean contains = false;
            for (char c : wordSelectedUnderscoresArr) {
                if (c == '_') {
                    contains = true;
                    break;
                }
            }
            System.out.println(contains);
            if (contains == false) {
                keyboard.setVisibility(View.INVISIBLE);
                Toast.makeText(getApplicationContext(), "CONGRATS! You won! Play again :)", Toast.LENGTH_LONG).show();
            }
        }
    }
}