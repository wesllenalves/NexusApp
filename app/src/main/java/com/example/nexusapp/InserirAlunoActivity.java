package com.example.nexusapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.nexusapp.DBHelper.AlunoDAO;
import com.example.nexusapp.model.Aluno;

public class InserirAlunoActivity extends AppCompatActivity {
    private EditText inputNome, inputDatNasc, inputEmail, inputCel, inputCpf;
    private RadioGroup genero;
    private AlunoDAO dao;
    final int MILISEGUNDOS = 3000;
    private Aluno aluno= null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir_aluno);

        inputNome = findViewById(R.id.inputNome);
        inputDatNasc = findViewById(R.id.inputDatNasc);
        inputEmail = findViewById(R.id.inputEmail);
        inputCel = findViewById(R.id.inputCel);
        inputCpf = findViewById(R.id.inputCpf);

        dao = new AlunoDAO(this);
        Intent intent = getIntent();
        if(intent.hasExtra("aluno")){
            aluno = (Aluno) intent.getSerializableExtra("aluno");
            inputNome.setText(aluno.getNome());
            inputDatNasc.setText(aluno.getDataNasc());
            inputEmail.setText(aluno.getEmail());
            inputCel.setText(aluno.getCel());
            inputCpf.setText(aluno.getCpf());
        }

        //long id = dao.SalvarAluno(new Aluno("teste de Dao","19930924","wesllenalves@gmail.com","111111111","11111111"));
        //Toast.makeText(InserirAlunoActivity.this, "Salvo com sucesso com id " + id, Toast.LENGTH_LONG).show();

        /*db.SalvarAluno(new Aluno( "Joao","19930924","wesllenalves@gmail.com","111111111","11111111"));
        Toast.makeText(InserirAlunoActivity.this, "Salvo com sucesso", Toast.LENGTH_LONG).show();*/


    }




    public void GravarAluno(View view){



        //inserir no banco de dados
        try {


            if (aluno == null){
                Aluno aluno = new Aluno();

                 aluno.setNome(inputNome.getText().toString());
                 aluno.setDataNasc(inputDatNasc.getText().toString());
                 aluno.setEmail(inputEmail.getText().toString());
                 aluno.setCel( inputCel.getText().toString());
                 aluno.setCpf(inputCpf.getText().toString());

                //envia os dados do formulario e retorna o id inserido
                long id = dao.SalvarAluno(aluno);

                //Teste de Banco
            /*db.SalvarAluno(new Aluno("Jose ","19930924","wesllenalves@gmail.com","111111111","11111111"));
            db.SalvarAluno(new Aluno("Maria","19930924","wesllenalves@gmail.com","111111111","11111111"));
            db.SalvarAluno(new Aluno("Joao","19930924","wesllenalves@gmail.com","111111111","11111111"));*/

                Toast.makeText(InserirAlunoActivity.this, "Salvo com sucesso com id " + id, Toast.LENGTH_LONG).show();
                //verifica se foi inserido mesmo um id valido
                if (id > 0){
                    //define um tempo para ir para proxima activity quando inserido
                    new Handler().postDelayed(new Runnable(){
                        @Override
                        public void run() {
                            Intent intent = new Intent(InserirAlunoActivity.this, ListAlunoActivity.class);
                            startActivity(intent);
                            InserirAlunoActivity.this.finish();

                        }
                    }, MILISEGUNDOS);



                }
            }else{
                aluno.setNome(inputNome.getText().toString());
                aluno.setDataNasc(inputDatNasc.getText().toString());
                aluno.setEmail(inputEmail.getText().toString());
                aluno.setCel( inputCel.getText().toString());
                aluno.setCpf(inputCpf.getText().toString());
                dao.atualizarAluno(aluno);
                Toast.makeText(InserirAlunoActivity.this, "Aluno foi atualizado", Toast.LENGTH_LONG).show();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
