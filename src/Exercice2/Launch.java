package Exercice2;

import java.util.ArrayList;

public class Launch {
    public static void main(String[] args) {
        double impotCommune = 0; //montant de l'impot total collecté par la commune

        System.out.println("\nLa commune va percevoir " + impotCommune + " € d'impôts.");
    }
}

//maison indiv:
// SELECT SUM((`surfaceHabitation`*0.35)+(`nbPiece`*15)+(`piscine`*75)) FROM `habitationsIndiv`

//locaux pro:
// SELECT SUM((surfaceLocal*0.35) + ((TRUNCATE((ABS(nbEmploye-1)/10),0)+1) * 150)) FROM `habitationsPro`

//On  compte  150€ supplémentaire par tranche de 10employés (ex : 0 →10 : 150€, 11 →20 : 300€, etc.).

//    protected double calcImpot() {
//        return surfaceHabitation * TAUX_IMPOSITION;
//    }final double TAUX_IMPOSITION = 0.35; // € par m² de surface habitable
//
//  return super.calcImpot() + (nbPiece * 15) + ((piscine ? 1 : 0) * 75);
//    }
//     return super.calcImpot() + nbEmployes/10*150;