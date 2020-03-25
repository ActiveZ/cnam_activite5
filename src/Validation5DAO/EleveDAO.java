package Validation5DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EleveDAO extends DAO<Eleve> {
    private Statement st;

    public EleveDAO(Connection conn) {
        super(conn);
        try {
            st = conn.createStatement();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public boolean create(Eleve obj) {
        return false;
    }

    @Override
    public boolean delete(Eleve obj) {
        return false;
    }

    @Override
    public boolean update(Eleve obj) {
        return false;
    }

    @Override
    public Eleve find(int id) {
        return null;
    }

    /**
     * Création de la table "eleves" à partir du fichier CSV
     * @param fEleves: fichier CSV
     */
    public void creerTableEleves (String fEleves) { // id, nom, prenom
        //destruction de l'ancienne table
        MySQL.detruireTable ("eleves");

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
}
