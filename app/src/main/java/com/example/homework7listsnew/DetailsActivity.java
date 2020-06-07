package com.example.homework7listsnew;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    public TextView textViewNameCityVert;
    public TextView textViewNameCityHoriz;
    String nameCity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_details);
        Intent intent = getIntent();
        nameCity = intent.getStringExtra("City");
        initView();
        if (textViewNameCityVert != null) {
            textViewNameCityVert.setText(nameCity);
        }
        if (textViewNameCityHoriz != null) {
            textViewNameCityHoriz.setText(nameCity);
        }
    }
    private void initView(){
        textViewNameCityVert = findViewById(R.id.tvnamecity);
        textViewNameCityHoriz = findViewById(R.id.tvnamecitygoriz);
    }

}
