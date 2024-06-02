//Comenzamos haciendo los libros, que será la parte mas senzilla en si.

package com.example.database.models;

public class Llibres{
    int id;
    String nom;
    String autor; 
    String genere;
//posem les variables
    public Llibres(int id, String nom, String autor, String genere){
        this.id = id;
        this.nom = nom;
        this.autor = autor;
        this.genere = genere;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setNom(String nom){
        this.nom = nom; 
    }

    public String getNom() {
        return nom;
    }

    public void setAutor(String autor){
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    public void setGenere(String genere){
        this.genere = genere;
    }

    public int getGenere() {
        return genere;
    }
}
//les truquem totes.