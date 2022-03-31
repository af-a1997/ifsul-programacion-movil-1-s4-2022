package com.example.ifsul_progmov1_acts_s4_2022;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.InputMismatchException;

public class Actividad4_2 extends AppCompatActivity {
    private Button GEB_submit;
    private EditText GEF_value;
    private RadioButton GRB_cfrom, GRB_cto;
    private RadioGroup GRG_cfrom, GRG_cto;
    private TextView GTV_out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad42);
        getSupportActionBar().setTitle("Actividad 4.2");

        /*
        * ES: Considero que para la siguiente actividad, no necesito informar las cotizaciones, no obstante, si luego hay tiempo, me gustaría llamar a un WebService que obtenga las conversiones de una divisa a otra, lo que resultaría en un ejercicio más completo. Entre tanto, se hará una implementación básica usando variables con los valores estimados de cada divisa hoy en día.
        * WebServices que podrían funcionar: https://skeoop.github.io/docs/currency_service
        *
        * EN: I consider that for the following exercise, there's no need to tell the app about the exchange rates, however, I would like to call a WebService that retrieves the exchange rates, which would result in a more complete exercise. In the meantime, I'll make a basic implementation with variables that contain the approximate values for each currency nowadays.
        * WebServices that might work: https://skeoop.github.io/docs/currency_service
        *  */

        // Source of currencies: https://www.brou.com.uy/cotizaciones and https://www.xe.com (as of March 28th, 2022).
        double uyu2usd = 0.02;  // 1 UYU = 0.02 USD
        double uyu2brl = 0.11;  // 1 UYU = 0.11 BRL
        double usd2uyu = 40.3;  // 1 USD = 40.3 UYU
        double usd2brl = 0.2;   // 1 USD =  0.2 BRL
        double brl2uyu = 7.8;   // 1 BRL =  7.8 UYU
        double brl2usd = 4.79;  // 1 BRL = 4.79 USD

        // Retrieve UI elements:
        GEF_value = findViewById(R.id.field_init_money);
        GTV_out = findViewById(R.id.converted_currency);
        GEB_submit = findViewById(R.id.do_money_conversion);
        GRG_cfrom = findViewById(R.id.field_convert_from);
        GRG_cto = findViewById(R.id.field_convert_to);

        // Trigger conversion upon clicking the button.
        GEB_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int GRV_cfrom = GRG_cfrom.getCheckedRadioButtonId();
                int GRV_cto = GRG_cto.getCheckedRadioButtonId();
                GRB_cfrom = findViewById(GRV_cfrom);
                GRB_cto = findViewById(GRV_cto);

                double CONV_money_init = 0.0;
                double CONV_money_rslt = 0.0;

                try {
                    CONV_money_init = Double.parseDouble(String.valueOf(GEF_value.getText()));
                }
                catch(InputMismatchException e){
                    e.printStackTrace();

                    CONV_money_init = 1.0;
                }

                // If both [from] and [to] are the same currency.
                if((GRB_cfrom == findViewById(R.id.f_currency_from_1) && GRB_cto == findViewById(R.id.f_currency_to_1)) || (GRB_cfrom == findViewById(R.id.f_currency_from_2) && GRB_cto == findViewById(R.id.f_currency_to_2)) || (GRB_cfrom == findViewById(R.id.f_currency_from_3) && GRB_cto == findViewById(R.id.f_currency_to_3)))
                    Toast.makeText(getApplicationContext(),"Elija divisas diferentes para la conversión.",Toast.LENGTH_LONG).show();

                // UYU -> USD
                else if(GRB_cfrom == findViewById(R.id.f_currency_from_1) && GRB_cto == findViewById(R.id.f_currency_to_2)){
                    CONV_money_rslt = CONV_money_init * uyu2usd;
                    GTV_out.setText(String.format(CONV_money_init + " UYU son %.2f USD.",CONV_money_rslt));
                }
                // UYU -> BRL
                else if(GRB_cfrom == findViewById(R.id.f_currency_from_1) && GRB_cto == findViewById(R.id.f_currency_to_3)){
                    CONV_money_rslt = CONV_money_init * uyu2brl;
                    GTV_out.setText(String.format(CONV_money_init + " UYU son %.2f BRL.",CONV_money_rslt));
                }
                // USD -> UYU
                else if(GRB_cfrom == findViewById(R.id.f_currency_from_2) && GRB_cto == findViewById(R.id.f_currency_to_1)){
                    CONV_money_rslt = CONV_money_init * usd2uyu;
                    GTV_out.setText(String.format(CONV_money_init + " USD son %.2f UYU.",CONV_money_rslt));
                }
                // USD -> BRL
                else if(GRB_cfrom == findViewById(R.id.f_currency_from_2) && GRB_cto == findViewById(R.id.f_currency_to_3)){
                    CONV_money_rslt = CONV_money_init * usd2brl;
                    GTV_out.setText(String.format(CONV_money_init + " USD son %.2f BRL.",CONV_money_rslt));
                }
                // BRL -> UYU
                else if(GRB_cfrom == findViewById(R.id.f_currency_from_3) && GRB_cto == findViewById(R.id.f_currency_to_1)){
                    CONV_money_rslt = CONV_money_init * brl2uyu;
                    GTV_out.setText(String.format(CONV_money_init + " BRL son %.2f UYU.",CONV_money_rslt));
                }
                // BRL -> USD
                else if(GRB_cfrom == findViewById(R.id.f_currency_from_3) && GRB_cto == findViewById(R.id.f_currency_to_2)){
                    CONV_money_rslt = CONV_money_init * brl2usd;
                    GTV_out.setText(String.format(CONV_money_init + " BRL son %.2f USD.",CONV_money_rslt));
                }
            }
        });
    }
}