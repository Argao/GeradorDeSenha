package com.example.geradordesenha;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Tela2 extends AppCompatActivity {

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

        Queue<String> fila = new LinkedList<>();
        fila.add("A0");
        fila.add("A2");
        fila.add("B3");
        fila.add("A4");

        Intent intent = getIntent();
        Cliente cliente = new Cliente(intent.getStringExtra("nome"), LocalDate.parse(intent.getStringExtra("dataString")));
        cliente.gerarSenha(fila.peek());

        fila.add(cliente.getSenha());
    }
}