package Validation6;

import java.util.TreeSet;

public class Entree implements Comparable<Entree> {
    public String texte;
    public TreeSet <Integer> page = new TreeSet<>() ;

    public Entree(String texte, int page) {
        this.texte = texte;
        this.page.add(page);
    }

    @Override
    public String toString() {
        return (texte + " ") + (page);
    }

    @Override
    public int compareTo(Entree entree) {
        return this.texte.compareTo(entree.texte);
    }
}
