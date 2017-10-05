package com.example.henrique.app_interdiciplinarv3.DAO;

/**
 * Created by Henrique on 03/10/2017.
 */

public class Livro {




    private int ISBN;
    private String titulo;
    private String genero;
    private String autor;
    private String editora;
    //private Date ano;
    //private boolean exemplarLocal;

    public Livro() {
    }

    public Livro(int ISBN, String titulo, String genero, String autor, String editora /* Date ano, boolean exemplarLocal*/) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.genero = genero;
        this.autor = autor;
        this.editora = editora;
        //this.ano = ano;
        //this.exemplarLocal = exemplarLocal;
    }




    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    /*
    public Date getAno() {
        return ano;
    }

    public void setAno(Date ano) {
        this.ano = ano;
    }

    public boolean isExemplarLocal() {
        return exemplarLocal;
    }

    public void setExemplarLocal(boolean exemplarLocal) {
        this.exemplarLocal = exemplarLocal;
    }
    */

}
