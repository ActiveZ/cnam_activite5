package Exercice3;

public class Launch {
    public static void main(String[] args) {
        double impotIndiv, impotPro;
        String sql;


        // créer la connexion
        MySQL bdd = new MySQL();

        // calcul des impôts des habitations individuelles
        sql = "SELECT SUM((`surfaceHabitation`*0.35)+(`nbPiece`*15)+(`piscine`*75)) AS impot FROM `habitationsIndiv`";
        impotIndiv = bdd.calculImpots(sql);
        System.out.println("Impôts perçus sur les habitations individuelles: " + impotIndiv);

        // calculs des impôts des locaux professionnels
        sql = "SELECT SUM((surfaceLocal*0.35) + ((TRUNCATE((ABS(nbEmploye-1)/10),0)+1) * 150)) AS impot FROM `habitationsPro`";
        impotPro = bdd.calculImpots(sql);
        System.out.println("Impôts perçus sur les locaux professionnels: " + impotPro);

        System.out.println("La commune va percevoir " + (impotIndiv + impotPro) + " € d'impôts.");

        // fermer la connexion
        bdd.close();
    }
}
