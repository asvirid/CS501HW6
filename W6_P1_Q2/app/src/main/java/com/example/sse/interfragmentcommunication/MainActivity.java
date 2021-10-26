package com.example.sse.interfragmentcommunication;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

//public class MainActivity extends AppCompatActivity {
    public class MainActivity extends Activity implements ControlFragment.ControlFragmentListener {
//        private String msg;
// Array of strings...
//    String[] mobileArray = {"ice cream","lollipop","apple","steak", "Burger"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

//        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, mobileArray);
//
//        ListView listView = (ListView) findViewById(R.id.listview1);
//        listView.setAdapter(adapter);
    }


//Honoring our promise to implement sendMessage from "implements ControlFragment.ControlFragmentListener" above.
    @Override
    public void sendMessage(String msg) {
        BottomFragment receivingFragment = (BottomFragment)getFragmentManager().findFragmentById(R.id.bottomFragment);
        receivingFragment.setFoodMessage(msg);
    }

}


//Toast.makeText(getBaseContext(),"I would like to propose a Toast.", Toast.LENGTH_LONG).show();
