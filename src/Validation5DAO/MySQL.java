package Validation5DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class MySQL {

    // ---------------------------------------
    // ---------- Attributs ------------------
    // ---------------------------------------
    private final String SEPARATEUR = ";"; // séparateur de colonnes des fichiers CSV

    public static Connection ct;
    public static Statement st;

    private final String nomBdd = "Hoc-act5-validation"; // nom de la bdd
    private String url = "jdbc:mysql://localhost/" + nomBdd; // url de la base
    private String login = "root"; // login de connexion à la base
    private String pwd = ""; // mot de passe de connexion à la base
    private String ligne = "----------------------------------------------------";

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
     * Destruction (drop) de la table dans la bdd
     * @param table: table à droper
     */
    public static void detruireTable(String table) {
        String sql = "DROP TABLE IF EXISTS " + table;
        try {
            // exécute la requête de destruction
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    /**
//     * Création de la table "eleves" à partir du fichier CSV
//     * @param fEleves: fichier CSV
//     */
//    public void creerTableEleves (String fEleves) { // id, nom, prenom
//        //destruction de l'ancienne table
//        detruireTable("eleves");
//
//        //création de la table
//        String sql = "CREATE TABLE eleves" +
//                " ( id INT NOT NULL, " +
//                "nom VARCHAR (200) NOT NULL, " +
//                "prenom VARCHAR(200) NOT NULL, " +
//                "PRIMARY KEY(id)) " +
//                "ENGINE = MyISAM;";
//        try {
//            // exécute la requête de création de table
//           st.executeUpdate(sql);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            //remplissage de la table
//            File f = new File(fEleves);
//            Scanner sc = new Scanner(f);
//            sc.nextLine(); // on saute la 1 ere ligne = nom colonnes
//            sql = "INSERT INTO eleves (id, nom, prenom) VALUES ";
//            // lecture de chaque ligne du fichier
//            while (sc.hasNextLine()) {
//                String line = sc.nextLine();
//                sql += "('" + line + "'), ";
//            }
//            sc.close();
//            sql = sql.replaceAll(";", "' ,'");
//            sql = sql.substring(0, sql.length() - 2) + ";";
//        } catch (FileNotFoundException e){
//            System.out.println("ERREUR lecture CSV");
//            e.printStackTrace();
//        }
//
//        try {
//            // exécute la requête de remplissage
//            st.executeUpdate(sql);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * Création de la table "notes" à partir du fichier CSV
     * @param fNotes: fichier CSV
     */
    public void creerTableNotes(String fNotes) { //id, idEleve, idMatiere, note
        //destruction de l'ancienne table
        detruireTable("notes");

        //création de la table
        String sql = "CREATE TABLE notes" +
                " (id INT NOT NULL," +
                " idEleve INT NOT NULL," +
                " idMatiere INT NOT NULL," +
                " note DOUBLE NOT NULL," +
                " PRIMARY KEY(id))" +
                " ENGINE = MyISAM;";
        try {
            // exécute la requête création de table
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            // création de la requête de remplissage de la table
            File f = new File(fNotes);
            Scanner sc = new Scanner(f);
            sc.nextLine(); // on saute la 1 ere ligne = nom colonnes
            sql = "INSERT INTO notes (id, idEleve, idMatiere, note) VALUES ";
            // lecture de chaque ligne du fichier
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                sql += "('" + line + "'), ";
            }
            sc.close();
            sql = sql.replaceAll(";", "' ,'");
            sql = sql.substring(0, sql.length() - 2) + ";";
        } catch (FileNotFoundException e){
            System.out.println("ERREUR lecture CSV");
            e.printStackTrace();
        }

        try {
            // exécute la requête de remplissage
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Création de la table "matieres" à partir du fichier CSV
     * @param fMatieres: fichier CSV
     */
    public void creerTableMatieres(String fMatieres) { //id, nom, coef
        //destruction de l'ancienne table
        detruireTable("matieres");

        //création de la table
        String sql = "CREATE TABLE matieres" +
                " (id INT NOT NULL," +
                " nom VARCHAR (200) NOT NULL," +
                " coef DOUBLE NOT NULL," +
                " PRIMARY KEY(id))" +
                " ENGINE = MyISAM;";
        try {
            // exécute la requête de création de table
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            //remplissage de la table
            File f = new File(fMatieres);
            Scanner sc = new Scanner(f);
            sc.nextLine(); // on saute la 1 ere ligne = nom colonnes
            sql = "INSERT INTO matieres (id, nom, coef) VALUES ";
            // lecture de chaque ligne du fichier
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                sql += "('" + line + "'), ";
            }
            sc.close();
            sql = sql.replaceAll(";", "' ,'");
            sql = sql.substring(0, sql.length() - 2) + ";";
        } catch (FileNotFoundException e){
            System.out.println("ERREUR lecture CSV");
            e.printStackTrace();
        }

        try {
            // exécute la requête
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * calcul de la moyenne générale pondérée de chaque élève et affichage
     */
    public void calculMoyenne() {
        String sql = "SELECT eleves.id, eleves.nom, eleves.prenom, FORMAT(SUM(notes.note*matieres.coef) / SUM(matieres.coef),2) AS 'moyenne'" +
                " FROM eleves, notes, matieres " +
                "WHERE eleves.id=notes.idEleve " +
                "AND notes.idMatiere=matieres.id " +
                "GROUP BY eleves.id";
        try {
            // exécute la requête
            ResultSet rs = st.executeQuery(sql);
            // parcours des résultats et affichage de chaque ligne calculée par la requête
            System.out.println(ligne);
            System.out.println("Moyenne de chaque élève:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String prenom =  rs.getString("prenom");
                Double moyenne = rs.getDouble("moyenne");
                System.out.println("Id:" + id + "   Nom: " + nom + "   Prénom: " + prenom + "   Moyenne: " + moyenne);
            }
            System.out.println(ligne);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * ferme la connextion à la base de données
     */
    public static void close() {
        try {
            ct.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
