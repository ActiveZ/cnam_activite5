package Validation6;

import java.util.Collections;
import java.util.TreeSet;

public class Launch {
    public static void main(String[] args) {

        Index index = new Index();

        index.ajouter("a",1);
        index.ajouter("Z",31);
        index.ajouter("z",31);
        index.ajouter("z",1);
        index.ajouter("c",2);
        index.ajouter("c",25);
        index.ajouter("c",3);
        index.ajouter("b",3);

        //Collections.sort(index.dico);

        System.out.println("index trié:");
        //for (String e:index.dico) System.out.println(e);
        System.out.println("-------------");
        for (Entree m: index.mot) {
            System.out.println(m);
            //System.out.println(m.page);

        }
    }
}
