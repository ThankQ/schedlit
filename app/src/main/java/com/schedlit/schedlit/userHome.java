package com.schedlit.schedlit;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class userHome extends AppCompatActivity {
    ListView userEventList;
    ListView userClassList;
    Button classSearchButton;
    ArrayList<String> myClassesArray;
    ArrayAdapter<String> myClassesAdapter;
    ArrayList<String> myEventsArray;
    ArrayAdapter<String> myEventsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        userEventList = (ListView) findViewById(R.id.userEventList);
        userClassList = (ListView) findViewById(R.id.userClassList);
        updateClassList();
        updateEventList();
        userClassList.setAdapter(myClassesAdapter);
        userEventList.setAdapter(myEventsAdapter);


    }

    public void updateClassList(){
        myClassesArray = new ArrayList<String>();
        myClassesArray.add("test 1");
        myClassesArray.add("test 2");
        myClassesArray.add("test 3");
        myClassesArray.add("test 4");
        myClassesArray.add("test 5");
        myClassesArray.add("test 6");
        myClassesArray.add("test 7");
        myClassesArray.add("test 8");
        myClassesArray.add("test 9");
        myClassesArray.add("test 10");

        myClassesAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, myClassesArray );

    }
    public void updateEventList(){
        myEventsArray = new ArrayList<String>();
        myEventsArray.add("test 1");
        myEventsArray.add("test 2");
        myEventsArray.add("test 3");
        myEventsArray.add("test 4");
        myEventsArray.add("test 5");
        myEventsArray.add("test 6");
        myEventsArray.add("test 7");
        myEventsArray.add("test 8");
        myEventsArray.add("test 9");


        myEventsAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, myEventsArray );

    }


}
