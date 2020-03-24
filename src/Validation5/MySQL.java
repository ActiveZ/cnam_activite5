package Validation5;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class MySQL {

    // ---------------------------------------
    // ---------- Attributs ------------------
    // ---------------------------------------
    private final String SEPARATEUR = ";"; // séparateur de colonnes des fichiers CSV

    private Connection ct;
    private Statement st;

    private final String nomBdd = "Hoc-act5-validation";
    private String url = "jdbc:mysql://localhost/" + nomBdd; // url de la base
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

    private void detruireTable(String table) {
        String sql = "DROP TABLE IF EXISTS " + table;
        try {
            // exécute la requête
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void creerTableEleves (String fEleves) { // id, nom, prenom
        //destruction de l'ancienne table
        detruireTable("eleves");

        //création de la table
        //okString sql = "CREATE TABLE eleves ( `id` INT NOT NULL, `nom` VARCHAR (200) NOT NULL, `prenom` VARCHAR(200) NOT NULL, PRIMARY KEY(`id`)) ENGINE = MyISAM;";
        String sql = "CREATE TABLE eleves" +
                " ( id INT NOT NULL, " +
                "nom VARCHAR (200) NOT NULL, " +
                "prenom VARCHAR(200) NOT NULL, " +
                "PRIMARY KEY(id)) " +
                "ENGINE = MyISAM;";
        try {
            // exécute la requête
           st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            //remplissage de la table
            File f = new File(fEleves);
            Scanner sc = new Scanner(f);
            sc.nextLine(); // on saute la 1 ere ligne = nom colonnes
            sql = "INSERT INTO eleves (id, nom, prenom) VALUES ";
            // lecture de chaque ligne du fichier
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                sql += "('" + line + "'), ";
            }
            sc.close();
            sql = sql.replaceAll(";", "' ,'");
            sql = sql.substring(0, sql.length() - 2) + ";";
            //System.out.println(sql);
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
            // exécute la requête
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            //remplissage de la table
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
            //System.out.println(sql);
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

    public void creerTableMatieres(String fMatieres) {
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
            // exécute la requête
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
            //System.out.println(sql);
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
