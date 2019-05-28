package com.example.nexusapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.nexusapp.DBHelper.AlunoDAO;
import com.example.nexusapp.DBHelper.DbHelper;
import com.example.nexusapp.adapter.AlunoAdapter;
import com.example.nexusapp.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class ListAlunoActivity extends AppCompatActivity {

    DbHelper db = new DbHelper(this);
    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList;
    ListView listViewAlunos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_aluno);
        setTitle("Tela de lista Alunos");

        listViewAlunos = (ListView) findViewById(R.id.listViewAlunos);
        listaAlunos();

    }

    public void voltarAlunoList(View view) {
        Intent intent = new Intent(this, AlunoActivity.class);
        startActivity(intent);
    }


    public void listaAlunos(){
        List<Aluno> alunos = db.ListarAlunos();

        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(ListAlunoActivity.this, android.R.layout.simple_list_item_1, arrayList);

        listViewAlunos.setAdapter(adapter);

        for(Aluno a : alunos){
            //Log.d("Lista\n", "\nID: "+ a.getId() + "\nNome: "+ a.getNome() + "\nEmail: " + a.getEmail());
            arrayList.add(a.getNome() + "-" + a.getEmail());
            adapter.notifyDataSetChanged();
        }
    }


    }
