package Exercice0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 */

    /**
     * @author Xavier
     * @version 11/03/2020
     * Classe de démo pour manipuler des données avec une base MySQL
     */
    public class DemoMySQL {

        // ---------------------------------------
        // ---------- Attributs ------------------
        // ---------------------------------------
        private Connection ct;
        private Statement st;

        private String url = "jdbc:mysql://localhost/mabasededonnees"; // url de la base
        private String login = "monlogin"; // login de connexion à la base
        private String pwd = "monmotdepasse"; // mot de passe de connexion à la base

        // ---------------------------------------
        // ---------- Constructeurs --------------
        // ---------------------------------------

        public DemoMySQL() {
            try {
                // Chargement du driver
                Class.forName("com.mysql.jdbc.Driver");
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
         * @param personne à ajouter
         * Ajoute une personne dans la table matable
         */
        public void add(String personne) {
            String sql = "INSERT INTO 'matable' ('personne') VALUES ('"+personne+"')";
            try {
                // exécute la requête
                st.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        /**
         * Lit et affiche tous les enregistrements de la table matable
         */
        public void lire() {
            String sql = "SELECT * FROM matable";
            try {
                // exécute la requête
                ResultSet rs = st.executeQuery(sql);
                // parcours des résultats
                while (rs.next()) {
                    System.out.println(rs.getInt("Id"));
                    System.out.println(rs.getString("personne"));
                    System.out.println(rs.getDouble("Taille"));
                }
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