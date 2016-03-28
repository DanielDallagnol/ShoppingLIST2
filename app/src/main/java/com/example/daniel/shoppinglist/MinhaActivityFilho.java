package com.example.daniel.shoppinglist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MinhaActivityFilho extends AppCompatActivity implements View.OnClickListener {

    private EditText edtValor;
    private EditText edtPreco;
    private Spinner spnOpcoes;
    private Button bntAdicionar;
    private Button bntExcluir;
    private ListView lstDados;
    Double numFinal1=0.0;
    Double numFinal2=0.0;
    Double moedaNacional;
    Double moedaInternacional;
    String textoMoedaNacional="R$";
    String textoMoedaInternacional;


    private ArrayAdapter<String> adpOpcoes;
    private ArrayAdapter<String> adpDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minha_activity_filho);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        edtValor = (EditText) findViewById(R.id.edtValor);
        edtPreco = (EditText) findViewById(R.id.edtPreco);
        spnOpcoes = (Spinner) findViewById(R.id.spnOpcoes);
        bntAdicionar = (Button) findViewById(R.id.bntAdicionar);
        bntExcluir = (Button) findViewById(R.id.bntExcluir);
        lstDados = (ListView) findViewById(R.id.lstDados);


        bntAdicionar.setOnClickListener(this);
        bntExcluir.setOnClickListener(this);


        adpOpcoes = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adpOpcoes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnOpcoes.setAdapter(adpOpcoes);

        adpOpcoes.add("");
        adpOpcoes.add("Carnes e ovos");
        adpOpcoes.add("Frutas");
        adpOpcoes.add("Produtos Lácteos");
        adpOpcoes.add("Hortaliças e legumes");
        adpOpcoes.add("Óleos e gorduras");
        adpOpcoes.add("Cereais e pães");
        adpOpcoes.add("Tuberculos");
        adpOpcoes.add("Açúcares e doces");


        adpDados = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        lstDados.setAdapter(adpDados);



        Intent intent = getIntent();
        if (intent != null){
            Bundle parans = intent.getExtras();
            if (parans !=null){
                moedaNacional = parans.getDouble("moedaNacional");
                moedaInternacional = parans.getDouble("moedaInternacional");

                textoMoedaNacional = parans.getString("textoMoedaNacional");
                textoMoedaInternacional = parans.getString("textoMoedaInternacional");

                TextView nacionaltextView = (TextView) findViewById(R.id.textMoedaNacional);
                TextView internacionaltextView = (TextView) findViewById(R.id.textMoedaInternacional);
                nacionaltextView.setText(String.valueOf("Moeda Nacional: "+moedaNacional));
                internacionaltextView.setText(String.valueOf("Moeda Internacional: 0.0"));
            }
        }


    }





    @Override
    public void onClick(View v) {
        if(v == bntAdicionar){
            if(edtValor.getText().toString().equals("")){
                Toast.makeText(this, "Campo alimento vazio", Toast.LENGTH_SHORT).show();
            }if(edtPreco.getText().toString().equals("")){
                Toast.makeText(this, "Campo preço vazio", Toast.LENGTH_SHORT).show();
            }
            if(spnOpcoes.getSelectedItem().toString().equals("")){
                Toast.makeText(this, "Selecione uma das opções", Toast.LENGTH_SHORT).show();
            }
            else{
                String item = edtValor.getText().toString();
                String item2 = edtPreco.getText().toString();
                item += textoMoedaInternacional + item2 + " - " + spnOpcoes.getSelectedItem();


                EditText view1 = (EditText)findViewById(R.id.edtPreco);

                double numero1;
                numero1 = Double.parseDouble(view1.getText().toString());

                double resposta1 = numero1 * moedaInternacional;
                double resposta2 =  numero1;

                numFinal1 += resposta1;
                numFinal2 += resposta2;

                TextView textView = (TextView) findViewById(R.id.textMoedaNacional);
                textView.setText(String.format("Moeda nacional: %.2f", numFinal1));
                TextView textView2 = (TextView) findViewById(R.id.textMoedaInternacional);
                textView2.setText(String.format("Moeda intenacional: %.2f", numFinal2));


                adpDados.add(item);
            }

            //valorNacional += Double.parseDouble(item2);
        }else   if (v == bntExcluir){
            if (adpDados.getCount() > 0){
                String item = adpDados.getItem(0);
                adpDados.remove(item);
            }

        }

    }




}
