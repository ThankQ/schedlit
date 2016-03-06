package com.schedlit.schedlit;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;

public class classSearch extends AppCompatActivity {
    EditText classNameEditText;
    Button addClassButton;
    String className;
    SearchView classSearchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //need to implement Search View but not sure how
        classNameEditText = (EditText) findViewById(R.id.classNameEditText);


    }

    public void onAddClassClick(View view){
        className = classNameEditText.getText().toString();
        //and the adds className to the list fo available classes
    }

}
