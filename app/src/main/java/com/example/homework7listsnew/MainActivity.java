package com.example.homework7listsnew;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends BaseActivity {

    private static final int SETTING_CODE = 88;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] listData = getResources().getStringArray(R.array.citys);
        initViews();
        setupRecyclerView(listData);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SETTING_CODE){
            recreate();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_settings:
                showSettingsActivity();
                return true;
            case R.id.info:
                showAboutActivity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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
                Toast.makeText(MainActivity.this,
                        String.format(Locale.getDefault(),"%s - %d", ((TextView)view).getText(), position), Toast.LENGTH_SHORT).show();
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
    public void showSettingsActivity() {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivityForResult(intent, SETTING_CODE);
    }
    public void showAboutActivity() {
        Intent  intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }
}
