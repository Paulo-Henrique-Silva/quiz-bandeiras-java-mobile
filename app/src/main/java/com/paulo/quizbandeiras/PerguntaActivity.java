package com.paulo.quizbandeiras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.paulo.quizbandeiras.modelo.Pergunta;

public class PerguntaActivity extends AppCompatActivity {

    //componentes
    private ImageView imgBandeira;

    private RadioButton rbtAlternativa1, rbtAlternativa2, rbtAlternativa3, rbtAlternativa4;

    private TextView lblContador;

    private ProgressBar pbrProgresso;

    private RadioGroup rgbAlternativas;

    private Button btnAvancar;

    //atributos
    private Pergunta[] perguntas;

    private int contadorPergunta = 0;

    private int quantidadeAcertos = 0;

    private String nomeUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta);

        //inicia componentes
        imgBandeira = findViewById(R.id.imgBandeira);
        rbtAlternativa1 = findViewById(R.id.rbtAlternativa1);
        rbtAlternativa2 = findViewById(R.id.rbtAlternativa2);
        rbtAlternativa3 = findViewById(R.id.rbtAlternativa3);
        rbtAlternativa4 = findViewById(R.id.rbtAlternativa4);
        lblContador = findViewById(R.id.lblContador);
        pbrProgresso = findViewById(R.id.pbrProgresso);
        rgbAlternativas = findViewById(R.id.rgpAlternativas);
        btnAvancar = findViewById(R.id.btnAvancar);

        Intent intent = getIntent(); //obtém o nome do usuário
        nomeUsuario = intent.getStringExtra("nomeUsuario");

        System.out.println(nomeUsuario);

        //inicia perguntas
        perguntas = new Pergunta[] {
            new Pergunta(R.drawable.brazil, "Brasil", "Canadá", "Taiwan", "África Do Sul", 0),
            new Pergunta(R.drawable.china, "Portugal", "China", "Estados Unidos", "Rússia", 1),
            new Pergunta(R.drawable.japan, "Japão", "México", "Moldávia", "Quirguistão", 0),
            new Pergunta(R.drawable.mozambique, "Somália", "Congo", "Angola", "Moçambique", 3),
            new Pergunta(R.drawable.france, "Itália", "Irlanda", "França", "Alemanha", 2),
            new Pergunta(R.drawable.israel, "Irã", "Romênia", "Israel", "Egito", 2),
            new Pergunta(R.drawable.liechtenstein, "Suiça", "Liechtenstein", "Mônaco", "Vaticano", 1),
            new Pergunta(R.drawable.uganda, "Uganda", "Angola", "Sudão do sul", "Gana", 0),
            new Pergunta(R.drawable.ukraine, "Rússia", "Ucrânia", "Belarus", "Polônia", 1),
            new Pergunta(R.drawable.bangladesh, "Cazaquistão", "Mogólia", "Nepal", "Bangladesh", 3)
        };

        //inicia os componentes
        lblContador.setText(String.format("%d/%d", 1, perguntas.length));
        pbrProgresso.setProgress(1);

        imgBandeira.setImageResource(perguntas[0].getIdImagemBandeira());
        rbtAlternativa1.setText(perguntas[0].getAlternativa1Texto());
        rbtAlternativa2.setText(perguntas[0].getAlternativa2Texto());
        rbtAlternativa3.setText(perguntas[0].getAlternativa3Texto());
        rbtAlternativa4.setText(perguntas[0].getAlternativa4Texto());
    }

    public void ativarBotao(View view) {
        btnAvancar.setEnabled(true);
    }

    public void avancar(View view) {
        RadioButton alternativaMarcada = findViewById(rgbAlternativas.getCheckedRadioButtonId());

        if ((alternativaMarcada.equals(rbtAlternativa1) && perguntas[contadorPergunta].getIdAlternativaCorreta() == 0) || (alternativaMarcada.equals(rbtAlternativa2) && perguntas[contadorPergunta].getIdAlternativaCorreta() == 1) ||
            (alternativaMarcada.equals(rbtAlternativa3) && perguntas[contadorPergunta].getIdAlternativaCorreta() == 2) || (alternativaMarcada.equals(rbtAlternativa4) && perguntas[contadorPergunta].getIdAlternativaCorreta() == 3)) { //se acertou, marca o acerto.
            quantidadeAcertos++;
        }

        contadorPergunta++;

        if (contadorPergunta < perguntas.length) {
            alternativaMarcada.setChecked(false);
            btnAvancar.setEnabled(false);

            pbrProgresso.setProgress(contadorPergunta + 1);
            lblContador.setText(String.format("%d/%d", contadorPergunta + 1, perguntas.length));

            imgBandeira.setImageResource(perguntas[contadorPergunta].getIdImagemBandeira());

            rbtAlternativa1.setText(perguntas[contadorPergunta].getAlternativa1Texto());
            rbtAlternativa2.setText(perguntas[contadorPergunta].getAlternativa2Texto());
            rbtAlternativa3.setText(perguntas[contadorPergunta].getAlternativa3Texto());
            rbtAlternativa4.setText(perguntas[contadorPergunta].getAlternativa4Texto());
        } else {
            Intent intent = new Intent(getApplicationContext(), ResultadosActivity.class);

            intent.putExtra("quantidadeAcertos", quantidadeAcertos);
            intent.putExtra("quantidadePerguntas", perguntas.length);
            intent.putExtra("nomeUsuario", nomeUsuario);

            startActivity(intent);
        }
    }
}