package com.example.nexusapp.DBHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.nexusapp.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAO  {

    private SQLiteDatabase escreve;
    private SQLiteDatabase le;

    public AlunoDAO(Context context) {
        DbHelper db = new DbHelper( context );
        escreve = db.getWritableDatabase();
        le = db.getReadableDatabase();
    }
    /*
    @Override
    public boolean salvar(Aluno aluno) {

        ContentValues cv = new ContentValues();
        cv.put("nome", aluno.getNome() );

        try {
            escreve.insert(DbHelper.TABELA_ALUNOS, null, cv );
            Log.i("INFO", "Tarefa salva com sucesso!");
        }catch (Exception e){
            Log.e("INFO", "Erro ao salvar tarefa " + e.getMessage() );
            return false;
        }

        return true;
    }

    @Override
    public boolean atualizar(Aluno aluno) {

        ContentValues cv = new ContentValues();
        cv.put("nome", aluno.getNome() );

        try {
            String[] args = {aluno.getId().toString()};
            escreve.update(DbHelper.TABELA_ALUNOS, cv, "id=?", args );
            Log.i("INFO", "Tarefa atualizada com sucesso!");
        }catch (Exception e){
            Log.e("INFO", "Erro ao atualizada tarefa " + e.getMessage() );
            return false;
        }

        return true;
    }

    @Override
    public boolean deletar(Aluno aluno) {

        try {
            String[] args = { aluno.getId().toString() };
            escreve.delete(DbHelper.TABELA_ALUNOS, "id=?", args );
            Log.i("INFO", "Tarefa removida com sucesso!");
        }catch (Exception e){
            Log.e("INFO", "Erro ao remover tarefa " + e.getMessage() );
            return false;
        }

        return true;
    }

    @Override
    public List<Aluno> listar() {

        List<Aluno> alunos = new ArrayList<>();

        String sql = "SELECT * FROM " + DbHelper.TABELA_ALUNOS + " ;";
        Cursor c = le.rawQuery(sql, null);

        while ( c.moveToNext() ){

            Aluno aluno = new Aluno();

            Long id = c.getLong( c.getColumnIndex("id") );
            String nomeAluno = c.getString( c.getColumnIndex("nome") );

            aluno.setId( id );
            aluno.setNome( nomeAluno );

            alunos.add( aluno );
            Log.i("alunoDao", aluno.getNome() );
        }

        return alunos;

    }*/

}
