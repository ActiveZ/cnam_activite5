package Exercice3;

import java.sql.*;

public class MySQL {

    // ---------------------------------------
    // ---------- Attributs ------------------
    // ---------------------------------------
    private Connection ct;
    private Statement st;

    //pas besoin de préciser le port
    private String url = "jdbc:mysql://localhost/Hoc-act5-exo1"; // url de la base
    private String login = "root"; // login de connexion à la base
    private String pwd = ""; // mot de passe de connexion à la base

    // ---------------------------------------
    // ---------- Constructeurs --------------
    // ---------------------------------------

    public MySQL() {
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

    // ---------------------------------------
    // --------------- Méthodes --------------
    // ---------------------------------------

    /**
     * Calcul des impôts selon les requêtes sql adaptées aux tables
     */
    public double calculImpots(String sql) {
        try {
            // exécute la requête
            ResultSet rs = st.executeQuery(sql);
            double result=0;
            while (rs.next()) {
                result = rs.getDouble("impot");
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    /**
     * ferme la connextion à la base de données
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
