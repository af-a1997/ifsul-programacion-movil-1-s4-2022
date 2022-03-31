package com.example.ifsul_progmov1_acts_s4_2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class act2_2_getval extends AppCompatActivity {
    private int rng;
    private TextView insert_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act22_getval);

        insert_value = findViewById(R.id.rng_value);

        // Math.random() * ((max - min) + min)
        rng = (int) (Math.random() * ((20 - 1) + 1));

        Intent head_back = new Intent();
        head_back.putExtra("returnGenValue",rng);
        setResult(act2_2_base.RESULT_OK,head_back);
        finish();
    }
}