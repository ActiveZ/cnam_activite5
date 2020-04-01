package Validation6;

import java.util.TreeSet;

/**
 * Une entrée est constituée de son texte et d'un Treeset pour ses pages correspondantes (donc classées)
 */
public class Entree implements Comparable<Entree> {
    protected String texte;
    protected TreeSet <Integer> page = new TreeSet<>() ;

    public Entree(String texte, int page) {
        this.texte = texte; // le texte
        this.page.add(page); // la ou les pages
    }

    @Override
    public String toString() {
        return (texte + " : " + page);
    }

    /**
     * Affichage par ordre alphabétique croissant de son texte
     * @param entree
     * @return
     */
    @Override
    public int compareTo(Entree entree) {
        return this.texte.compareTo(entree.texte);
    }
}
