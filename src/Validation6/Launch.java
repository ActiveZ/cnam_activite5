package Validation6;

import java.util.Collections;

public class Launch {
    public static void main(String[] args) {

        Index index = new Index();

        index.ajouter("a",1);
        index.ajouter("c",2);
        index.ajouter("b",3);

        Collections.sort(index.dico);

        System.out.println("index trié:\n");
        for (Entree e:index.dico) System.out.println(e);
    }
}
