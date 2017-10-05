package com.example.henrique.app_interdiciplinarv3.Factory;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.henrique.app_interdiciplinarv3.Util.BancoUtil;

/**
 * Created by Henrique on 03/10/2017.
 */

public class DatabaseFactory extends SQLiteOpenHelper {

    public DatabaseFactory(Context context){
        super(context, BancoUtil.NOME_BANCO,null,BancoUtil.VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String  sql = "CREATE TABLE "+ BancoUtil.TABELA_BIBLIOTECA +"("
                + BancoUtil.ISBN_LIVRO + " integer primary key autoincrement,"
                + BancoUtil.TITULO_LIVRO + " text,"
                + BancoUtil.GENERO_LIVRO + " text,"
                + BancoUtil.AUTOR_LIVRO + " text,"
                + BancoUtil.EDITORA_LIVRO + " text,"
                +")";
        db.execSQL(sql);

    }

            /*
             + BancoUtil.ANO_LIVRO + " text,"
            + BancoUtil.EXEMPLAR_LOCAL + " integer" */

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + BancoUtil.TABELA_BIBLIOTECA);

        onCreate(db);
    }
}



