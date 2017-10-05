package com.example.henrique.app_interdiciplinarv3.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.henrique.app_interdiciplinarv3.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void carregaItemMenu(View v){
        switch (v.getId()){
            case R.id.btnInserir:
                carregarIntent(CadastrarLivroActivity.class);
                break;
            case R.id.btnListar:
                carregarIntent(ListarLivroActivity.class);
                break;
            case R.id.btnPesquisar:
                carregarIntent(PesquisarLivroActivity.class);
                break;
        }
    }

    private void carregarIntent(Class classe){
        Intent intent = new Intent(MainActivity.this,classe);
        startActivity(intent);
    }



}
