package com.paulo.quizbandeiras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ResultadosActivity extends AppCompatActivity {

    private String nomeUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        TextView lblNome = findViewById(R.id.lblNome);
        TextView lblAcertos = findViewById(R.id.lblAcertos);
        ProgressBar pbrProgress = findViewById(R.id.pbrProgresso);

        Intent intent = getIntent(); //obtém o nome do usuário

        int quantidadeAcertos = intent.getIntExtra("quantidadeAcertos", 0);
        nomeUsuario = intent.getStringExtra("nomeUsuario");

        lblNome.setText(nomeUsuario);
        lblAcertos.setText(String.format("%d de %d", quantidadeAcertos, intent.getIntExtra("quantidadePerguntas", 0)));
        pbrProgress.setProgress(quantidadeAcertos);
    }

    public void reiniciarQuiz(View view) {
        Intent intent = new Intent(getApplicationContext(), PerguntaActivity.class);

        intent.putExtra("nomeUsuario", nomeUsuario);

        startActivity(intent);
    }

    public void irATelaInicial(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}