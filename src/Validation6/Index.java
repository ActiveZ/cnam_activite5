package Validation6;

import java.util.TreeSet;

public class Index {

    /**
     * le dictionnaire est un TreeSet d'entrées (donc classé)
     */
    private TreeSet<Entree> dico = new TreeSet<>();

    /**
     * Méthode pour ajouter une nouvelle entrée ou modifier une entrée existante en ajoutant un numéro de page
     * @param txt: le mot/groupe de mot à ajouter/modifier
     * @param page: numéro de la page où se trouve txt
     */
    public void ajouter(String txt, int page) {
        Entree newEntree = new Entree(txt, page);

        // Si l'entrée proposée existe déjà dans le dico, on ajoute un numéro de page suplémentaire
        for (Entree e: dico) {
            if (e.texte.equals(newEntree.texte)) {e.page.add(page);}
        }

        // ajout de la nouvelle entrée dans le dictionnaire
        dico.add(newEntree);
    }


    /**
     * affichage du dico
     */
    public void afficher() {
        System.out.println("index trié:");
        for (Entree e: dico) {
            System.out.println(e);
        }
    }
}
