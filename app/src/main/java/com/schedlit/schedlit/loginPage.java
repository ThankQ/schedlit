package com.schedlit.schedlit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class loginPage extends AppCompatActivity {
    EditText emailEditText;
    EditText pwordEditText;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
    }
}
