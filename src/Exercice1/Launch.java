package Exercice1;

public class Launch {

    public static void main(String[] args) {
        // créer la connexion
        MySQL bdd = new MySQL();

        //vide la table
        bdd.vide();

        // ajouter des enregistrements
        //peupleBdd(bdd);

        // lire tous les enregistrements
        bdd.lire();

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
//            String query = "update spr_producto set borrado='"+sal+"'";
//            query += ", usuario_responsable='" + cat + "'";
            bdd.add("Nom"+i, cat, sal);
        }
    }
}