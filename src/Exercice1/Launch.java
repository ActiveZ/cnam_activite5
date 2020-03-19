package Exercice1;

import java.util.Scanner;

public class Launch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // créer la connexion
        MySQL bdd = new MySQL();

        //vide la table
        bdd.vide();

        // ajouter des enregistrements
        peupleBdd(bdd);

        // lire tous les enregistrements
        bdd.lire();

        // trier les employés par catégorie
        System.out.print("Choisissez une catégorie d'employés à afficher (1-4):");
        int choix = sc.nextInt();
        if (choix > 0 && choix < 5) {
            bdd.triCategorie(choix);
            sc.nextLine();
        }

        // promouvoir un employé à la catégorie + 1
        System.out.print("Nom de l'employé à promouvoir: ");
        String nomPromu = sc.nextLine();
        bdd.promotion(nomPromu);

        // fermer la connexion
        bdd.close();
    }

    /**
     * Remplir la bdd avec 8 employés
     */
    private static void peupleBdd(MySQL bdd) {
        for (int i = 1; i < 9; i++) {
            int cat = 4;
            int sal = 8000;
            if (i<7) {
                cat=3;
                sal = 6000;
            }
            if (i<5) {
                cat=2;
                sal = 4000;
            }
            if (i<3) {
                cat=1;
                sal = 2000;
            }
            bdd.add("Nom"+i, cat, sal);
        }
    }
}