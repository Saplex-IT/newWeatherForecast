package com.example.homework7listsnew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Button button;

    public final static String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] listData = getResources().getStringArray(R.array.citys);
        initViews();
        setupRecyclerView(listData);

    }
    private void initViews() {

        recyclerView = findViewById(R.id.recyclerView);
    }
    private void setupRecyclerView(String[] listData) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getBaseContext());
        recyclerView.setLayoutManager(layoutManager);
        RecyclerDataAdapter adapter = new RecyclerDataAdapter(listData);
        recyclerView.setAdapter(adapter);
        adapter.SetOnItemClickListener(new RecyclerDataAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, String.format("%s - %d", ((TextView)view).getText(), position), Toast.LENGTH_SHORT).show();
                showDetailsActivity(view, position);
            }
        });
    }

    public void showDetailsActivity(View view, int position) {

        Intent intent = new Intent(this, DetailsActivity.class);
        String nameCity = String.format("%s", ((TextView)view).getText());
        intent.putExtra("City", nameCity);
        startActivity(intent);
    }
}
