package com.example.geradordesenha;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.time.LocalDate;

public class MainActivity extends AppCompatActivity {

    private EditText nome;
    private EditText dataString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        nome = (EditText) findViewById(R.id.input_nome);
        dataString = (EditText) findViewById(R.id.input_data);

//        popularFilaComClientes();
    }



    public void verSenhaGerada(View view) {
        Intent intent = new Intent(this, SenhaGeradaActivity.class);
        intent.putExtra("nome",  nome.getText().toString());
        intent.putExtra("dataString", dataString.getText().toString());
        startActivity(intent);
    }

    public void verFila(View view) {
        Intent intent = new Intent(this, TelaFilaActivity.class);
        startActivity(intent);
    }

    private  void popularFilaComClientes() {

        if (Fila.getUltimoCliente() == null){
            Cliente cliente1 = new Cliente("Cliente 1", LocalDate.of(1990, 1, 1));
            Cliente cliente2 = new Cliente("Cliente 2", LocalDate.of(1960, 2, 2));
            Cliente cliente3 = new Cliente("Cliente 3", LocalDate.of(2000, 3, 3));
            Cliente cliente4 = new Cliente("Cliente 4", LocalDate.of(2010, 4, 4));
            Cliente cliente5 = new Cliente("Cliente 5", LocalDate.of(1950, 5, 5));

            Fila.adicionarNaFila(cliente1);
            Fila.adicionarNaFila(cliente2);
            Fila.adicionarNaFila(cliente3);
            Fila.adicionarNaFila(cliente4);
            Fila.adicionarNaFila(cliente5);
        }

    }
}
