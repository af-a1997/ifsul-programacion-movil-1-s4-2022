package com.example.ifsul_progmov1_acts_s4_2022;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class act2_2_base extends AppCompatActivity implements View.OnClickListener {
    private TextView returned_value = (TextView) findViewById(R.id.new_value);
    private Button btn_gen_value = (Button) findViewById(R.id.generate_value);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act22_base);
    }

    /*
    * ES: Para este ejercició se utilizó como base una solución encontrada en Stack Overflow.
    * EN: For this exercise I used a solution found in Stack Overflow as base.
    *
    * https://stackoverflow.com/questions/10407159/how-to-manage-startactivityforresult-on-android
    * */
    @Override
    public void onClick(View view) {
        Intent act_gen_result = new Intent(this,act2_2_getval.class);

        // I know it's deprecated but it's for the sake of the exercise's guidelines.
        startActivityForResult(act_gen_result,1);
    }

    protected void onActivityResult(int req_code,int rslt_code,Intent intent_data){
        super.onActivityResult(req_code,rslt_code,intent_data);
        int returned_value_n = 0;

        if(req_code == 1){
            if(rslt_code == Activity.RESULT_OK){
                returned_value_n = intent_data.getIntExtra("returnGenValue",0);
            }
        }

        returned_value.setText("Valor = " + returned_value_n);
    }
}