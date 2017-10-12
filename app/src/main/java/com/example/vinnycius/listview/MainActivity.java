package com.example.vinnycius.listview;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private ListView listaItens;

    //Arrays com os locais
    private String[] itens = {"Angra dos Reis", "Caldas Novas",
            "Campos do Jordão", "Costa do Sauípe", "Porto Seguro",
            "Rio de Janeiro", "Tiradentes", "Praga", "Santiago",
            "Zurique", "Caribe", "Buenos Aires", "Cancun"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listaItens = (ListView) findViewById(R.id.listViewId);

        //Adaptador para lista de itens
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                //parametros
                getApplicationContext(), // pegando o contexto da aplicação
                android.R.layout.simple_list_item_1, //Layout a ser utilizado, no adaptador
                android.R.id.text1, //id do textView, que esta dentro do simple_list_item_1 (layout)
                itens // lista de itens


        );

        listaItens.setAdapter(adaptador); // passando o adaptador para o set adapter

        //método onclick, implementado para cada item
        listaItens.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int codigoPosição = i;
                String valorClicado = (String) listaItens.getItemAtPosition(codigoPosição);

                Toast.makeText(getApplicationContext(), valorClicado, Toast.LENGTH_LONG).show();
            }
        });
    }
}
