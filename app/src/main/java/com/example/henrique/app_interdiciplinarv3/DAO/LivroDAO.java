package com.example.henrique.app_interdiciplinarv3.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.henrique.app_interdiciplinarv3.Factory.DatabaseFactory;
import com.example.henrique.app_interdiciplinarv3.Util.BancoUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Henrique on 03/10/2017.
 */

public class LivroDAO {

    private SQLiteDatabase db;
    private DatabaseFactory banco;

    public static final int LIVROS_TOTAL = 1;



    public LivroDAO(Context context) {
        banco = new DatabaseFactory(context);
    }

    public long insereDado(Livro livro) {
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(BancoUtil.TITULO_LIVRO, livro.getTitulo());
        valores.put(BancoUtil.GENERO_LIVRO, livro.getGenero());
        valores.put(BancoUtil.AUTOR_LIVRO, livro.getAutor());
        valores.put(BancoUtil.EDITORA_LIVRO, livro.getEditora());
        //valores.put(BancoUtil.ANO_LIVRO, livro.getAno());
        //valores.put(BancoUtil.EXEMPLAR_LOCAL, livro.isExemplarLocal());


        resultado = db.insert(BancoUtil.TABELA_BIBLIOTECA, null, valores);
        db.close();

        return resultado;

    }

    public Cursor carregaDados() {
        Cursor cursor;
        String[] campos = {BancoUtil.ISBN_LIVRO, BancoUtil.TITULO_LIVRO, BancoUtil.GENERO_LIVRO,
                BancoUtil.AUTOR_LIVRO, BancoUtil.EDITORA_LIVRO /*BancoUtil.ANO_LIVRO, BancoUtil.EXEMPLAR_LOCAL*/};
        db = banco.getReadableDatabase();

        cursor = db.query(BancoUtil.TABELA_BIBLIOTECA, campos, null, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }



    public List<Livro> carregaDadosLista(int TIPO_LIVROS) {
        Cursor cursor = null;
        if(TIPO_LIVROS == LIVROS_TOTAL)
            cursor = carregaDados();

        List<Livro> livros = new ArrayList<>();

        try {
            if(cursor.getCount() > 0) {
                do {
                    Livro livro = new Livro();
                    int Isbn = cursor.getInt(cursor.getColumnIndexOrThrow(BancoUtil.ISBN_LIVRO));
                    String titulo = cursor.getString(cursor.getColumnIndexOrThrow(BancoUtil.TITULO_LIVRO));
                    String genero = cursor.getString(cursor.getColumnIndexOrThrow(BancoUtil.GENERO_LIVRO));
                    String autor = cursor.getString(cursor.getColumnIndexOrThrow(BancoUtil.AUTOR_LIVRO));
                    String editora = cursor.getString(cursor.getColumnIndexOrThrow(BancoUtil.EDITORA_LIVRO));
                    //Date ano = cursor.getDate(cursor.getColumnIndexOrThrow(BancoUtil.ANO_LIVRO));
                    //Boolean exemplarLocal = cursor.getString(cursor.getColumnIndexOrThrow(BancoUtil.EXEMPLAR_LOCAL));


                    livro.setISBN(Isbn);
                    livro.setTitulo(titulo);
                    livro.setGenero(genero);
                    livro.setAutor(autor);
                    livro.setEditora(editora);
                    //livro.setAno(ano);
                    //livro.setExemplarLocal(exemplarLocal);


                    livros.add(livro);
                } while (cursor.moveToNext());
            }
        } finally {
            cursor.close();
        }

        return livros;
    }

    public void deletaRegistro(int Isbn){
        String where = BancoUtil.ISBN_LIVRO + "=" + Isbn;
        db = banco.getReadableDatabase();

        db.delete(BancoUtil.TABELA_BIBLIOTECA,where,null);
        db.close();
    }






}
