package com.example.pubg1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText ed2l,ed3l;
    Button btn2l;
    dbhelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ed2l = (EditText) findViewById(R.id.ed2l);
        ed3l = (EditText) findViewById(R.id.ed3l);
        btn2l = (Button) findViewById(R.id.btn2l);
        db = new dbhelper(this);

        btn2l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = ed2l.getText().toString();
                String password = ed3l.getText().toString();
                if(email.equals("")||password.equals(""))
                    Toast.makeText(login.this, "please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = db.checkemailpassword(email, password);
                    if(checkuserpass==true){
                        Toast.makeText(login.this, "sign in successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), home.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(login.this, "invalid details", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}