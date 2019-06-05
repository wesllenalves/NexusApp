package com.example.nexusapp;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.nexusapp.model.Aluno;

import java.util.List;

public class AdapterAluno extends BaseAdapter {

    private List<Aluno> alunos;
    private Activity activity;

    public AdapterAluno(Activity activity,List<Aluno> alunos) {
        this.activity = activity;
        this.alunos = alunos;

    }

    @Override
    public int getCount() {
        return alunos.size();
    }

    @Override
    public Object getItem(int position) {
        return alunos.get(position);
    }

    @Override
    public long getItemId(int position) {

        return alunos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = activity.getLayoutInflater().inflate(R.layout.itens_alunos, parent, false);
        TextView nome =  v.findViewById(R.id.txtNome);
        TextView dataNasc =  v.findViewById(R.id.txtDatanasc);
        TextView email =  v.findViewById(R.id.txtEmail);
        TextView celular =  v.findViewById(R.id.txtCelular);
        TextView cpf =  v.findViewById(R.id.txtCpf);

        Aluno aluno = alunos.get(position);

        nome.setText(aluno.getNome());
        dataNasc.setText(aluno.getDataNasc());
        email.setText(aluno.getEmail());
        celular.setText(aluno.getCel());
        cpf.setText(aluno.getCpf());

        return v;
    }
}
