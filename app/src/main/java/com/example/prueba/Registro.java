package com.example.prueba;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Registro extends AppCompatActivity {
    //VARIABLES
    String[] items = {"U.Matias Delgado","U.Tecnológica","U. Evangelica","U. Católica", "U.José Simeón Cañas"};
    AutoCompleteTextView autoCompleteTxt;
    ArrayAdapter<String>adapterItems;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);

        autoCompleteTxt=findViewById(R.id.autocomplete_txt);
        adapterItems = new ArrayAdapter<String>(this,R.layout.list_item,items);
        autoCompleteTxt.setAdapter(adapterItems);
        autoCompleteTxt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),"Haz Seleccionado "+item,Toast.LENGTH_LONG).show();
            }
        });


      //VARIABLE - BOTON PARA PASAR A LA SIGUIENTE INTERFAZ
        Button btn_Aceptar;
        btn_Aceptar=(Button)findViewById(R.id.btn_Aceptar);
        btn_Aceptar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i= new Intent(Registro.this, Main.class);
                startActivity(i);
            }
        });
    }
}