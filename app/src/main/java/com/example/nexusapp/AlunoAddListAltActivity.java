package com.example.nexusapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AlunoAddListAltActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno_add_list_alt);
        setTitle("Alterar Incluir Excluir");
        setTitle("Tela de adicionar listar ou alterar");
    }

    public void voltarAluno(View view) {
        Intent intent = new Intent(this, AlunoActivity.class);
        startActivity(intent);
    }
}
