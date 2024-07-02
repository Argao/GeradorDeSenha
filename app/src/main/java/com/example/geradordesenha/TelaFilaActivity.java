package com.example.geradordesenha;

// Importações necessárias para a classe
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

// Declaração da classe TelaFilaActivity que estende AppCompatActivity
public class TelaFilaActivity extends AppCompatActivity {
    // Declaração de variáveis para referenciar os elementos da interface
    TextView primeiro_na_fila;
    TextView segundo_na_fila;
    TextView terceiro_na_fila;
    TextView quarto_na_fila;
    TextView senha_atual;
    TextView nome_atual;

    // Método onCreate é chamado quando a atividade é criada
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Habilita o layout Edge to Edge
        EdgeToEdge.enable(this);
        // Define o layout da atividade
        setContentView(R.layout.activity_tela_fila);
        // Configura os insets da janela para os elementos da interface
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Associa as variáveis aos elementos da interface pelo ID
        primeiro_na_fila = (TextView) findViewById(R.id.fila1);
        segundo_na_fila = (TextView) findViewById(R.id.fila2);
        terceiro_na_fila = (TextView) findViewById(R.id.fila3);
        quarto_na_fila = (TextView) findViewById(R.id.fila4);
        senha_atual = (TextView) findViewById(R.id.senha_atual);
        nome_atual = (TextView) findViewById(R.id.nome_atual);

        // Chama o método para atualizar a tela com as informações da fila
        atualizaTela();
    }

    // Método para atualizar os elementos da interface com as informações da fila
    public void atualizaTela(){
        // Obtém o último cliente da fila
        Cliente cliente = Fila.getUltimoCliente();

        // Se existe um cliente, atualiza os elementos da interface com suas informações
        if (cliente != null) {
            senha_atual.setText(cliente.getSenha());
            nome_atual.setText(cliente.getNome());
        } else {
            // Se não há clientes, exibe "-" nos elementos da interface
            senha_atual.setText("-");
            nome_atual.setText("-");
        }

        // Obtém os próximos clientes da fila
        List<String> proximosClientes = Fila.verProximosClientes(4);

        // Atualiza os elementos da interface com os nomes dos próximos clientes
        primeiro_na_fila.setText(proximosClientes.get(0));
        segundo_na_fila.setText(proximosClientes.get(1));
        terceiro_na_fila.setText(proximosClientes.get(2));
        quarto_na_fila.setText(proximosClientes.get(3));
    }

    // Método chamado ao clicar no botão para voltar à tela inicial
    public void voltarTelaInicial(View view) {
        // Cria uma intenção para iniciar a MainActivity
        Intent intent = new Intent(this, MainActivity.class);
        // Inicia a MainActivity
        startActivity(intent);
    }

    // Método chamado ao clicar no botão para avançar a fila
    public void andaFila(View view) {
        // Chama o método para atualizar a tela, refletindo as mudanças na fila
        atualizaTela();
    }
}