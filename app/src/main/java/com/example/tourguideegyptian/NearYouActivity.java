package com.example.tourguideegyptian;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class NearYouActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_near_you);
        setTitle(getString(R.string.title_NearYou));
    }
}
