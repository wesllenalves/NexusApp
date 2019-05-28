package com.example.nexusapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.nexusapp.R;
import com.example.nexusapp.model.Aluno;

import java.text.BreakIterator;
import java.util.List;

public class AlunoAdapter extends RecyclerView.Adapter<AlunoAdapter.MyViewHolder>  {

    private List<Aluno> listaAlunos;

    public AlunoAdapter(List<Aluno> lista )
    {
        this.listaAlunos = lista;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_list_aluno, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Aluno aluno = listaAlunos.get(position);
        holder.aluno.setText( aluno.getNome() );
        Log.i("tarefaAdapter", aluno.getNome() );

    }

    @Override
    public int getItemCount() {
        return this.listaAlunos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        TextView aluno;

        public MyViewHolder(View itemView) {
            super(itemView);

            aluno = itemView.findViewById(R.id.textTarefa);

        }
    }

}
