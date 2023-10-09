package com.example.thirdproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView firstname,lastname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        button = (Button) findViewById(R.id.sayhi);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenMainActivity2();
            }
        });

        firstname = findViewById(R.id.firstname);
        lastname = findViewById(R.id.Lastname);

        String userfirstname = getIntent().getStringExtra("keyfirstname");
        String userlastname = getIntent().getStringExtra("keylastname");

        firstname.setText(userfirstname);
        lastname.setText(userlastname);

    }
    private void OpenMainActivity2() {
            Intent intent = new Intent(this, MainActivity2.class);
            startActivity(intent);
        }
    }