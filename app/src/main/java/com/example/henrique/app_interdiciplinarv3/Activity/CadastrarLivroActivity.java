package com.example.henrique.app_interdiciplinarv3.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.henrique.app_interdiciplinarv3.DAO.Livro;
import com.example.henrique.app_interdiciplinarv3.DAO.LivroDAO;
import com.example.henrique.app_interdiciplinarv3.R;

/**
 * Created by Henrique on 03/10/2017.
 */

public class CadastrarLivroActivity extends Activity {

    private EditText editTitulo;
    private Spinner spinnerGenero;
    private EditText editAutor;
    private Spinner spinnerEditora;
    //private Spinner spinnerExemplarLocal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir_livro);

        editTitulo = (EditText) findViewById(R.id.editTitulo);
        spinnerGenero = (Spinner) findViewById(R.id.spinnerGenero);
        editAutor = (EditText) findViewById(R.id.editAutor);
        spinnerEditora = (Spinner) findViewById(R.id.spinnerEditora);
        //spinnerExemplarLocal = (Spinner) findViewById(R.id.spinnerExemplarLocal);

    }

    public void salvarLivro(View v){
        LivroDAO livroDAO = new LivroDAO(this);
        Livro livro = new Livro();

        livro.setTitulo(editTitulo.getText().toString());
        livro.setGenero(spinnerGenero.getSelectedItem().toString());
        livro.setAutor(editAutor.getText().toString());
        livro.setEditora(spinnerEditora.getSelectedItem().toString());
        //livro.setExemplarLocal(spinnerExemplarLocal.getSelectedItem().toString());

        long resultado = livroDAO.insereDado(livro);

        if(resultado > 0){
            exibirMensagem("Cadastro realizado com sucesso!");
        }
        else{
            exibirMensagem("Erro ao cadastrar o item.");
        }
    }

    private void exibirMensagem(String mensagem){
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
    }
}
