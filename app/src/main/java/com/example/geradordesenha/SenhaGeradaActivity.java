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

public class SenhaGeradaActivity extends AppCompatActivity {

    private TextView senhaText;
    private TextView prioridadeTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_senha_gerada);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


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






    public void voltarTela(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}