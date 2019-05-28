package com.example.nexusapp.DBHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.nexusapp.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String NOME_DB = "nexus";
    private static final String TABELA_ALUNOS = "alunos";
    private static final String COLUMNS_ID = "id";
    private static final String COLUMNS_NOME = "nome";
    private static final String COLUMNS_DATANASC = "data_nascimento";
    private static final String COLUMNS_EMAIL = "email";
    private static final String COLUMNS_CEL = "celular";
    private static final String COLUMNS_TELE = "telefone";
    private static final String COLUMNS_PESO = "peso";
    private static final String COLUMNS_ALT = "altura";



    public DbHelper(Context context)
    {
        super(context, NOME_DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Query de criação d tabela
        String sql = "CREATE TABLE IF NOT EXISTS "+TABELA_ALUNOS
                +" ("+COLUMNS_ID+" INTEGER PRIMARY KEY AUTOINCREMENT , " +
                COLUMNS_NOME+" VARCHAR, "+COLUMNS_DATANASC+" VARCHAR, "+COLUMNS_EMAIL+" VARCHAR, "+COLUMNS_CEL+" VARCHAR," +
                COLUMNS_TELE+" VARCHAR, "+COLUMNS_PESO+" VARCHAR, "+COLUMNS_ALT+" VARCHAR);";

        try {
            db.execSQL( sql );
            Log.i("INFO DB", "Sucesso ao criar a tabela" );
        }catch (Exception e){
            Log.i("INFO DB", "Erro ao criar a tabela" + e.getMessage() );
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABELA_ALUNOS + " ; ";
        try {
            db.execSQL( sql );
            onCreate(db);
            Log.i("INFO DB", "Sucesso ao atualizar App" );
        }catch (Exception e){
            Log.i("INFO DB", "Erro ao atualizar App" + e.getMessage() );
        }
    }

    /*Array lista de dados

    public ArrayList<Aluno> getLista(){
        String [] Columns = {"id","nome", "dataNasc" , "email" , "cel" , "tel" , "peso" , "alt"};
        Cursor cursor = getWritableDatabase().query("alunos", Columns,null,null,null,null,null,null);
        ArrayList<Aluno> alunos = new ArrayList<Aluno>();

        /*while (cursor.moveToNext()){
            Aluno aluno1 = new Aluno();
            aluno1.setId(cursor.getLong(0));
            aluno1.setNome(cursor.getString(1));
            aluno1.setDataNasc(cursor.getString(2));
            aluno1.setEmail(cursor.getString(3));
            aluno1.setCel(cursor.getInt(3));
            aluno1.setTel(cursor.getInt(4));
            aluno1.setPeso(cursor.getDouble(4));
            aluno1.setAlt(cursor.getDouble(4));

            alunos.add(aluno1);
        }

        return alunos;
    }

    //Salvar dados*/

    public void SalvarAluno(Aluno aluno){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUMNS_NOME, aluno.getNome());
        values.put(COLUMNS_DATANASC, aluno.getDataNasc());
        values.put(COLUMNS_EMAIL, aluno.getEmail());
        values.put(COLUMNS_CEL, aluno.getCel());
        values.put(COLUMNS_TELE, aluno.getTel());
        values.put(COLUMNS_PESO, aluno.getPeso());
        values.put(COLUMNS_ALT, aluno.getAlt());

        db.insert(TABELA_ALUNOS, null, values);
        db.close();

    }

    public Aluno selectAluno(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABELA_ALUNOS, new String[] {COLUMNS_ID, COLUMNS_NOME, COLUMNS_DATANASC, COLUMNS_EMAIL, COLUMNS_CEL, COLUMNS_TELE, COLUMNS_PESO, COLUMNS_ALT},
                COLUMNS_ID + " = ?",
                new String[] {String.valueOf(id)}, null, null, null, null);
        if (cursor != null){
            cursor.moveToNext();
        }

        Aluno aluno = new Aluno(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2),
                cursor.getString(3), cursor.getString(4),
                cursor.getString(5), cursor.getString(6),
                cursor.getString(7));

        return aluno;
    }

    public List<Aluno> ListarAlunos(){
        List<Aluno> listaAlunos = new ArrayList<Aluno>();
        String query = "SELECT * FROM " + TABELA_ALUNOS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = getWritableDatabase().rawQuery(query,null);

        if (cursor.moveToFirst()){
            do {
                Aluno aluno = new Aluno();
                aluno.setId(Integer.parseInt(cursor.getString(0)));
                aluno.setNome(cursor.getString(1));
                aluno.setDataNasc(cursor.getString(2));
                aluno.setEmail(cursor.getString(3));
                aluno.setCel(cursor.getString(4));
                aluno.setTel(cursor.getString(5));
                aluno.setPeso(cursor.getString(6));
                aluno.setAlt(cursor.getString(7));
                listaAlunos.add(aluno);
            }while (cursor.moveToNext());
        }



        return listaAlunos;
    }


}
