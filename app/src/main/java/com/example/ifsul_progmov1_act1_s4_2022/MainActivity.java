package com.example.ifsul_progmov1_act1_s4_2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText cont_form = (EditText) findViewById(R.id.extraer_texto);
        TextView cont_texto_p = (TextView) findViewById(R.id.cont_texto);
        Button enviar = (Button) findViewById(R.id.btn_confirmar);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cont_texto_p.setText(cont_form.getText());

                /*
                * ES: Implementación básica de un mensaje Toast, que es un mensaje breve que aparece abajo por unos segundos.
                * EN: Basic implementation of a Toast message, which is a brief message that appears at the bottom for a few seconds.
                *
                * Basics explained here (EN only): https://www.geeksforgeeks.org/android-what-is-toast-and-how-to-use-it-with-examples/
                * */
                Toast.makeText(getApplicationContext(),cont_texto_p.getText(),Toast.LENGTH_LONG).show();
            }
        });
    }
}