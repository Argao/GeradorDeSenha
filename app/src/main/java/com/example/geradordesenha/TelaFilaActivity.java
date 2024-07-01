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

import java.util.List;

public class TelaFilaActivity extends AppCompatActivity {
    TextView primeiro_na_fila;
    TextView segundo_na_fila;
    TextView terceiro_na_fila;
    TextView quarto_na_fila;
    TextView senha_atual;
    TextView nome_atual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_fila);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        primeiro_na_fila = (TextView) findViewById(R.id.fila1);
        segundo_na_fila = (TextView) findViewById(R.id.fila2);
        terceiro_na_fila = (TextView) findViewById(R.id.fila3);
        quarto_na_fila = (TextView) findViewById(R.id.fila4);
        senha_atual = (TextView) findViewById(R.id.senha_atual);
        nome_atual = (TextView) findViewById(R.id.nome_atual);

        atualizaTela();
    }

    public void atualizaTela(){

        Cliente atual = Fila.getUltimoCliente();
        if (atual != null) {
            senha_atual.setText(atual.getSenha());
            nome_atual.setText(atual.getNome());
        } else {
            senha_atual.setText("N/A");
            nome_atual.setText("N/A");
        }

        List<Cliente> proximosClientes = Fila.verProximosClientes(4);
        if(!proximosClientes.isEmpty()) primeiro_na_fila.setText(proximosClientes.get(0).getSenha());
        if(proximosClientes.size() > 1) segundo_na_fila.setText(proximosClientes.get(1).getSenha());
        if(proximosClientes.size() > 2) terceiro_na_fila.setText(proximosClientes.get(2).getSenha());
        if(proximosClientes.size() > 3) quarto_na_fila.setText(proximosClientes.get(3).getSenha());
    }

    public void voltarTelaInicial(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}