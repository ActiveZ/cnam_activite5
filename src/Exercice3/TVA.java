package Exercice3;

import java.sql.Connection;

/**
 * @author XAvier
 * @version 11/03/2020
 * Classe TVA
 */
public class TVA {
    // ---------------------------------------
    // ---------- Attributs ------------------
    // ---------------------------------------
    private int id;
    private double taux;

    // ---------------------------------------
    // ---------- Constructeurs --------------
    // ---------------------------------------

    public TVA() {
        super();
    }

    /**
     * @param id
     * @param taux
     */
    public TVA(int id, double taux) {
        super();
        this.id = id;
        this.taux = taux;
    }

    // ---------------------------------------
    // --------------- Méthodes --------------
    // ---------------------------------------
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return the taux
     */
    public double getTaux() {
        return taux;
    }
    /**
     * @param taux the taux to set
     */
    public void setTaux(double taux) {
        this.taux = taux;
    }
}
