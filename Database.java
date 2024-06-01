package examen;

import lib.Llibres;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//Importem totes les cosas que hi necessitem.

public class Database{

    private String llibURL;
    private String llibUsername;
    private String llibPassword;
    private Connection connexio;

    public Database(String llibURL,String llibUsername, String llibPassword ){
        this.llibURL = llibURL;
        this.llibUsername = llibUsername;
        this.llibPassword = llibPassword;
    }

    public void connectar(){

    }

    public void desconnectar(){

    }

    public void addLlibre(){

    }

    public void getLlibre(){

    }

}