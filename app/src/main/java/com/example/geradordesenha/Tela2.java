package com.example.geradordesenha;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Tela2 extends AppCompatActivity {

    private TextView senhaText;
    private TextView prioridadeTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        popularFilaComClientes();

        senhaText = (TextView) findViewById(R.id.show_senha);
        prioridadeTxt = (TextView) findViewById(R.id.show_prioridade);

        Intent intent = getIntent();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Cliente cliente = new Cliente(intent.getStringExtra("nome"), LocalDate.parse(intent.getStringExtra("dataString"), formato));

        Fila.adicionarNaFila(cliente);

        senhaText.setText(cliente.getSenha());

        if (cliente.isPrioridade()) {
            prioridadeTxt.setText(R.string.txt_prioridade_sim);
        } else {
            prioridadeTxt.setText(R.string.txt_prioridade_nao);
        }

    }


    public void trocarTela(View view) {
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