package com.schedlit.schedlit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

public class chooseSchool extends AppCompatActivity {

    private Firebase mref;
    private int mNumSchools;
    private ListView mlvSchools;
    private ArrayList<String> mSchools;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_school);

        Firebase.setAndroidContext(this);
        mlvSchools = (ListView) findViewById(R.id.lvSchools);

    }

    public void getSchoolList()
    {
        mref = new Firebase("https://glaring-inferno-647.firebaseio.com/schools");
        mref.child("numSchools").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mNumSchools = (Integer) dataSnapshot.getValue();
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mSchools = new ArrayList<>();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, mSchools);

        mlvSchools.setAdapter(adapter);
    }
}
