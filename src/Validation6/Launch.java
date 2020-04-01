package Validation6;

public class Launch {

    public static void main(String[] args) {

        // création de l'index
        Index index = new Index();

        //ajout d'entrées à l'index pour test
        index.ajouter("a",1);
        index.ajouter("T",31);
        index.ajouter("t",31);
        index.ajouter("t",1);
        index.ajouter("c",2);
        index.ajouter("c",25);
        index.ajouter("c",3);
        index.ajouter("b",3);
        index.ajouter("b",3);
        index.ajouter("A",33);
        index.ajouter("a",33);

        // affichage du dico
        index.afficher();
    }
}
