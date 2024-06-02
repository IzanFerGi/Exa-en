package examen;

import lib.Llibres;
import java.sql.SQLException;


public class Main{
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://172.17.0.2:33060/libros";
        String jdbcUsername = "root";
        String jdbcPassword = "estudiar";

        try{
            Database bdIzan = new Database(jdbcURL, jdbcUsername, jdbcPassword);
            bdIzan.connectar()
            //Per connectarse a la base de dades.

            Llibres newllibre = new Llibres(23, "Soyese Y el correcaminos", "Izan ferrero rocher", "Masculino binario");
            bdIzan.addLlibre(newllibre);
            //Creem els llibres

            Llibres showLlibre = bdIzan.getLlibre(1);
            System.out.println(showLlibre);
            //Per veure els llibres

            showLlibre.setGenere("Yanosoyese");
            bdIzan.updateLlibres(showLlibre);
            //Per actualizar els llibres

            dbIzan.deleteLlibres(1);
            //Per eliminar un llibre

            dbIzan.desconnectar();
            //Per desconnectar de la base de dades.
        }
    }
}