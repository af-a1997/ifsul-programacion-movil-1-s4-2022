package com.example.ifsul_progmov1_acts_s4_2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.lang.reflect.Array;

public class Actividad7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad7);

        // Locate the spinner, adapt the string array at strings.xml and finally put the elements in the spinner.
        Spinner courses_list = findViewById(R.id.a7_i_courses);
        ArrayAdapter<CharSequence> courses_list_adapter = ArrayAdapter.createFromResource(this, R.array.courses, android.R.layout.simple_spinner_item);
        courses_list.setAdapter(courses_list_adapter);
    }
}