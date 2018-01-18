package com.example.opilane.rockpaperscissors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MenuActivity extends AppCompatActivity {

    CheckBox CheckBox;
    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        submitBtn = findViewById(R.id.button);
        CheckBox = findViewById(R.id.checkbox1);

        submitBtn.setEnabled(false);
        CheckBox.setChecked(false);

        setContentView(R.layout.activity_menu);

    }

    public void start(View view) {

        if(submitBtn.isEnabled() == true) {
            Intent intent = new Intent(MenuActivity.this,MainActivity.class);
            startActivity(intent);
        }

    }

    public void onCheckboxClicked(View view) {

        if (CheckBox.isChecked()) {
            CheckBox.setChecked(false);
        }
        else
        {
            CheckBox.setChecked(true);
        }

        if (CheckBox.isChecked()) {
            submitBtn.setEnabled(true);
        }
        else
        {
            submitBtn.setEnabled(false);
        }
    }
}
