package com.example.ifsul_progmov1_acts_s4_2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Actividad5_1_L1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad51_l1);

        ListView list_element = (ListView) findViewById(R.id.elements_container);
        String[] list_contents = {"Element 0","Element 1","Element 2","Element 3","Element 4","Element 5"};
        final ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list_contents);
        list_element.setAdapter(aa);

        list_element.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String retrieve_value = aa.getItem(i);
                Toast.makeText(getApplicationContext(),retrieve_value,Toast.LENGTH_LONG).show();
            }
        });
    }
}