package com.example.sse.interfragmentcommunication;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

//public class MainActivity extends AppCompatActivity {
    public class MainActivity extends Activity implements ControlFragmentListener {
//        private String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


//Honoring our promise to implement sendMessage from "implements ControlFragment.ControlFragmentListener" above.
    @Override
    public void sendMessage(String msg) {
//        ControlFragment sendingFragment = (ControlFragment)getFragmentManager().findFragmentById(R.id.fragment2);
//        String msg = sendingFragment.
        BottomFragment receivingFragment = (BottomFragment)getFragmentManager().findFragmentById(R.id.bottomFragment);
        receivingFragment.setFunnyMessage(msg);
    }

}


//Toast.makeText(getBaseContext(),"I would like to propose a Toast.", Toast.LENGTH_LONG).show();
