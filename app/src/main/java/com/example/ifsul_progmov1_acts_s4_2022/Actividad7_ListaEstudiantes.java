package com.example.ifsul_progmov1_acts_s4_2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class Actividad7_ListaEstudiantes extends AppCompatActivity {
    private ListView sli_ui_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad7_lista_estudiantes);

        sli_ui_item = findViewById(R.id.students_list_tbl);
        List<Actividad7_Estudiantes> le = (List<Actividad7_Estudiantes>) getIntent().getSerializableExtra("SLI");

        String[] a7e_data_arr = new String[le.size()];

        for(int r = 0; r < le.size(); r++){
            a7e_data_arr[r] = (String) "Nombre: " + le.get(r).getName() + "\nCorreo: " + le.get(r).getEmail() + "\nClave: " + le.get(r).getPwd() + "\nCurso: " + le.get(r).getCourse();
        }

        final ArrayAdapter<String> aa = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,a7e_data_arr);

        sli_ui_item.setAdapter(aa);
    }
}