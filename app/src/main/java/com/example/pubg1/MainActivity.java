package com.example.pubg1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2,ed3;
    Button btn1,btn2;
    dbhelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = (EditText) findViewById(R.id.ed1);
        ed2 = (EditText) findViewById(R.id.ed2);
        ed3 = (EditText) findViewById(R.id.ed3);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        db = new dbhelper(this);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = ed1.getText().toString();
                String email = ed2.getText().toString();
                String password = ed3.getText().toString();
             if(user.equals("")||email.equals("")||password.equals(""))
                 Toast.makeText(MainActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
              else {
                  Boolean checkemail = db.checkemail(email);
                  if(checkemail==false){
                      Boolean insert = db.insertData(user,email, password);
                      if (insert==true) {
                          Toast.makeText(MainActivity.this, "Registered successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),home.class);
                            startActivity(intent);
                      }
                        else{
                          Toast.makeText(MainActivity.this, "registration failed", Toast.LENGTH_SHORT).show();
                      }


                  }

             }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), login.class);
                startActivity(intent);
            }
        });
    }
}