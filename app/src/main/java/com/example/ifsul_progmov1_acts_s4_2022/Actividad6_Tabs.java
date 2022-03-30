package com.example.ifsul_progmov1_acts_s4_2022;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

/*
 * Clase para pestañas, utilizada en la segunda parte del ejercicio.
 *
 * Class for tabs, used on the second part of the exercise.
 */
public class Actividad6_Tabs implements ActionBar.TabListener {
    private Fragment f;
    public Actividad6_Tabs(Fragment f){
        this.f = f;
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        // Replaces the fragment with another one when switching tabs, the ID is for the layout file of the Activity that'll host the fragment and tabs.
        ft.replace(R.id.a6p2_tabs,this.f,null);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
