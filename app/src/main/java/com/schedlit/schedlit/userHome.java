package com.schedlit.schedlit;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

public class userHome extends AppCompatActivity {
    ListView userEventList;
    ListView userClassList;

    ArrayList<String> myClassesArray;
    ArrayAdapter<String> myClassesAdapter;
    ArrayList<String> myEventsArray;
    ArrayAdapter<String> myEventsAdapter;

    String mEmailAddress;
    private Firebase mRef;
    private Firebase mUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

        Bundle extras = getIntent().getExtras();
        mEmailAddress = extras.getString("emailAddress");

        userEventList = (ListView) findViewById(R.id.userEventList);
        userClassList = (ListView) findViewById(R.id.userClassList);

        Firebase.setAndroidContext(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mRef = new Firebase("https://testfb342016.firebaseio.com/UsersList");

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot i : dataSnapshot.getChildren()) {
                    if (i.child("EmailAddress").getValue().equals(mEmailAddress)) {
                        myClassesArray = new ArrayList<>();
                        myClassesArray.clear();
                        for (DataSnapshot x : i.getChildren()) {
                            if (x.child("Class").getValue() != null)
                                myClassesArray.add((String) x.child("Class").getValue());
                        }
                        updateClassList();
                        break;
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        updateEventList();

        userEventList.setAdapter(myEventsAdapter);
    }

    public void updateClassList(){
        myClassesAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, myClassesArray );
        userClassList.setAdapter(myClassesAdapter);
    }
    public void updateEventList(){
        myEventsArray = new ArrayList<>();
        myEventsArray.add("test 1");
        myEventsArray.add("test 2");
        myEventsArray.add("test 3");
        myEventsArray.add("test 4");
        myEventsArray.add("test 5");
        myEventsArray.add("test 6");
        myEventsArray.add("test 7");
        myEventsArray.add("test 8");
        myEventsArray.add("test 9");


        myEventsAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, myEventsArray );

    }

    public void onSearchForClassClick(View view){
        Intent intent = new Intent(getApplicationContext(), classSearch.class);
        intent.putExtra("EmailAddress", mEmailAddress);
        startActivity(intent);

    }


}
