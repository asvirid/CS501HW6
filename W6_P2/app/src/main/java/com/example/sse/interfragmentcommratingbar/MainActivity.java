package com.example.sse.interfragmentcommratingbar;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity implements ButtonFragment.ButtonFragmentListener, DrawableFragment.DrawableFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void changePicture(int i) {
        DrawableFragment receivingFragment = (DrawableFragment)getFragmentManager().findFragmentById(R.id.drawablef);
        receivingFragment.changePicture(i);
    }

    @Override
    public void setImgCount(int count) {
        ButtonFragment receivingFragment = (ButtonFragment)getFragmentManager().findFragmentById(R.id.buttonf);
        receivingFragment.setImageCount(count);
    }


}
