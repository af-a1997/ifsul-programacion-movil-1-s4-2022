package com.example.ifsul_progmov1_acts_s4_2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class act2_login_success extends AppCompatActivity {
    private TextView output_text_welcome;
    private String save_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act2_login_success);
        getSupportActionBar().setTitle("Actividad 2.1");

        if(savedInstanceState!=null){
            save_email = savedInstanceState.getString("kEmail_reg");
        }

        Bundle rcv_data = getIntent().getExtras();
        save_email = rcv_data.getString("kEmail");
        String rcv_data_pwd = rcv_data.getString("kPwd");

        output_text_welcome = findViewById(R.id.str_welcome);

        output_text_welcome.setText("Bienvenido/a, " + save_email + ".\n\nTu clave es: " + rcv_data_pwd);
    }

    protected void onSaveInstanceState(Bundle data_param) {
        super.onSaveInstanceState(data_param);
        data_param.putString("kEmail_reg",save_email);
    }
}