package com.example.nexusapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.nexusapp.DBHelper.AlunoDAO;
import com.example.nexusapp.DBHelper.DbHelper;
import com.example.nexusapp.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class ListAlunoActivity extends AppCompatActivity {

    DbHelper db = new DbHelper(this);
    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList;
    ListView listViewAlunos;
    List<Aluno> alunos;
    ArrayList<Aluno> alunosFiltros = new ArrayList<>();
    private AlunoDAO dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_aluno);
        setTitle("Tela de lista Alunos");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listViewAlunos = (ListView) findViewById(R.id.listViewAlunos);


        dao = new AlunoDAO(this);
        alunos = dao.ListarAlunos();
        alunosFiltros.addAll(alunos);

        //ArrayAdapter<Aluno> adaptador = new ArrayAdapter<Aluno>(this, android.R.layout.simple_list_item_1, alunosFiltros);
        AdapterAluno adaptador = new AdapterAluno(this, alunosFiltros);
        listViewAlunos.setAdapter(adaptador);
        registerForContextMenu(listViewAlunos);



    }



    @Override
    protected void onResume() {
        super.onResume();
        alunos = dao.ListarAlunos();
        alunosFiltros.clear();
        alunosFiltros.addAll(alunos);
        listViewAlunos.invalidateViews();
    }




    public void CadastroAluno(MenuItem intem){
        Intent intent = new Intent(this, InserirAlunoActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_list_aluno, menu);

        SearchView searchView = (SearchView) menu.findItem(R.id.menu_pesquisar).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                procuraAlunos(newText);
                return false;
            }
        });
        return true;
    }

    public void procuraAlunos(String nome){
        alunosFiltros.clear();
        for (Aluno a : alunos){
            if (a.getNome().toLowerCase().contains(nome.toLowerCase())){
                alunosFiltros.add(a);
            }
        }
        listViewAlunos.invalidateViews();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_aluno_contexto, menu);
    }


    public void excluirAluno(MenuItem menuItem){
        AdapterView.AdapterContextMenuInfo menuInfo =
                (AdapterView.AdapterContextMenuInfo) menuItem.getMenuInfo();

       final Aluno alunoExcluir = alunosFiltros.get(menuInfo.position);

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Atenção")
                .setMessage("Realmente de seja excluir o aluno? ")
                .setNegativeButton("Não", null)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        alunosFiltros.remove(alunoExcluir);
                        alunos.remove(alunoExcluir);
                        dao.excluir(alunoExcluir.getId());
                        listViewAlunos.invalidateViews();
                    }
                }).create();
        dialog.show();
    }

    public void atualizarAluno(MenuItem menuItem){
        AdapterView.AdapterContextMenuInfo menuInfo =
                (AdapterView.AdapterContextMenuInfo) menuItem.getMenuInfo();

        final Aluno alunoAtualizar = alunosFiltros.get(menuInfo.position);
        Intent intent = new Intent(ListAlunoActivity.this, InserirAlunoActivity.class);
        intent.putExtra("aluno", alunoAtualizar);
        startActivity(intent);


    }
}
