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
import android.widget.TextView;

import java.util.ArrayList;

public class classPage extends AppCompatActivity {
    TextView classNameText;
    ArrayList<String> classMembersArray;
    ArrayList<String> classEventsArray;
    ArrayAdapter<String> classMembersAdapter;
    ArrayAdapter<String> classEventsAdapter;
    ListView classMembersList;
    ListView classEventsList;
    Button joinClassButton, addEventButton, goToForumButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        updateMembersList();
        updateEventsList();
        classMembersList = (ListView) findViewById(R.id.classMembersList);
        classEventsList = (ListView) findViewById(R.id.classEventsList);
        classMembersList.setAdapter(classMembersAdapter);
        classEventsList.setAdapter(classEventsAdapter);


    }

    public void updateMembersList()
    {
        classMembersArray = new ArrayList<String>();
        //Access members of the class
        classMembersAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, classMembersArray );


    }
    public void updateEventsList()
    {
        classEventsArray = new ArrayList<String>();
        //Access class events
        classEventsAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, classEventsArray );


    }

    public void onJoinClassClick(View view){
        //Add class to user's classes

    }
    public void onAddEventClick(View view)
    {
        //Open a create event page
    }
    public void onGoToForumClick(View view){
        //Open the discussion forum page

    }

}
