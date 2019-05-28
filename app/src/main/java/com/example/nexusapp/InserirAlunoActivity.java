package com.example.nexusapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.nexusapp.DBHelper.AlunoDAO;
import com.example.nexusapp.DBHelper.DbHelper;
import com.example.nexusapp.model.Aluno;

public class InserirAlunoActivity extends AppCompatActivity {
    private EditText inputNome, inputDatNasc, inputEmail, inputCel, inputTel, inputPeso, inputAlt;
    private RadioGroup genero;
    DbHelper db = new DbHelper(this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir_aluno);

        //Teste de Banco
       /* db.SalvarAluno(new Aluno("wesllen","19930924","wesllenalves@gmail.com","111111111","11111111","50.5","1.80"));
        db.SalvarAluno(new Aluno("Jose ","19930924","wesllenalves@gmail.com","111111111","11111111","50.5","1.80"));
        db.SalvarAluno(new Aluno("Maria","19930924","wesllenalves@gmail.com","111111111","11111111","50.5","1.80"));
        db.SalvarAluno(new Aluno("Joao","19930924","wesllenalves@gmail.com","111111111","11111111","50.5","1.80"));
        Toast.makeText(InserirAlunoActivity.this, "Salvo com sucesso", Toast.LENGTH_LONG).show();*/

       Aluno aluno = db.selectAluno(3);

       Log.d("Cilente Selecionado","Id Cliente" + aluno.getId() + " nome: "+aluno.getNome() +" Email "+ aluno.getEmail());


    }




    public void GravarAluno(View view){



        //inserir no banco de dados
        try {

            inputNome = findViewById(R.id.inputNome);
            inputDatNasc = findViewById(R.id.inputDatNasc);
            inputEmail = findViewById(R.id.inputEmail);
            inputCel = findViewById(R.id.inputCel);
            inputTel = findViewById(R.id.inputTel);
            inputPeso = findViewById(R.id.inputPeso);
            inputAlt = findViewById(R.id.inputAlt);

            String nomep = inputNome.getText().toString();
            String nascimentop = inputDatNasc.getText().toString();
            String emailp = inputEmail.getText().toString();
            int celp = Integer.parseInt(inputCel.getText().toString());
            int telp = Integer.parseInt(inputTel.getText().toString());
            Double pesop = Double.parseDouble(inputPeso.getText().toString());
            Double altp = Double.parseDouble(inputAlt.getText().toString());

            /*AlunoDAO alunoDAO = new AlunoDAO( getApplicationContext() );

            Aluno aluno = new Aluno();
            aluno.setNome(nomep);
            aluno.setId(alunoAtual.getId());

            if ( alunoDAO.salvar( aluno ) ){
                finish();
                Toast.makeText(getApplicationContext(),
                        "Sucesso ao salvar tarefa!",
                        Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(getApplicationContext(),
                        "Erro ao salvar tarefa!",
                        Toast.LENGTH_SHORT).show();
            }

           // Toast.makeText(this,"Resultado "+ nascimentop  ,Toast.LENGTH_LONG).show();

            //criando banco de dados
            SQLiteDatabase Db_nexus = openOrCreateDatabase("nexus", MODE_PRIVATE, null);

            //criando tabela
            Db_nexus.execSQL("CREATE TABLE IF NOT EXISTS alunos (id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, dataNasc DATE, email VARCHAR, cel VARCHAR, tel VARCHAR, peso DECIMAL(18,6), alt DECIMAL(18,6))");

            //Inserir dados
            Db_nexus.execSQL("INSERT INTO alunos (id, nome, dataNasc, email, cel, tel, peso, alt) VALUES ('1', 'wesllen', '1993/09/24', 'wesllen@gmail.com', '111111', '111111', '111111', '111111')");

            //Recuperando os dados
           Cursor cursor = Db_nexus.rawQuery("SELECT nome FROM alunos", null);




           //Recuperar os Index da tabela
            int indiceNome = cursor.getColumnIndex("nome");
            int indicedataNasc = alunos1.getColumnIndex("dataNasc");
            int indiceemail = alunos1.getColumnIndex("cel");
            int indicetel = alunos1.getColumnIndex("tel");
            int indicepeso = alunos1.getColumnIndex("peso");
            int indicealt = alunos1.getColumnIndex("alt");
            cursor.moveToFirst();



           while (cursor != null){



               Log.i("Resultado nome: ", cursor.getString(0));
               Log.i("Resultado data Nac: ", alunos1.getString(indicedataNasc));
               Log.i("Resultado Email: ", alunos1.getString(indiceemail));
               Log.i("Resultado tel: ", alunos1.getString(indicetel));
               Log.i("Resultado peso: ", alunos1.getString(indicepeso));
               Log.i("Resultado alt: ", alunos1.getString(indicealt));
               cursor.moveToNext();
           }*/
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
