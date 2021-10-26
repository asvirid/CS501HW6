package com.example.sse.interfragmentcommunication;


import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.ArrayList;

//this will get inflated down below.

/**
 * A simple {@link Fragment} subclass.
 */
public class BottomFragment extends Fragment {

//    ArrayList<Drawable> drawables;  //keeping track of our drawables
//    private int currDrawableIndex;  //keeping track of which drawable is currently displayed.

    private ImageView img;
    private TextView foodMessage;

    public BottomFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bottom, container, false);  //separate me from return statement.

        img = (ImageView) view.findViewById(R.id.img);
        foodMessage = (TextView)view.findViewById(R.id.foodMessage);

        img.setImageDrawable(null);
        return view;

 //       return super.onCreateView(inflater, container, savedInstanceState);
    }

    // change to appropriate image and text for the chosen listview item; taken from lect5_simplelistview_2
    public void setFoodMessage(String msg){
        //
        if (msg == "Apple") {
            img.setImageResource(R.drawable.food_apple);
            foodMessage.setText("Apple");
        }
        else if (msg == "Pasta") {
            img.setImageResource(R.drawable.food_pasta);
            foodMessage.setText("Pasta");
        }
        else if (msg == "Tacos")
        {
            img.setImageResource(R.drawable.food_tacos);
            foodMessage.setText("Tacos");
        }
        else if (msg == "Lollipop")
        {
            img.setImageResource(R.drawable.food_lollipop);
            foodMessage.setText("Lollipop");
        }
        else if (msg == "Steak")
        {
            img.setImageResource(R.drawable.food_steak);
            foodMessage.setText("Steak");
        }
        foodMessage.setText(msg);
    }
}
