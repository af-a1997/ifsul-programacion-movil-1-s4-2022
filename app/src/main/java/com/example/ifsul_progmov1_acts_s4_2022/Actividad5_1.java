package com.example.ifsul_progmov1_acts_s4_2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Actividad5_1 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad51);

        Button btn_framelayout = (Button) findViewById(R.id.btn_see_layout_1);
        Button btn_linearlayout = (Button) findViewById(R.id.btn_see_layout_2);
        Button btn_relativelayout = (Button) findViewById(R.id.btn_see_layout_3);

        btn_framelayout.setOnClickListener(this);
        btn_linearlayout.setOnClickListener(this);
        btn_relativelayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btn_see_layout_1){
            Intent i = new Intent(getApplicationContext(),Actividad5_1_L1.class);

            startActivity(i);
        }
        else if(view.getId()==R.id.btn_see_layout_2){
            Intent i = new Intent(getApplicationContext(),Actividad5_1_L2.class);

            startActivity(i);
        }
        else if(view.getId()==R.id.btn_see_layout_3){
            Intent i = new Intent(getApplicationContext(),Actividad5_1_L3.class);

            startActivity(i);
        }
    }
}