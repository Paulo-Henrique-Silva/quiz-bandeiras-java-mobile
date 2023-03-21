package com.paulo.quizbandeiras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edtNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNome = findViewById(R.id.edtNome);
        Button btnIniciar = findViewById(R.id.btnAvancar);

        edtNome.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                btnIniciar.setEnabled(!charSequence.toString().trim().equals("")); //checa se há um texto válida na caixa
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void iniciarQuiz(View view) {
        Intent intent = new Intent(getApplicationContext(), PerguntaActivity.class);

        intent.putExtra("nomeUsuario", edtNome.getText().toString());

        startActivity(intent);
    }

    public void sair(View view) {
        this.finish(); //encerra a activity
    }
}