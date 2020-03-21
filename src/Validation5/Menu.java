package Validation5;

import javax.swing.*;
import java.io.File;
import java.util.Scanner;

public class Menu {
    private String fichierEleve = "";
    private String fichierNote = "";
    private String fichierMatiere = "";
    private Scanner sc = new Scanner(System.in);
    private String ligne = "----------------------------------------------";

    // Acquisition des fichiers CSV de l'utilisateur et vérification validité
    private String acquisitionFichier() {
        System.out.println("Chemin du fichier CSV avec séparateur ';':");

        // Boite de dialogue pour choisir le fichier
        JFileChooser dialogue = new JFileChooser(new File("."));
        File fichier = null;

        if (dialogue.showOpenDialog(null)==
                JFileChooser.APPROVE_OPTION) {
            fichier = dialogue.getSelectedFile();
            return fichier.getPath();
        }
        //else if (dialogue.showOpenDialog(null)==JFileChooser.CANCEL_OPTION) {System.out.println("Annulation" );}
        return ""; // si annulation
    }

    public void menuGeneral() {
        do {
            System.out.println("1: Charger le fichier des élèves" + (fichierEleve.isEmpty() ? "": ": chargé"));
            System.out.println("2: Charger le fichier des notes"+ (fichierNote.isEmpty() ? "": ": chargé"));
            System.out.println("3: Charger le fichier des matières"+ (fichierMatiere.isEmpty() ? "": ": chargé"));
            System.out.println("4: Calcul de la moyenne générale de chaque élève");
            System.out.println("5: Quitter");
            String choix = "";
            do {
                System.out.print("Votre choix: ");
                choix = sc.nextLine();
            } while (!choix.equals("1") && !choix.equals("2") && !choix.equals("3") && !choix.equals("4") && !choix.equals("5"));

            switch (Integer.valueOf(choix)) {
                case 1: // saisie fichier CSV élèves
                    fichierEleve = acquisitionFichier();
                    break;
                case 2: // saisie fichier CSV notes
                    fichierNote = acquisitionFichier();
                    break;
                case 3: // saisie fichier CSV matières
                    fichierMatiere = acquisitionFichier();
                    break;
                case 4: // calcul moyenne
                    if (fichierMatiere.isEmpty() || fichierNote.isEmpty() || fichierEleve.isEmpty()) {
                        System.out.println("ERREUR: Il manque des fichiers" + "\n" + ligne);
                    } else {

                    }
                    break;
                case 5: // fin programme
                    System.exit(0);
                    break;
                default: //erreur inconnue
                    System.exit(1);
                    break;
            }
        } while (true);
    }
}
