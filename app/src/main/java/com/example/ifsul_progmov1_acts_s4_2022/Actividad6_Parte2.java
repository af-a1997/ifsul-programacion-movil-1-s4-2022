package com.example.ifsul_progmov1_acts_s4_2022;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;

public class Actividad6_Parte2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad6_parte2);

        Configuration c = getResources().getConfiguration();

        if(c.smallestScreenWidthDp<720) {
            ActionBar get_ab = getSupportActionBar();
            get_ab.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

            ActionBar.Tab abt1 = get_ab.newTab().setText("Fragmento 1");
            abt1.setTabListener(new Actividad6_Tabs(new Actividad6_F1()));
            ActionBar.Tab abt2 = get_ab.newTab().setText("Fragmento 2");
            abt2.setTabListener(new Actividad6_Tabs(new Actividad6_F2()));
            ActionBar.Tab abt3 = get_ab.newTab().setText("Fragmento 3");
            abt3.setTabListener(new Actividad6_Tabs(new Actividad6_F3()));

            get_ab.addTab(abt1);
            get_ab.addTab(abt2);
            get_ab.addTab(abt3);
        }
    }
}