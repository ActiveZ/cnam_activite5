package Exercice3;

import java.sql.Connection;

public abstract class DAO<T> {
    // ---------------------------------------
    // ---------- Attributs ------------------
    // ---------------------------------------
    protected Connection connect = null; // connexion à la base de données

    // ---------------------------------------
    // ---------- Constructeurs --------------
    // ---------------------------------------
    public DAO(Connection conn){
        this.connect = conn;
    }


    // ---------------------------------------
    // --------------- Méthodes --------------
    // ---------------------------------------
    /**
     * Création d'un objet
     * @param obj
     * @return boolean true si ça se passe bien
     */
    public abstract boolean create(T obj);

    /**
     * Effacer l'objet
     * @param obj
     * @return boolean true si ça se passe bien
     */
    public abstract boolean delete(T obj);

    /**
     * Mise à jour de l'objet
     * @param obj
     * @return boolean true si ça se passe bien
     */
    public abstract boolean update(T obj);

    /**
     * Méthode de recherche des informations
     * @param id de l'objet à chercher
     * @return T l'objet trouvé
     */
    public abstract T find(int id);
}
