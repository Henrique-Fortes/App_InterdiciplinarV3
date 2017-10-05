package com.example.henrique.app_interdiciplinarv3.Activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.app.AlertDialog;
import android.widget.Toast;

import com.example.henrique.app_interdiciplinarv3.Adapter.LivroAdapter;
import com.example.henrique.app_interdiciplinarv3.DAO.Livro;
import com.example.henrique.app_interdiciplinarv3.DAO.LivroDAO;
import com.example.henrique.app_interdiciplinarv3.R;

import java.util.List;

/**
 * Created by Henrique on 03/10/2017.
 */

public class ListarLivroActivity extends Activity {


    private ListView listaLivros;
    private LivroAdapter myAdapter;
    LivroDAO livroDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_livros);

        carregarElementos();

        listaLivros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Livro livro = (Livro)parent.getItemAtPosition(position);
                createDialog(livro);
            }
        });
    }

    public void createDialog(final Livro livro){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.dialog_title);
        builder.setItems(R.array.options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case 0:
                        break;
                    case 1:
                        livroDAO.deletaRegistro(livro.getISBN());
                        Toast.makeText(ListarLivroActivity.this, "Livro removido com sucesso.", Toast.LENGTH_SHORT).show();
                        carregarElementos();
                        break;
                }
            }
        });
        builder.setNegativeButton(R.string.cancel, null);

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void carregarElementos(){
        listaLivros = (ListView) findViewById(R.id.listLivros);
        livroDAO = new LivroDAO(this);
        List<Livro> livros = livroDAO.carregaDadosLista(LivroDAO.LIVROS_TOTAL);
        myAdapter = new LivroAdapter(this,R.layout.item_livro,livros);
        listaLivros.setAdapter(myAdapter);
    }


}
