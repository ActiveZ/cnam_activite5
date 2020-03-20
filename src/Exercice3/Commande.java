package Exercice3;

public class Commande {
    private int id, idProduit, Qte;

    public Commande(int id, int idProduit, int qte) {
        this.id = id;
        this.idProduit = idProduit;
        Qte = qte;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public int getQte() {
        return Qte;
    }

    public void setQte(int qte) {
        Qte = qte;
    }
}
