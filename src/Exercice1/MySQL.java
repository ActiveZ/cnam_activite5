package Exercice1;

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
     * @param nom, categorie, salaire  à ajouter
     * Ajoute une personne dans la table Employe
     */
    public void add(String nom, int categorie, int salaire) {
        //String sql = "INSERT INTO Employe (Nom, Categorie, Salaire) VALUES ('"+nom+"', '"+categorie+"', '"+salaire+"')";
        //String sql = "INSERT INTO Employe (Nom, Categorie, Salaire) VALUES ('"+nom+"', 1, 2000)";
        String sql = "INSERT INTO Employe (Nom, Categorie, Salaire) VALUES ('moi', 1, 2000)";
        try {
            // exécute la requête
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lit et affiche tous les enregistrements de la table Employe
     */
    public void lire() {
        String sql = "SELECT * FROM Employe";
        try {
            // exécute la requête
            ResultSet rs = st.executeQuery(sql);
            // parcours des résultats
            while (rs.next()) {
                System.out.println(rs.getInt("Id"));
                System.out.println(rs.getString("Nom"));
                System.out.println(rs.getInt("Categorie"));
                System.out.println(rs.getInt("Salaire"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * vide la table Employe
     */
    public void vide() {
        String sql = "TRUNCATE `Hoc-act5-exo1`.`Employe`";
        try {
            // exécute la requête
            int rs = st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
