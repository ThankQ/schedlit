package com.schedlit.schedlit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class chooseSchool extends AppCompatActivity {
    ArrayList<String> testListItems;
    ListView testListView;
    ArrayAdapter<String>  testListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_school);
        populateTestList();
        testListView = (ListView) findViewById(R.id.testListView);
        testListView.setAdapter(testListAdapter);

    }
    public void populateTestList(){
        testListItems = new ArrayList<String>();
        testListItems.add("test 1");
        testListItems.add("test 2");
        testListItems.add("test 3");
        testListItems.add("test 4");
        testListItems.add("test 5");
        testListAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, testListItems );

    }

    public void getSchoolList()
    {

    }
}
