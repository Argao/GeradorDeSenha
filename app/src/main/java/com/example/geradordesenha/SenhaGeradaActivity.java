package com.example.geradordesenha; // Define o pacote ao qual a classe pertence

import android.content.Intent; // Importa a classe Intent para manipulação de intents
import android.os.Bundle; // Importa a classe Bundle para passagem de dados entre activities
import android.view.View; // Importa a classe View para interação com a interface do usuário
import android.widget.TextView; // Importa a classe TextView para exibição de textos

import androidx.activity.EdgeToEdge; // Importa a classe EdgeToEdge para suporte a layout de tela cheia
import androidx.appcompat.app.AppCompatActivity; // Importa a classe base AppCompatActivity para criação de uma activity
import androidx.core.graphics.Insets; // Importa a classe Insets para manipulação de margens e espaçamentos
import androidx.core.view.ViewCompat; // Importa a classe ViewCompat para compatibilidade de views entre versões do Android
import androidx.core.view.WindowInsetsCompat; // Importa a classe WindowInsetsCompat para manipulação de insets de janela

import java.time.LocalDate; // Importa a classe LocalDate para manipulação de datas
import java.time.format.DateTimeFormatter; // Importa a classe DateTimeFormatter para formatação de datas

public class SenhaGeradaActivity extends AppCompatActivity { // Declara a classe SenhaGeradaActivity como uma extensão de AppCompatActivity

    private TextView senhaText; // Declara uma variável para o TextView que exibirá a senha
    private TextView prioridadeTxt; // Declara uma variável para o TextView que exibirá a prioridade

    @Override
    protected void onCreate(Bundle savedInstanceState) { // Método chamado quando a activity é criada
        super.onCreate(savedInstanceState); // Chama o método da superclasse
        EdgeToEdge.enable(this); // Habilita o layout de tela cheia
        setContentView(R.layout.activity_senha_gerada); // Define o layout da activity
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> { // Define um listener para ajustes de insets
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars()); // Obtém os insets das barras do sistema
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom); // Aplica os insets como padding
            return insets; // Retorna os insets
        });

        senhaText = (TextView) findViewById(R.id.show_senha); // Associa o TextView da senha ao componente da UI
        prioridadeTxt = (TextView) findViewById(R.id.show_prioridade); // Associa o TextView da prioridade ao componente da UI

        Intent intent = getIntent(); // Obtém o intent que iniciou esta activity
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Define o formato de data
        Cliente cliente = new Cliente(intent.getStringExtra("nome"), LocalDate.parse(intent.getStringExtra("dataString"), formato)); // Cria um novo cliente com os dados recebidos

        Fila.adicionarNaFila(cliente); // Adiciona o cliente à fila

        senhaText.setText(cliente.getSenha()); // Define o texto do TextView da senha com a senha do cliente

        if (cliente.isPrioridade()) { // Verifica se o cliente tem prioridade
            prioridadeTxt.setText(R.string.txt_prioridade_sim); // Define o texto do TextView da prioridade para "Sim"
        } else {
            prioridadeTxt.setText(R.string.txt_prioridade_nao); // Define o texto do TextView da prioridade para "Não"
        }

    }

    private  void popularFilaComClientes() { // Método privado para popular a fila com clientes

        if (Fila.getUltimoCliente() == null){ // Verifica se a fila está vazia
            // Cria cinco novos clientes com nomes e datas de nascimento diferentes
            Cliente cliente1 = new Cliente("Cliente 1", LocalDate.of(1990, 1, 1));
            Cliente cliente2 = new Cliente("Cliente 2", LocalDate.of(1960, 2, 2));
            Cliente cliente3 = new Cliente("Cliente 3", LocalDate.of(2000, 3, 3));
            Cliente cliente4 = new Cliente("Cliente 4", LocalDate.of(2010, 4, 4));
            Cliente cliente5 = new Cliente("Cliente 5", LocalDate.of(1950, 5, 5));

            // Adiciona os clientes criados à fila

            Fila.adicionarNaFila(cliente1);
            Fila.adicionarNaFila(cliente2);
            Fila.adicionarNaFila(cliente3);
            Fila.adicionarNaFila(cliente4);
            Fila.adicionarNaFila(cliente5);
        }

    }

    public void voltarTela(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}