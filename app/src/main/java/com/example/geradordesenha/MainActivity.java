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
    }



    public void verSenhaGerada(View view) {
        Intent intent = new Intent(this, Tela2.class);
        intent.putExtra("nome", nome.getText().toString());
        intent.putExtra("dataString", dataString.getText().toString());
        intent.putExtra("idade", 20);
        startActivity(intent);
    }

    public void verFila(View view) {
        Intent intent = new Intent(this, TelaFilaActivity.class);
        startActivity(intent);
    }
}
