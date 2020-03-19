package Exercice1;

import java.sql.*;

public class MySQL {

    private final String ligne = "---------------------------------------";
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
        String sql = "INSERT INTO Employe (Nom, Categorie, Salaire) VALUES ('"+nom+"', '"+categorie+"', '"+salaire+"')";
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
            System.out.println("Affichage des données de la table 'Employe':");
            while (rs.next()) {
                //System.out.println(rs.getInt("Id"));
                String nom = rs.getString("Nom");
                int categorie =  rs.getInt("Categorie");
                int salaire = rs.getInt("Salaire");
                System.out.println("Nom: " + nom + "   Catégorie: " + categorie + "   Salaire: " + salaire);
            }
            System.out.println(ligne);
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

    public void triCategorie(int cat) {
        String sql = "SELECT * FROM Employe WHERE Categorie = '"+cat+"'";
        try {
            // exécute la requête
            ResultSet rs = st.executeQuery(sql);
            // parcours des résultats
            System.out.println("Affichage des employés de la catégorie " + cat + ":");
            while (rs.next()) {
                //System.out.println(rs.getInt("Id"));
                String nom = rs.getString("Nom");
                int categorie =  rs.getInt("Categorie");
                int salaire = rs.getInt("Salaire");
                System.out.println("Nom: " + nom + "   Catégorie: " + categorie + "   Salaire: " + salaire);
            }
            System.out.println(ligne);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void promotion(String nomPromu) {
        String sql = "SELECT * FROM Employe WHERE Nom = '"+nomPromu+"'";
        try {
            // exécute la requête
            ResultSet rs = st.executeQuery(sql);
            // parcours des résultats
            //System.out.println("Affichage des employés de la catégorie " + cat + ":");
            int idPromu = 0, categorie = 0;
            String nom = "";
            while (rs.next()) {
                idPromu = rs.getInt("Id");
                nom = rs.getString("Nom");
                categorie =  rs.getInt("Categorie");

                //int salaire = rs.getInt("Salaire");
            }
            if (categorie < 4) {
                categorie++;
                sql = "UPDATE Employe SET Categorie = '"+categorie+"' WHERE Id = '"+idPromu+"' ";
                //requete retourne 1 si réussie, 0 sinon
                if (st.executeUpdate(sql)==1) {
                    System.out.println(nom + " est maintenant en catégorie " + categorie);
                }
            }
            System.out.println(ligne);
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
