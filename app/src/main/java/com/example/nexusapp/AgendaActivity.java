package com.example.nexusapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.nexusapp.DBHelper.AlunoDAO;
import com.example.nexusapp.DBHelper.DbHelper;
import com.example.nexusapp.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AgendaActivity extends AppCompatActivity {
    Spinner spinner;
    Button spinnerAdd;

    DbHelper db = new DbHelper(this);
    List<Aluno> alunos;
    ArrayList<Aluno> alunosFiltros = new ArrayList<>();
    private AlunoDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);
        setTitle("Tela de Agenda");
        spinner = findViewById(R.id.spinner);
        spinnerAdd = (Button) findViewById(R.id.spinnerAdd);

        dao = new AlunoDAO(this);
        alunos = dao.ListarAlunos();
        alunosFiltros.addAll(alunos);

        //criar um adpaptador com o valores de nome vindo do banco de dados
        ArrayAdapter<Aluno> adaptador = new ArrayAdapter<Aluno>(this,
                android.R.layout.simple_spinner_item, alunosFiltros);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adaptador);

        //pega o valor selecionado pelo snniper
        /*spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Aluno aluno= (Aluno) parent.getSelectedItem();
                AdicionarAlunoSnniper(view, aluno);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/
    }

    public void getSelectdUser(View view){
        Aluno aluno = (Aluno) spinner.getSelectedItem();
        createDisplayUserdate(aluno);


    }

    private void createDisplayUserdate(Aluno aluno) {
        int idAluno = aluno.getId();
        String name = aluno.getNome();

        String values = "Name: "+ name + "id: "+ idAluno;

        Toast.makeText(this, "Aluno:"+ values, Toast.LENGTH_LONG).show();
    }


    public void AdicionarAlunoSnniper(View view) {

       String values =  spinner.getSelectedItem().toString();

        Toast.makeText(this, "Aluno:"+ values, Toast.LENGTH_LONG).show();
    }
}
