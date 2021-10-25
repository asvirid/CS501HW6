package com.example.sse.interfragmentcommratingbar;


import android.app.Fragment;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;

import java.lang.reflect.Field;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class DrawableFragment extends Fragment {

    ArrayList<Drawable> drawables;  //keeping track of our drawables
    private int currDrawableIndex;  //keeping track of which drawable is currently displayed.
    private int totalImgs;

 //Boiler Plate Stuff.
    private ImageView imgRateMe;
    private RatingBar ratingBar;



    public DrawableFragment() {
//        // Required empty public constructor
    }

    public interface DrawableFragmentListener {
        public void setImgCount(int totalImgs);
    }

    DrawableFragmentListener DFL;
    public void onAttach(Context context) {
        super.onAttach(context);
        DFL = (DrawableFragment.DrawableFragmentListener) context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_drawable, container, false);  //comment this out, it would return the default view, without our setup/amendments.
        View drawableview = inflater.inflate(R.layout.fragment_drawable, container, false);   //MUST HAPPEN FIRST, otherwise components don't exist.

        imgRateMe = (ImageView) drawableview.findViewById(R.id.imgRateMe);
        ratingBar = (RatingBar) drawableview.findViewById(R.id.ratingBar);



        currDrawableIndex = 0;  //ArrayList Index of Current Drawable.
        getDrawables();         //Retrieves the drawables we want, ie, prefixed with "animal_"
        imgRateMe.setImageDrawable(null);  //Clearing out the default image from design time.
        changePicture(0);        //Sets the ImageView to the first drawable in the list.


//setting up navigation call backs.  (Left and Right Buttons)


        return drawableview;   //returns the view, with our must happen last, Why? A: ____________
    }

//Routine to change the picture in the image view dynamically.
    public void changePicture(int i) {
      imgRateMe.setImageDrawable(drawables.get(i));  //note, this is the preferred way of changing images, don't worry about parent viewgroup size changes.
      currDrawableIndex = i;
      //ratingBar.setRating(rating);
    }

//Quick and Dirty way to get drawable resources, we prefix with "animal_" to filter out just the ones we want to display.
//REF: http://stackoverflow.com/questions/31921927/how-to-get-all-drawable-resources
    public void getDrawables() {
        Field[] drawablesFields = com.example.sse.interfragmentcommratingbar.R.drawable.class.getFields();  //getting array of ALL drawables.
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
        totalImgs = drawables.size();
    }
}