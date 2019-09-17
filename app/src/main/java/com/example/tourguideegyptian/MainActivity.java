package com.example.tourguideegyptian;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import lecho.lib.hellocharts.listener.PieChartOnValueSelectListener;
import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class MainActivity extends AppCompatActivity implements PieChartOnValueSelectListener {
    PieChartView pieChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pieChart = findViewById(R.id.chart);
        //Array to fill Pie Chart in Data
        List<SliceValue> pieData = new ArrayList<>();
        pieData.add(new SliceValue(20, getResources().getColor(R.color.tourist_places)).setLabel(getString(R.string.tourist_places)));//arcIndex=6
        pieData.add(new SliceValue(20, getResources().getColor(R.color.most_visited_places)).setLabel(getString(R.string.most_visited_places)));//arcIndex=1
        pieData.add(new SliceValue(20, getResources().getColor(R.color.Religious)).setLabel(getString(R.string.Religious)));//arcIndex=2
        pieData.add(new SliceValue(20, getResources().getColor(R.color.suggestions)).setLabel(getString(R.string.suggestions)));//arcIndex=3
        pieData.add(new SliceValue(20, getResources().getColor(R.color.near_you)).setLabel(getString(R.string.near_you)));//arcIndex=4
        pieData.add(new SliceValue(20, getResources().getColor(R.color.medical_tourism)).setLabel(getString(R.string.medical_tourism)));//arcIndex=5
        PieChartData pieChartData = new PieChartData(pieData);
        // To Control labels Pie Chart
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);
        pieChartData.setHasLabels(true).setValueLabelBackgroundEnabled(false);
        pieChartData.setHasLabels(true).setValueLabelsTextColor(getResources().getColor(R.color.labels));
        pieChartData.setHasCenterCircle(true).setCenterText1(" ");
        pieChart.setPieChartData(pieChartData);
        pieChart.setClickable(true);
        pieChart.setOnValueTouchListener(this);
    }

    // To move another activity by pie chart
    @Override
    public void onValueSelected(int arcIndex, SliceValue value) {
        if(arcIndex==1){
            Intent intent = new Intent(MainActivity.this,MostVisitedPlacesActivity.class);
            startActivity(intent);
        }
        else if (arcIndex==2){
            Intent intent = new Intent(MainActivity.this,ReligiousTourismActivity.class);
            startActivity(intent);
        }
        else if (arcIndex==3){
            Intent intent = new Intent(MainActivity.this,SuggestionsActivity.class);
            startActivity(intent);
        }
        else if (arcIndex==4){
            Intent intent = new Intent(MainActivity.this,NearYouActivity.class);
            startActivity(intent);
        }
        else if (arcIndex==5){
            Intent intent = new Intent(MainActivity.this,MedicalTourismActivity.class);
            startActivity(intent);
        }
        else
        {
            Intent intent = new Intent(MainActivity.this,TouristPlacesActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onValueDeselected() {

    }

    //For sure exit or no
    @Override
    public void onBackPressed() {
       ExitFragment fragment=new ExitFragment();
        fragment.setCancelable(false);
        fragment.show(getSupportFragmentManager(),"");
    }
}
