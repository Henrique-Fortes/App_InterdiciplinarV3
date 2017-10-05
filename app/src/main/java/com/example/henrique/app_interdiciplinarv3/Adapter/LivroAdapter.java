package com.example.henrique.app_interdiciplinarv3.Adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.henrique.app_interdiciplinarv3.DAO.Livro;
import com.example.henrique.app_interdiciplinarv3.R;

import java.util.List;

/**
 * Created by Henrique on 03/10/2017.
 */

public class LivroAdapter extends ArrayAdapter<Livro> {


    private int resource;
    private List<Livro> livros;

    public LivroAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Livro> objects) {
        super(context, resource, objects);
        this.resource = resource;
        livros = objects;


    }

    @Override
    public View getView(int position, View currentView, ViewGroup parent) {
        View mView = currentView;

        if (mView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mView = inflater.inflate(resource, null, false);
        }

        Livro livro = livros.get(position);

        TextView textISBN = (TextView) mView.findViewById(R.id.textISBN);
        TextView textTitulo = (TextView) mView.findViewById(R.id.textTitulo);
        TextView textGenero = (TextView) mView.findViewById(R.id.textGenero);
        TextView textAutor = (TextView) mView.findViewById(R.id.textAutor);
        TextView textEditora = (TextView) mView.findViewById(R.id.textEditora);


        if (textISBN != null) {
            textISBN.setText(String.valueOf(livro.getISBN()));
        }
        if (textTitulo != null) {
            textTitulo.setText(livro.getTitulo());
        }
        if (textGenero != null) {
            textGenero.setText(livro.getGenero());
        }
        if (textAutor != null) {
            textAutor.setText(livro.getAutor());
        }
        if (textEditora != null) {
            textEditora.setText(livro.getEditora());
        }

        return mView;

    }
}


