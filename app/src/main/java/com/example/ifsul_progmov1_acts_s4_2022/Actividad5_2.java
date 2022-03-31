package com.example.ifsul_progmov1_acts_s4_2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Actividad5_2 extends AppCompatActivity {
    private TextView print_result;
    private Button calc_result;
    private EditText weight, height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad52);

        // Fuente de la fórmula / Formula source: https://www.cdc.gov/healthyweight/assessing/bmi/adult_bmi/index.html#Interpreted

        print_result = findViewById(R.id.bmi_result);
        calc_result = findViewById(R.id.btn_calc_bmi);
        weight = findViewById(R.id.in_weight);
        height = findViewById(R.id.in_height);

        calc_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double v_weight = Double.parseDouble(weight.getText().toString());
                double v_height = Integer.getInteger(height.getText().toString());
                double bmi = v_weight / (Math.pow(v_height,2));
                String cat = "";

                if(bmi < 18.5){
                    cat = "peso está por debajo de lo apropiado";
                }
                else if(bmi >= 18.5 && bmi <= 24.9){
                    cat = "tienes un peso apropiado";
                }
                else if(bmi >= 25 && bmi <= 29.9){
                    cat = "tienes sobrepeso";
                }
                else if(bmi >= 30){
                    cat = "eres obeso";
                }

                print_result.setText("Tu IMC es de " + bmi + ", y tu " + cat + ".");
            }
        });
    }
}