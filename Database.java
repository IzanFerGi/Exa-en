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
    public void addLlibre(Llibres llibres) throws SQLException{
        String query = "INSERT INTO llibres (nom, autor, genere) VALUES (?, ?, ?)";
        //Els ?? es per marcar les poscions dels valors
        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
        //Aquí el que hi fem sería crear un try per recuperar qualsevol clau generada com el ID del llibre.
            statement.setString(1, llibres.getNom());
            statement.setString(2, llibres.getAutor());
            statement.setString(3, llibres.getGenere());
            statement.executeUpdate();
        // Aquí el que hi fem sería assignar els valors dels parametres
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    llibres.setId(generatedKeys.getInt(1));
                }
            }
        //Aqui el que hi fem es que si s'ha generat un nou ID es ficara en el objecte llibres
        }
    }

    //Aquí el que hem fer una clase per insertar nous llibres de les bases de dades.
    public Llibres getLlibre(int id) throws SQLException{
        
    }
}
//Aqui ja hem fet totes les clases que necesitem per a la database.

