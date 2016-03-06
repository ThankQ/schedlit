package com.schedlit.schedlit;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

public class classSearch extends AppCompatActivity {
    EditText classNameEditText;
    String mEmailAddress;
    String className;
    SearchView classSearchView;

    private Firebase mRef;
    private String mSchool;
    private ArrayList<String> mSchoolClasses;
    private ListView mSchoolClassList;
    private DataSnapshot mSchoolData;
    private DataSnapshot mUserData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //need to implement Search View but not sure how

        Bundle extras = getIntent().getExtras();
        mEmailAddress = extras.getString("EmailAddress");

        classNameEditText = (EditText) findViewById(R.id.classNameEditText);
        mSchoolClassList = (ListView) findViewById(R.id.lvSchoolClassList);

        Firebase.setAndroidContext(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        getSchool();

        mRef = new Firebase("https://testfb342016.firebaseio.com/SchoolsList");

        mRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot i : dataSnapshot.getChildren()) {
                    if (i.child("name").getValue().equals(mSchool)) {
                        mSchoolData = i;
                        for (DataSnapshot x : i.getChildren()) {
                            if (x.getKey().equals("classes")) {
                                mSchoolClasses = new ArrayList<>();
                                for (DataSnapshot a : x.getChildren()) {
                                    if (a.child("name").getValue() != null) {
                                        mSchoolClasses.add((String) a.child("name").getValue());
                                    }
                                }
                                updateClassList();
                                break;
                            }
                        }
                        break;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    public void updateClassList(){
        ArrayAdapter myClassesAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, mSchoolClasses );
        mSchoolClassList.setAdapter(myClassesAdapter);
    }

    public void onAddClassClick(View view){
        className = classNameEditText.getText().toString();
        //and the adds className to the list fo available classes
        for(DataSnapshot i: mSchoolData.getChildren()){
            if(i.getKey().equals("classes")){
                i.getRef().push().child("name").setValue(className);
            }
        }
        mUserData.getRef().push().child("Class").setValue(className);


    }

    public void getSchool() {
        mRef = new Firebase("https://testfb342016.firebaseio.com/UsersList");

        mRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot i : dataSnapshot.getChildren()) {
                    if (i.child("EmailAddress").getValue().equals(mEmailAddress)) {
                        mUserData = i;
                        if(i.child("School").getValue() != null) {
                            mSchool = i.child("School").getValue().toString();
                        }
                        break;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

}
