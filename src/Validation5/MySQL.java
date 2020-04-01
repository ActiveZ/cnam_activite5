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
    private Statement st;
    private String ligne = "----------------------------------------------------";

    // ---------------------------------------
    // ---------- Constructeurs --------------
    // ---------------------------------------

    public MySQL (Connexion conn){
         this.st = conn.st;
    }

    // ---------------------------------------
    // --------------- Méthodes --------------
    // ---------------------------------------

    /**
     * Destruction (drop) de la table dans la bdd
     * @param table: table à droper
     */
    private void detruireTable(String table) {
        String sql = "DROP TABLE IF EXISTS " + table;
        try {
            // exécute la requête de destruction
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Création de la table "eleves" à partir du fichier CSV
     * @param fEleves: fichier CSV
     */
    public void creerTableEleves (String fEleves) { // id, nom, prenom
        //destruction de l'ancienne table
        detruireTable("eleves");

        //création de la table
        String sql = "CREATE TABLE eleves" +
                " ( id INT NOT NULL, " +
                "nom VARCHAR (200) NOT NULL, " +
                "prenom VARCHAR(200) NOT NULL, " +
                "PRIMARY KEY(id)) " +
                "ENGINE = MyISAM;";
        try {
            // exécute la requête de création de table
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
                String prenom = rs.getString("prenom");
                Double moyenne = rs.getDouble("moyenne");
                System.out.println("Id:" + id + "   Nom: " + nom + "   Prénom: " + prenom + "   Moyenne: " + moyenne);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //BONUS: Calcul de la moyenne générale de la classe
        try {
            sql = "SELECT FORMAT((SUM(notes.note*matieres.coef) / SUM(matieres.coef)),2) AS 'moy_classe' " +
                    "FROM eleves, notes, matieres " +
                    "WHERE eleves.id=notes.idEleve " +
                    "AND notes.idMatiere=matieres.id";
            // exécute la requête
            ResultSet rs = st.executeQuery(sql);
            if (rs.first()) {
                System.out.println("Moyenne de la classe: " + rs.getString("moy_classe") + "\n" + ligne);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
