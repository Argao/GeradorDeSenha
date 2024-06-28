package com.example.geradordesenha;

import android.content.Intent;
import android.os.Bundle;

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

        Queue<Cliente> fila = new LinkedList<>();
        Cliente c1 = new Cliente("Pedro", LocalDate.of(1990, 1, 1));
        c1.gerarSenha("");
        fila.add(c1);

        System.out.println(c1.getSenha());
        Cliente c2 = new Cliente("Maria", LocalDate.of(2002, 4, 12));
        c2.gerarSenha(c1.getSenha());
        fila.add(c2);

        Cliente c3 = new Cliente("João", LocalDate.of(1940, 12, 25));
        c3.gerarSenha(c2.getSenha());
        fila.add(c3);

        Intent intent = getIntent();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Cliente cliente = new Cliente(intent.getStringExtra("nome"), LocalDate.parse(intent.getStringExtra("dataString"), formato));

        Cliente ultimoCliente = ((LinkedList<Cliente>) fila).getLast();

        cliente.gerarSenha(ultimoCliente.getSenha());

        fila.add(cliente);

        for ( Cliente cliente1 : fila) {
            System.out.println(cliente1.getSenha());
        }
    }
}