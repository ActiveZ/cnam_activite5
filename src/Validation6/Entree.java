package Validation6;

public class Entree implements Comparable<Entree> {
    private String texte;
    private int page;

    public Entree(String texte, int page) {
        this.texte = texte;
        this.page = page;
    }

    @Override
    public String toString() {
        return (texte + " " + page);
    }

    @Override
    public int compareTo(Entree entree) {
        return this.texte.compareTo(entree.texte);
    }
}
