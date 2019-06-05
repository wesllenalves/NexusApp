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

private DbHelper conexao;
private SQLiteDatabase db;

    public AlunoDAO(Context context) {
        conexao = new DbHelper(context);
        db = conexao.getWritableDatabase();
    }


    public long SalvarAluno(Aluno aluno){
        ContentValues values = new ContentValues();
        values.put("nome", aluno.getNome());
        values.put("dataNasc", aluno.getDataNasc());
        values.put("email", aluno.getEmail());
        values.put("celular", aluno.getCel());
        values.put("cpf", aluno.getCpf());

        long retorno = db.insert("alunos", null, values);
        db.close();
        return retorno;

    }

    public List<Aluno> ListarAlunos(){
        List<Aluno> listaAlunos = new ArrayList<>();

        Cursor cursor = db.query("alunos", new String[]{"idAluno", "nome", "dataNasc","email","celular","email"},null, null,null,null,null);


        while (cursor.moveToNext()){
            Aluno aluno = new Aluno();
            aluno.setId(cursor.getInt(0));
            aluno.setNome(cursor.getString(1));
            aluno.setDataNasc(cursor.getString(2));
            aluno.setEmail(cursor.getString(3));
            aluno.setCel(cursor.getString(4));
            aluno.setCpf(cursor.getString(5));
            listaAlunos.add(aluno);

        }
        return listaAlunos;
    }

    public boolean excluir(long idAluno){

        try {

            db.delete("alunos","idAluno = ?", new String[]{String.valueOf(idAluno)});


        }catch (Exception e){
            Log.d("AlunoDao", "Não foi possivel deletar produto" );
            return false;
        }finally {
            if (db != null){
                db.close();
            }
        }
        return true;
    }

    public void atualizarAluno(Aluno aluno) {
        ContentValues values = new ContentValues();
        values.put("nome", aluno.getNome());
        values.put("dataNasc", aluno.getDataNasc());
        values.put("email", aluno.getEmail());
        values.put("celular", aluno.getCel());
        values.put("cpf", aluno.getCpf());
        db.update("alunos",values, "idAluno = ?", new String[]{String.valueOf(aluno.getId())});
    }
}
