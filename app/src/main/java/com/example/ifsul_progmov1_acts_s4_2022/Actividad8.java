package com.example.ifsul_progmov1_acts_s4_2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Actividad8 extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_intro_text,tv_out_country_data;
    private EditText et_ioc_code;
    private Button btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad8);

        // Learnt how to embed hyperlinks on text, at: https://learntodroid.com/how-to-create-a-hyperlink-using-android-textview/
        tv_intro_text = findViewById(R.id.a8_intro_text);
        tv_intro_text.setMovementMethod(LinkMovementMethod.getInstance());

        // For this exercise, I'll use this WebService: https://gitlab.com/amatos/rest-countries
        et_ioc_code = findViewById(R.id.a8_in_ioc_code);
        btn_submit = findViewById(R.id.a8_submit_ioc_code);
        tv_out_country_data = findViewById(R.id.a8_out_country_data);

        btn_submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.a8_submit_ioc_code){
            String url_str = "https://restcountries.com/v3.1/alpha/" + et_ioc_code.getText().toString().trim();

            Actividad8_WS_Call a8wsc = new Actividad8_WS_Call();
            a8wsc.execute(url_str);
        }
    }

    class Actividad8_WS_Call extends AsyncTask<String,Void,String>{
        @Override
        protected String doInBackground(String... strings) {
            StringBuffer sb = new StringBuffer();

            try{
                URL addr = new URL(strings[0]);
                HttpsURLConnection conn = (HttpsURLConnection) addr.openConnection();
                InputStream v_is = conn.getInputStream();
                InputStreamReader v_isr = new InputStreamReader(v_is);
                BufferedReader v_bufferedreader = new BufferedReader(v_isr);
                String lin;

                while((lin=v_bufferedreader.readLine())!=null){
                    sb.append(lin);
                }

            }
            catch(MalformedURLException e){
                e.printStackTrace();
            }
            catch(IOException e){
                e.printStackTrace();
            }
            return sb.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            try {
                JSONObject json_obj = new JSONObject(s);

                tv_out_country_data.setText("En " + json_obj.getString("nativeName.spa.official") + " viven "  + json_obj.getString("population") +  " personas.");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            super.onPostExecute(s);
        }
    }
}