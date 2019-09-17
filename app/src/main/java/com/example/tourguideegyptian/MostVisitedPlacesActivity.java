package com.example.tourguideegyptian;

        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;

public class MostVisitedPlacesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_most_visited_places);
        setTitle(getString(R.string.title_MostVisitedPlaces));
    }
}
