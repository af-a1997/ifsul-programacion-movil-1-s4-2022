package com.example.ifsul_progmov1_acts_s4_2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btA2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btA2 = (Button) findViewById(R.id.a2_1);

        btA2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.a2_1){
            Intent v_intent = new Intent(this, Actividad_2.class);

            startActivity(v_intent);
        }
        else if(view.getId()==R.id.a2_2){
            Intent v_intent = new Intent(this, act2_2_base.class);

            startActivity(v_intent);
        }
    }
}