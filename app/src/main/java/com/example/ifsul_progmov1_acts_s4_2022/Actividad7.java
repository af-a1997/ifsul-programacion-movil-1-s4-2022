package com.example.ifsul_progmov1_acts_s4_2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

public class Actividad7 extends AppCompatActivity implements View.OnClickListener {
    private EditText i_name, i_email, i_pwd;
    private Spinner i_course;
    private Button b_save, b_list, b_wipe;
    private Actividad7_Estudiantes_DDBB a7e_db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad7);

        // Locate the spinner, adapt the string array at strings.xml and finally put the elements in the spinner.
        i_course = findViewById(R.id.a7_i_courses);
        ArrayAdapter<CharSequence> courses_list_adapter = ArrayAdapter.createFromResource(this, R.array.courses, android.R.layout.simple_spinner_item);
        i_course.setAdapter(courses_list_adapter);

        // Get the rest of the form elements.
        i_name = findViewById(R.id.a7_i_name);
        i_email = findViewById(R.id.a7_i_email);
        i_pwd = findViewById(R.id.a7_i_pwd);
        b_save = findViewById(R.id.btn_a7_save);
        b_list = findViewById(R.id.btn_a7_list);
        b_wipe = findViewById(R.id.btn_a7_wipe);

        b_save.setOnClickListener(this);
        b_list.setOnClickListener(this);
        b_wipe.setOnClickListener(this);

        a7e_db = new Actividad7_Estudiantes_DDBB(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btn_a7_save){
            Actividad7_Estudiantes a7e_i = new Actividad7_Estudiantes();

            a7e_i.setName(i_name.getText().toString().trim());
            a7e_i.setEmail(i_email.getText().toString().trim());
            a7e_i.setPwd(i_pwd.getText().toString().trim());
            a7e_i.setCourse(i_course.getSelectedItem().toString().trim());

            a7e_db.register_data(a7e_i);

            Toast.makeText(getApplicationContext(),"Estudiante registrado",Toast.LENGTH_LONG).show();

            // I was going to make the button temporarily unavailable but I couldn't exactly figure how to do that.

            // b_save.setEnabled(false);
        }
        else if(view.getId()==R.id.btn_a7_list){
            List<Actividad7_Estudiantes> students_listing_import = a7e_db.list_students();

            Intent i_reg_students = new Intent(this,Actividad7_ListaEstudiantes.class);

            i_reg_students.putExtra("SLI",(Serializable) students_listing_import);

            startActivity(i_reg_students);
        }
        else if(view.getId()==R.id.btn_a7_wipe){
            Toast.makeText(getApplicationContext(),"Función no implementada.",Toast.LENGTH_LONG).show();
        }
    }
}