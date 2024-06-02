package examen;

import com.example.database.models.Book;
import java.sql.SQLException;


public class Main{
    public static void main(String[] args) {
        String jdbcURL = "";
        String jdbcUsername = "";
        String jdbcPassword = "";

        try{
            Database bdIzan = new Database(jdbcURL, jdbcUsername, jdbcPassword);
            bdIzan.connectar()

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
        }
    }
}