package com.example.ifsul_progmov1_acts_s4_2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btA2_1, btA2_2, btA4_1, btA4_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btA2_1 = (Button) findViewById(R.id.a2_1);
        btA2_2 = (Button) findViewById(R.id.a2_2);
        btA4_1 = (Button) findViewById(R.id.a4_1);
        btA4_2 = (Button) findViewById(R.id.a4_2);

        btA2_1.setOnClickListener(this);
        btA2_2.setOnClickListener(this);
        btA4_1.setOnClickListener(this);
        btA4_2.setOnClickListener(this);
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
        else if(view.getId()==R.id.a4_1){
            Intent v_intent = new Intent(this, Actividad4_1.class);

            startActivity(v_intent);
        }
        else if(view.getId()==R.id.a4_2){
            Intent v_intent = new Intent(this, Actividad4_2.class);

            startActivity(v_intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_acts,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem selected_item){
        if(selected_item.getItemId() == R.id.menu_btn_a2_1){
            Intent goto_activity = new Intent(getApplicationContext(),Actividad_2.class);
            startActivity(goto_activity);
            return true;
        }
        else if(selected_item.getItemId() == R.id.menu_btn_a2_2){
            Intent goto_activity = new Intent(getApplicationContext(),act2_2_base.class);
            startActivity(goto_activity);
            return true;
        }

        return super.onOptionsItemSelected(selected_item);
    }
}