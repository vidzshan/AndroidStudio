package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText firstNameEditText = findViewById(R.id.fname);
        EditText lastNameEditText = findViewById(R.id.Lname);
        Button displayButton = findViewById(R.id.next);
        TextView displayText = findViewById(R.id.displayText);

        displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = firstNameEditText.getText().toString();
                String lastName = lastNameEditText.getText().toString();

                String fullName = firstName + " " + lastName;

                displayText.setText(fullName);
            }
        });
    }
}
