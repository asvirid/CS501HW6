package com.example.sse.interfragmentcommunication;


import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */

//This will get inflated up top.
public class ControlFragment extends Fragment {

    private ListView listItems;

    public ControlFragment() {
        // Required empty public constructor
    }

//*** MESSAGE PASSING MECHANISM ***//
//Need to create an interface to ensure message passing works between fragments.
    public interface ControlFragmentListener {            //this is just an interface definition.
        public void sendMessage(String msg); //it could live in its own file.  placed here for convenience.
    }

    ControlFragmentListener CFL;  //Future reference to an object that implements ControlFragmentListener, Can be anything, as long as it implements all interface methods.
                                  //Question: Who holds the reference?  Answer: ____________

    @Override
    public void onAttach(Context context) {   //The onAttach method, binds the fragment to the owner.  Fragments are hosted by Activities, therefore, context refers to: ____________?
        super.onAttach(context);
        CFL = (ControlFragmentListener) context;  //context is a handle to the main activity, let's bind it to our interface.
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_control, container, false);  //this needs to be separated from return statement,

        listItems = (ListView) view.findViewById(R.id.listview1);

        //listview items that will show for user
        final String[] strings = {"Apple", "Pasta", "Tacos", "Lollipop", "Steak"};
        ArrayAdapter adapter= new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, strings);
        listItems.setAdapter(adapter);

        listItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = String.valueOf(adapterView.getItemAtPosition(i));
                CFL.sendMessage(item);
            }
        });

        return view;
    }

}
