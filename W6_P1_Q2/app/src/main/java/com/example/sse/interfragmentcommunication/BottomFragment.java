package com.example.sse.interfragmentcommunication;


import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.ArrayList;

//this will get inflated down below.

/**
 * A simple {@link Fragment} subclass.
 */
public class BottomFragment extends Fragment {

    ArrayList<Drawable> drawables;  //keeping track of our drawables
    private int currDrawableIndex;  //keeping track of which drawable is currently displayed.

    private ImageView img;
    private Button btn;

    private TextView txtFunnyMessage;
//    private TextView txtFunnyMessage2;

    public BottomFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bottom, container, false);  //separate me from return statement.
//        txtFunnyMessage = (TextView)view.findViewById(R.id.txtFunnyMessage2);      //need a chance to do this other stuff,
//        txtFunnyMessage2 = (TextView)view.findViewById(R.id.txtFunnyMessage);    //before returning the inflated view.

        img = (ImageView) view.findViewById(R.id.img);
//        btn = (Button) view.findViewById(R.id.btnRight);


        currDrawableIndex = 0;  //ArrayList Index of Current Drawable.
        getDrawables();         //Retrieves the drawables we want, ie, prefixed with "animal_"
        img.setImageDrawable(null);  //Clearing out the default image from design time.
        changePicture();        //Sets the ImageView to the first drawable in the list.


//setting up navigation call backs.  (Left and Right Buttons)
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currDrawableIndex == 0)
                    currDrawableIndex = drawables.size() - 1;
                else
                    currDrawableIndex--;
                changePicture();
            }
        });

        return view;

 //       return super.onCreateView(inflater, container, savedInstanceState);
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//
//        View view = inflater.inflate(R.layout.fragment_bottom, container, false);  //separate me from return statement.
//        txtFunnyMessage = (TextView)view.findViewById(R.id.txtFunnyMessage);      //need a chance to do this other stuff,
//        txtFunnyMessage2 = (TextView)view.findViewById(R.id.txtFunnyMessage2);    //before returning the inflated view.
//        return view;
////        return super.onCreateView(inflater, container, savedInstanceState);
//
//    }

    //Receiving Team
    //It is best practice that this should be accessed via the main activity, not other fragments.
    public void setFunnyMessage(String msg){
        txtFunnyMessage.setText(msg);
//        txtFunnyMessage.setText(msg2);
//        txtFunnyMessage2.setText(msg);
    }

    public void changePicture() {
        img.setImageDrawable(drawables.get(currDrawableIndex));  //note, this is the preferred way of changing images, don't worry about parent viewgroup size changes.
    }

    public void getDrawables() {
        Field[] drawablesFields = com.example.sse.interfragmentcommunication.R.drawable.class.getFields();  //getting array of ALL drawables.
        drawables = new ArrayList<>();  //we prefer an ArrayList, to store the drawables we are interested in.  Why ArrayList and not an Array here? A: _________

        String fieldName;
        for (Field field : drawablesFields) {   //1. Looping over the Array of All Drawables...
            try {
                fieldName = field.getName();    //2. Identifying the Drawables Name, eg, "animal_bewildered_monkey"
                Log.i("LOG_TAG", "com.your.project.R.drawable." + fieldName);
                if (fieldName.startsWith("animals_"))  //3. Adding drawable resources that have our prefix, specifically "animal_".
                    drawables.add(getResources().getDrawable(field.getInt(null)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
