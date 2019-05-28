package com.example.nexusapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AgendaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);
        setTitle("Tela de Agenda");
    }

    public void voltarMainAgenda(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
