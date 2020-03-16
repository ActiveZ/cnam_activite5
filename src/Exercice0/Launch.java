package Exercice0;

public class Launch {

    public static void main(String[] args) {
        // crée la connexion
        DemoMySQL dms = new DemoMySQL();
        // ajout un enregistrement
        dms.add("toi");
        // lit tous les enregistrements
        dms.lire();
        // ferme la connexion
        dms.close();
    }
}