package com.example.homework7listsnew;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import java.util.regex.Pattern;

public class AboutActivity extends BaseActivity {

    TextInputEditText email;
    Button button;
    Pattern checkEmail = Pattern.compile("([A-z0-9_.-]{1,})@([A-z0-9_.-]{1,}).([A-z]{2,8})");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        initViews();
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Click FloatingActionButton", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) return;
                TextView tv = (TextView) v;
                validate(tv, checkEmail, "Error input email");
            }
        });
    }

    private void initViews() {
        email = findViewById(R.id.userMail);
        button = findViewById(R.id.button_save);
    }

    private void validate(TextView tv, Pattern check, String message){
        String value = tv.getText().toString();
        if (check.matcher(value).matches()) {
            hideError(tv);
        }
        else{
            showError(tv, message);
        }
    }

    private void showError(TextView view, String message) {
        view.setError(message);
    }

    private void hideError(TextView view) {
        view.setError(null);
    }
}