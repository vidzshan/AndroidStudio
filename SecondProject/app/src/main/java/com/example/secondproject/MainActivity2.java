package com.example.secondproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
public class MainActivity2 extends AppCompatActivity {
    private TextView firstname,lastname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        firstname = findViewById(R.id.firstname);
        lastname = findViewById(R.id.Lastname);

        String userfirstname = getIntent() .getStringExtra("keyfirstname");
        String userlastname = getIntent() .getStringExtra("keylastname");

        firstname.setText(userfirstname);
        lastname.setText(userlastname);
    }
}