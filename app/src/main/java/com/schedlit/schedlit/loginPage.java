package com.schedlit.schedlit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class loginPage extends AppCompatActivity {

<<<<<<< HEAD

=======
    //EditText pwordEditText;
    Button logInButton;
    Button signUpButton;
    EditText emailEditText;
    EditText pwordEditText;
    String emailAddress;
    String password;
>>>>>>> refs/remotes/origin/master

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
<<<<<<< HEAD



    }

    @Override
    protected void onStart() {
        super.onStart();

=======
        emailEditText =  (EditText) findViewById(R.id.emailEditText);
        pwordEditText = (EditText) findViewById(R.id.pwordEditText);
        logInButton = (Button) findViewById(R.id.logInButton);
        signUpButton = (Button) findViewById(R.id.signUpButton);

    }

    public void onLogInClick(View view)
    {
        emailAddress = emailEditText.getText().toString();
        password = pwordEditText.getText().toString();
        boolean successfulLogIn  = true;
        if (successfulLogIn){
            startActivity(new Intent(getApplicationContext(), chooseSchool.class));

        }


    }
>>>>>>> refs/remotes/origin/master

    }
}
