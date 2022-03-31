package com.example.ifsul_progmov1_acts_s4_2022;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.ShareActionProvider;
import android.widget.Toast;

public class Actividad4_1 extends AppCompatActivity {
    private ShareActionProvider set_sap;
    private String shared_text = "N/A";
    private MenuItem get_search_btn, get_share_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad41);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_act4_1,menu);

        // Retrieves and gives functionality to search button added on [menu/menu_act4_1_.xml]:
        get_search_btn = menu.findItem(R.id.btn_menu_search);
        SearchView sv = (SearchView) get_search_btn.getActionView();
        sv.setOnQueryTextListener(onSearch());

        // Retrieves and gives functionality to share button added on [menu/menu_act4_1_.xml]:
        /*
        get_share_btn = menu.findItem(R.id.btn_menu_share);
        set_sap = (ShareActionProvider) MenuItemCompat.getActionProvider(get_share_btn);
        set_sap.setShareIntent(setupSendIntent());
        */

        return true;
    }

    private Intent setupSendIntent(){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_INTENT,"Bottom text.");
        return i;
    }

    private SearchView.OnQueryTextListener onSearch(){
        return new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Toast.makeText(getApplicationContext(),"Texto " + s + " encontrado",Toast.LENGTH_SHORT).show();

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                // This is for when text is typed on search field, but I'll not code this part.

                return false;
            }
        };
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem selected_item){
        if(selected_item.getItemId() == R.id.btn_menu_search)
            return true;
        else if(selected_item.getItemId() == R.id.btn_menu_share)
            return true;

        return super.onOptionsItemSelected(selected_item);
    }
}