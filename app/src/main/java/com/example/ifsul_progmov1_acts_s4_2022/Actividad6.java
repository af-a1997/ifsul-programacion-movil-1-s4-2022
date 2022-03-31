package com.example.ifsul_progmov1_acts_s4_2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Actividad6 extends AppCompatActivity implements View.OnClickListener {
    private Button btn_frag1, btn_frag2, btn_frag3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad6);

        btn_frag1 = findViewById(R.id.btn_see_fragments_p1);
        btn_frag2 = findViewById(R.id.btn_see_fragments_p2);
        btn_frag3 = findViewById(R.id.btn_see_fragments_p3);

        btn_frag1.setOnClickListener(this);
        btn_frag2.setOnClickListener(this);
        btn_frag3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btn_see_fragments_p1){
            Intent i = new Intent(getApplicationContext(),Actividad6_Parte1.class);

            startActivity(i);
        }
        else if(view.getId()==R.id.btn_see_fragments_p2){
            Intent i = new Intent(getApplicationContext(),Actividad6_Parte2.class);

            startActivity(i);
        }
        else if(view.getId()==R.id.btn_see_fragments_p3){
            Intent i = new Intent(getApplicationContext(),Actividad6_Parte3.class);

            startActivity(i);
        }
    }
}