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

    public void connectar() throws SQLException{
        if (connexio == null || connexio.isClosed()){
            connexio = DriverManager.getConnexio(llibURL, llibUsername, llibPassword);
        }
    }
    //Aqui el que hi fem es que hi hagi una connxeio valida a la base de dades abans que fer cosas raras, el SQLException suert quan hi ha un problema amb la connexio.
    public void desconnectar() throws SQLException{
        if (connexio != null && !connexio.isClosed()){
            connexio.close();
        }
    }
    //Aqui el que fem es que hi volem crear un metode de desconexió amb la base de dades
    public void addLlibre(){

    }

}
//Aqui ja hem fet totes les clases que necesitem per a la database.

