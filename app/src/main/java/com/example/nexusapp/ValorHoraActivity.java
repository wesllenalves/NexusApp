package com.example.nexusapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ValorHoraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valor_hora);
        setTitle("Tela de valor hora aula");
    }

    public void voltarMainHoraAula(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
