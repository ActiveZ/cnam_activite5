package Validation6;

import java.util.ArrayList;
import java.util.List;

public class Index {
    public ArrayList<Entree> dico = new ArrayList<>();

    public void ajouter(String txt, int page) {
        Entree entree = new Entree(txt,page);
        dico.add(entree);


    }

}
