package Exercice3;

public class Catalogue {
    private int id, tva;
    private String nom, description;
    private double prixU;

    public Catalogue(int id, int tva, String nom, String description, double prixU) {
        this.id = id;
        this.tva = tva;
        this.nom = nom;
        this.description = description;
        this.prixU = prixU;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTva() {
        return tva;
    }

    public void setTva(int tva) {
        this.tva = tva;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrixU() {
        return prixU;
    }

    public void setPrixU(double prixU) {
        this.prixU = prixU;
    }
}
