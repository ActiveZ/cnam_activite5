package Validation6;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Index {
    //public ArrayList<String> dico = new ArrayList<>();
    public TreeSet<Entree> mot = new TreeSet<>();

    public void ajouter(String txt, int page) {
        Entree entree = new Entree(txt,page);

        //System.out.println("ok: " + mot.headSet(entree).size() + "   taille: " + mot.size());
        for (Entree e:mot) {
            if (e.texte.equals(entree.texte)) {e.page.add(page);}
        }

        //if (mot.contains(entree)) {

            //System.out.println("contenu: " + entree.texte + "  id: " +  mot.headSet(entree).size());
            //entree.page.add(99);
            //mot.add(page);
        //} else {
            //dico.add(txt);
            mot.add(entree);
        //}

    }

}
