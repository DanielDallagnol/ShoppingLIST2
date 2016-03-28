package com.example.daniel.shoppinglist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Double moedaNacional=0.0;
    Double moedaInternacional=0.0;
    String textoMoedaInternacional;
    String textoMoedaNacional;
    String status="";

    Spinner spinnerNacional;
    ArrayAdapter<CharSequence> adapterNacional;

    Spinner spinnerInternacional;
    ArrayAdapter<CharSequence> adapterInternacional;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       //----------------------------------------------------------------------------------------------------------------//
        spinnerNacional = (Spinner) findViewById(R.id.spinner1);
        spinnerInternacional = (Spinner) findViewById(R.id.spinner2);
        //--------------------------------------------------------------------------------------------------------------------//
        adapterNacional = ArrayAdapter.createFromResource(this, R.array.money_names, android.R.layout.simple_spinner_item);
        adapterInternacional = ArrayAdapter.createFromResource(this, R.array.money_names2, android.R.layout.simple_spinner_item);
        //--------------------------------------------------------------------------------------------------------------------//
        adapterNacional.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterInternacional.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //--------------------------------------------------------------------------------------------------------------------//
        spinnerNacional.setAdapter(adapterNacional);
        spinnerInternacional.setAdapter(adapterInternacional);
        //--------------------------------------------------------------------------------------------------------------------//

        spinnerNacional.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


        }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }

        });
        //--------------------------------------------------------------------------------------------------------------------//
        spinnerInternacional.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    moedaInternacional =3.62;
                    textoMoedaInternacional = " U$";
                }
                if (position == 1) {
                    moedaInternacional = 4.08;
                    textoMoedaInternacional = " €";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }

        });
    }



    public void enviarFormulario(View view){
        Intent intent= new Intent(getBaseContext(),MinhaActivityFilho.class);
        Bundle parans = new Bundle();
        parans.putDouble("moedaNacional", moedaNacional);
        parans.putDouble("moedaInternacional", moedaInternacional);
        parans.putString("textoMoedaNacional", textoMoedaNacional);
        parans.putString("textoMoedaInternacional", textoMoedaInternacional);


        intent.putExtras(parans);


        startActivity(intent);
    }

}