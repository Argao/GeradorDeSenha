package com.example.geradordesenha; // Define o pacote ao qual a classe pertence

import android.content.Intent; // Importa a classe Intent para iniciar novas activities
import android.os.Bundle; // Importa a classe Bundle para passar dados entre activities
import android.view.View; // Importa a classe View para interagir com componentes da UI
import android.widget.EditText; // Importa a classe EditText para utilizar campos de texto editáveis

import androidx.activity.EdgeToEdge; // Importa a classe EdgeToEdge para suporte a layout de tela cheia
import androidx.appcompat.app.AppCompatActivity; // Importa a classe base AppCompatActivity para criar uma activity
import androidx.core.graphics.Insets; // Importa a classe Insets para manipulação de margens e espaçamentos
import androidx.core.view.ViewCompat; // Importa a classe ViewCompat para compatibilidade de views entre versões do Android
import androidx.core.view.WindowInsetsCompat; // Importa a classe WindowInsetsCompat para manipulação de insets de janela

import java.time.LocalDate; // Importa a classe LocalDate para manipulação de datas

public class MainActivity extends AppCompatActivity { // Declara a classe MainActivity como uma extensão de AppCompatActivity

    private EditText nome; // Declara um campo de texto editável para o nome
    private EditText dataString; // Declara um campo de texto editável para a data

    @Override
    protected void onCreate(Bundle savedInstanceState) { // Método chamado quando a activity é criada
        super.onCreate(savedInstanceState); // Chama o método da superclasse
        EdgeToEdge.enable(this); // Habilita o layout de tela cheia
        setContentView(R.layout.activity_main); // Define o layout da activity
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> { // Define um listener para ajustes de insets
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars()); // Obtém os insets das barras do sistema
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom); // Aplica os insets como padding
            return insets; // Retorna os insets
        });
        nome = (EditText) findViewById(R.id.input_nome); // Associa o campo de texto editável do nome ao componente da UI
        dataString = (EditText) findViewById(R.id.input_data); // Associa o campo de texto editável da data ao componente da UI

//        popularFilaComClientes(); // Método comentado que populava a fila com clientes
    }

    public void verSenhaGerada(View view) { // Método chamado ao clicar no botão para ver a senha gerada
        Intent intent = new Intent(this, SenhaGeradaActivity.class); // Cria um intent para iniciar a SenhaGeradaActivity
        intent.putExtra("nome",  nome.getText().toString()); // Adiciona o nome ao intent
        intent.putExtra("dataString", dataString.getText().toString()); // Adiciona a data ao intent
        startActivity(intent); // Inicia a activity
    }

    public void verFila(View view) { // Método chamado ao clicar no botão para ver a fila
        Intent intent = new Intent(this, TelaFilaActivity.class); // Cria um intent para iniciar a TelaFilaActivity
        startActivity(intent); // Inicia a activity
    }

    private  void popularFilaComClientes() { // Método privado para popular a fila com clientes

        if (Fila.getUltimoCliente() == null){ // Verifica se a fila está vazia
            Cliente cliente1 = new Cliente("Cliente 1", LocalDate.of(1990, 1, 1)); // Cria um cliente
            Cliente cliente2 = new Cliente("Cliente 2", LocalDate.of(1960, 2, 2)); // Cria outro cliente
            Cliente cliente3 = new Cliente("Cliente 3", LocalDate.of(2000, 3, 3)); // Cria outro cliente
            Cliente cliente4 = new Cliente("Cliente 4", LocalDate.of(2010, 4, 4)); // Cria outro cliente
            Cliente cliente5 = new Cliente("Cliente 5", LocalDate.of(1950, 5, 5)); // Cria outro cliente

            Fila.adicionarNaFila(cliente1); // Adiciona o cliente à fila
            Fila.adicionarNaFila(cliente2); // Adiciona outro cliente à fila
            Fila.adicionarNaFila(cliente3); // Adiciona outro cliente à filapackage com.example.geradordesenha;

        }
    }
}
