package com.example.activity7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private static final String TAG = "CONTACT_TAG";
    private static final int WRITE_CONTACT_PERMISSION_CODE=100;
    private static final int IMAGE_PICK_GALLERY_CODE=100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main);

        binding.thumbnailTv.setOnclickListener{new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openGalleryIntent();
            }
        };
        }
    }
}