package Validation5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connexion {
    protected Connection ct;
    protected Statement st;

    private final String nomBdd = "Hoc-act5-validation"; // nom de la bdd
    private String url = "jdbc:mysql://localhost/" + nomBdd + "?useUnicode=true" +
            "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&" +
            "serverTimezone=UTC"; // url de la base
    private String login = "root"; // login de connexion à la base
    private String pwd = ""; // mot de passe de connexion à la base


    // ---------------------------------------
    // ---------- Constructeur ---------------
    // ---------------------------------------
    public Connexion() {
        try {
            // Chargement du driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Récupération de la connexion
            ct = DriverManager.getConnection(url,login,pwd);
            // Création d'un statement
            st = ct.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * ferme la connexion à la base de données
     */
    public void close() {
        try {
            ct.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
