package com.example.nexusapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

public class AlunoActivity extends AppCompatActivity implements View.OnClickListener{
    private CardView card_aluno,card_lista;
    private Button btnInserir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno);
        setTitle("Tela de Alunos");

        card_aluno = (CardView) findViewById(R.id.card_aluno);
        card_lista = (CardView) findViewById(R.id.card_lista);
        card_aluno.setOnClickListener(this);
        card_lista.setOnClickListener(this);

       //btnInserir = (Button) findViewById(R.id.btnInserir);
       //btnInserir.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
    Intent i;
        switch (v.getId()){
            case R.id.card_aluno:
                AlertAlunoActivity alert = new AlertAlunoActivity();
                alert.show(getSupportFragmentManager(),"Alerta");

                /*i = new Intent(this, AlunoAddListAltActivity.class);
                startActivity(i);*/
                break;
            case R.id.card_lista:
                i = new Intent(this, ListAlunoActivity.class);
                startActivity(i);
                break;
            case R.id.btnInserir:
                Toast.makeText(this,"teste", LENGTH_LONG).show();
                break;

        }

    }

    public void voltarMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void inserirAluno(View view) {
        //Toast.makeText(this,"inserir", LENGTH_LONG).show();
       Intent it = new Intent(this, InserirAlunoActivity.class);
       startActivity(it);
    }

    public void alterarAluno(View view) {
        Toast.makeText(this,"alterar", LENGTH_LONG).show();
        //Intent it = new Intent(this, AlunoAddListAltActivity.class);
        // startActivity(it);
    }

    public void excluirAluno(View view) {
        Toast.makeText(this,"excluir", LENGTH_LONG).show();
        //Intent it = new Intent(this, AlunoAddListAltActivity.class);
        // startActivity(it);
    }
}

