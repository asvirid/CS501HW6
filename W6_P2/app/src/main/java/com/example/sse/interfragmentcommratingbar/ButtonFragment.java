package com.example.sse.interfragmentcommratingbar;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ButtonFragment extends Fragment {
    private Button btnLeft;
    private Button btnRight;
    private int currDrawableIndex = 0;
    int totImgs = 9;




    public interface ButtonFragmentListener {            //this is just an interface definition.
        public void changePicture(int i);; //it could live in its own file.  placed here for convenience.
    }

    ButtonFragmentListener BFL;

    public void onAttach(Context context) {
        super.onAttach(context);
        BFL = (ButtonFragmentListener) context;
    }

    public void setImageCount(int imgCount) {
        totImgs = imgCount;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View buttonview = inflater.inflate(R.layout.fragment_button, container, false);
        btnRight = (Button) buttonview.findViewById(R.id.btnRight);
        btnLeft = (Button) buttonview.findViewById(R.id.btnLeft);

        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View buttonview) {
                if (currDrawableIndex == 0)
                    currDrawableIndex = totImgs - 1;
                else
                    currDrawableIndex--;
                BFL.changePicture(currDrawableIndex);
            }
        });

        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currDrawableIndex == totImgs - 1)
                    currDrawableIndex = 0;
                else
                    currDrawableIndex++;
                BFL.changePicture(currDrawableIndex);
            }
        });

        return buttonview;
    }

}


