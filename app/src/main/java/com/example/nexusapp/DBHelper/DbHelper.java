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
    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS";

    private static final String TABELA_ALUNOS = "alunos";
    private static final String TABELA_AVALIACAO = "avaliacao";
    private static final String TABELA_EXERCICIO = "Exercicio";
    private static final String TABELA_TREINO = "Treino";
    private static final String TABELA_PRESCREVER = "prescrever";


    private static final String COLUMNS_IDALUNO = "idAluno";
    private static final String COLUMNS_NOME = "nome";
    private static final String COLUMNS_DATANASC = "dataNasc";
    private static final String COLUMNS_EMAIL = "email";
    private static final String COLUMNS_CEL = "celular";
    private static final String COLUMNS_CPF = "cpf";
    private static final String COLUMNS_FK_ENDERECO = "fk_Endereco_idEndereco";



    public DbHelper(Context context)
    {

        super(context, NOME_DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Query de criação d tabela
        String sql = CREATE_TABLE+" "+TABELA_ALUNOS
                +" ("+COLUMNS_IDALUNO+" INTEGER PRIMARY KEY AUTOINCREMENT , " +
                COLUMNS_NOME+" VARCHAR, "+COLUMNS_DATANASC+" VARCHAR, "+COLUMNS_EMAIL+" VARCHAR, "+COLUMNS_CEL+" VARCHAR," +
                COLUMNS_CPF+" VARCHAR, COLUMNS_FK_ENDERECO INTEGER);";

        String sqlAvaliacao = CREATE_TABLE + " "+TABELA_AVALIACAO
                +" ( altura INTEGER, peitoral INTEGER, subescapular INTEGER, triceps INTEGER, axilarM INTEGER, supraIliaca INTEGER,"
                +"    idAvalia INT PRIMARY KEY, peso INTEGER, femuralM INTEGER,abdominal INTEGER, fk_Aluno_idaluno INTEGER );";

        String sqlExercicio = CREATE_TABLE +" "+TABELA_EXERCICIO+" (nomeExercicio VARCHAR, idExercicio INTEGER PRIMARY KEY, imagemExercicio VARCHAR);";

        String sqlTreino = CREATE_TABLE +" "+TABELA_TREINO+" (tipoTreino VARCHAR, padrao BOOLEAN,idTreino INTEGER PRIMARY KEY);";

        String sqlPrescrever = CREATE_TABLE +" "+TABELA_PRESCREVER+" (fk_Treino_idTreino INTEGER,fk_Exercicio_idExercicio INTEGER,tempoDescanso TIME,peso INTEGER,repeticoes INTEGER,series INTEGER);";


        try {
            db.execSQL( sql );
            db.execSQL( sqlAvaliacao );
            db.execSQL( sqlExercicio );
            db.execSQL( sqlTreino );
            db.execSQL( sqlPrescrever );
            Log.i("INFO DB", "Sucesso ao criar a tabela" );
        }catch (Exception e){
            Log.i("INFO DB", "Erro ao criar a tabela" + e.getMessage() );
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABELA_ALUNOS + " ; ";
        String sqlAvaliacao = "DROP TABLE IF EXISTS " + TABELA_AVALIACAO + " ; ";
        String  sqlExercicio = "DROP TABLE IF EXISTS " + TABELA_EXERCICIO + " ; ";
        String  sqlTreino = "DROP TABLE IF EXISTS " + TABELA_TREINO + " ; ";
        String  sqlPrescrever = "DROP TABLE IF EXISTS " + TABELA_PRESCREVER + " ; ";
        try {
            db.execSQL( sql );
            db.execSQL( sqlAvaliacao );
            db.execSQL( sqlExercicio );
            db.execSQL( sqlTreino );
            db.execSQL( sqlPrescrever );
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
        values.put(COLUMNS_CPF, aluno.getCpf());

        db.insert(TABELA_ALUNOS, null, values);
        db.close();

    }

    public Aluno selectAluno(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABELA_ALUNOS, new String[] {COLUMNS_IDALUNO, COLUMNS_NOME, COLUMNS_DATANASC, COLUMNS_EMAIL, COLUMNS_CEL},
                COLUMNS_IDALUNO + " = ?",
                new String[] {String.valueOf(id)}, null, null, null, null);
        if (cursor != null){
            cursor.moveToNext();
        }

        Aluno aluno = new Aluno(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2),
                cursor.getString(3), cursor.getString(4),
                cursor.getString(5));

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
                aluno.setCpf(cursor.getString(5));
                listaAlunos.add(aluno);
            }while (cursor.moveToNext());
        }



        return listaAlunos;
    }


}
