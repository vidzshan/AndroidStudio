package com.example.thirdproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    private EditText firstname,lastname;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        firstname = findViewById(R.id.fname);
        lastname = findViewById(R.id.lname);

        button = (Button) findViewById(R.id.Welcome);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userfirstname = firstname.getText().toString();
                String userlastname = lastname.getText().toString();

                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                intent.putExtra("keyfirstname", userfirstname);
                intent.putExtra("keylastname",userlastname);
                startActivity(intent);
            }
        });
    }
}