package com.example.ifsul_progmov1_acts_s4_2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Actividad_2 extends AppCompatActivity implements View.OnClickListener {
    private EditText et_email;
    private EditText et_pwd;
    private Button btn_login;
    private boolean pwd_correct = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);

        et_email = (EditText) findViewById(R.id.email_addr);
        et_pwd = (EditText) findViewById(R.id.pwd);
        btn_login = (Button) findViewById(R.id.btn_login);

        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String c_email = et_email.getText().toString();
        String c_pwd = et_pwd.getText().toString();

        // Note: extremely basic implementation for testing only.
        if(c_email.equals("hello@example.com")==true && c_pwd.equals("12345678")==true)
            pwd_correct = true;
        else
            pwd_correct = false;

        if(pwd_correct==true) {
            Intent v_intent_login_success = new Intent(this, act2_login_success.class);
            Bundle login_data = new Bundle();

            login_data.putString("kEmail", et_email.getText().toString());
            login_data.putString("kPwd", et_pwd.getText().toString());
            v_intent_login_success.putExtras(login_data);

            startActivity(v_intent_login_success);
        }
        else{
            Toast.makeText(getApplicationContext(),"Usuario/Contraseña incorrectos.",Toast.LENGTH_LONG).show();
        }
    }
}