package com.example.ifsul_progmov1_acts_s4_2022;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

// Remember to first extend FragmentActivity instead of the usual AppCompatActivity.
public class Actividad6_Parte1 extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad6_parte1);

        if(savedInstanceState == null){
            // Works like you were adding>committing>pushing files to your Git repo.

            FragmentManager fragman = getSupportFragmentManager();
            FragmentTransaction fragtrans = fragman.beginTransaction();

            Actividad6_F1 a6f1 = new Actividad6_F1();

            fragtrans.add(R.id.a6p1_fragembed,a6f1,"Fragment_1_Embed");
            fragtrans.commit();
        }
    }
}