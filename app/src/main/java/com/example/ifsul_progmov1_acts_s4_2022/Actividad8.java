package com.example.ifsul_progmov1_acts_s4_2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

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
                JSONArray json_arr = new JSONArray(s);
                JSONObject json_obj;
                List<String> json2list = new ArrayList<String>();

                //System.out.println(s);

                System.out.println("\n");
                for(int x = 0; x < json_arr.length(); x++){
                    json_obj = json_arr.getJSONObject(x);

                    if(x==0) {
                        json2list.add(json_obj.getString("name"));
                        json2list.add(json_obj.getString("capital"));
                        json2list.add(json_obj.getString("population"));
                    }
                }

                String receive_list_conts[] = new String[3];
                for(int hh = 0; hh < 3; hh++){
                    receive_list_conts[hh] = json2list.get(hh);
                }

                JSONObject country_aliases = new JSONObject(receive_list_conts[0]);
                String str_country_info = "Ese es el código para " + country_aliases.getString("official") + ", cuya capital es " + receive_list_conts[1] + ". Este país tiene un total aproximado de " + receive_list_conts[2] + " habitante(s).";

                tv_out_country_data.setText(str_country_info);

                // tv_out_country_data.setText(test);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            super.onPostExecute(s);
        }
    }
}