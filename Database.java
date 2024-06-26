package examen;
import lib.Llibres;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//Importem totes les cosas que hi necessitem.

public class Database{

    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection connexio;

    public Database(String jdbcURL,String jdbcUsername, String jdbcPassword ){
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    public void connectar() throws SQLException{
        if (connexio == null || connexio.isClosed()){
            connexio = DriverManager.getConnexio(jdbcURL, jdbcUsername, jdbcPassword);
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
        String query = "SELECT * FROM llibres WHERE id = ?";
        try (PreparedStatement statement = connexio.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()){
                if (resultSet.next()) {
                    String nom = resultSet.getString("nom");
                    String autor = resultSet.getString("autor");
                    String genere = resultSet.getString("genere");
                    return new Llibres(id, nom, autor, genere); 
                }
            }
        }
        return null;
    }
    
    //Aqui el que hi hem fet ha sigut executar una consulta per selecciona un llibre 
    //de la taula llibres, si troba un llibre amb el id torna un objecte llibre amb les 
    //dades del llibre, si no hi troba res el que retorna es null.

    public List<Llibre> getAllLlibres() throws SQLException {
        List<Llibre> llibress = new ArrayList<>();
        String query = "SELECT * FROM llibres";
        try (Statement statement = connexio.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                String autor = resultSet.getString("autor");
                String genere = resultSet.getString("genere");
                llibres.add(new Llibres(id, nom, autor, genere));
            }
        }
        return llibres;
    }
  
    //Aqui el que hi em fet ha sigut executar una consulta on el que hi fem es que
    //ensenyi tots els registres del llibres que hi han, y que per cada registre trobat
    //el que hi farem será crear un objecte amb amb les seves dades, fica tots els objectes a 
    //una llista, y per ultim retornala llista completa dels llibres. 


    public void updateLlibres(llibres llibres) throws SQLException {
        String query = "UPDATE llibres SET nom = ?, autor = ?, genere = ? WHERE id = ?";
        try (PreparedStatement statement = connexio.prepareStatement(query)) {
            statement.setString(1, llibres.getNom());
            statement.setString(2, llibres.getAutor());
            statement.setString(3, llibres.getGenere());
            statement.setInt(4, llibres.getId());
            statement.executeUpdate();
        }
    }
   
    //Aqui el que hi estem fent es executar una consulta per actualitzar tots els registres 
    //de la taula llibres a on amb el id coincideix amb el objecte llibre.
   

    public void deleteLlibres(int id) throws SQLException {
        String query = "DELETE FROM llibres WHERE id = ?";
        try (PreparedStatement statement = connexio.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    //Aqui el que hi hem fet ha sigut executar una consulta per borrar els llibres quan hi 
    //troba el id, i una vegada fet alló el que hi fá es actualitzar.

}

//Aqui ja hem fet totes les clases que necesitem per a la database.

