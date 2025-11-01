//Marouane NOUARA
package Exo4;


package Exo4;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Etudiant e1 = new Etudiant(1, "Tran", "Binh Minh", 21, "BDML", 17.0);
        Etudiant e2 = new Etudiant(2, "Dupont", "Alice", 19, "Informatique", 14.5);
        Etudiant e3 = new Etudiant(3, "Martin", "Yassine", 21, "Maths", 13.0);
        Etudiant e4 = new Etudiant(4, "Durand", "Lina", 20, "BDML", 15.8);

        // Groupe
        Groupe g = new Groupe("BDML-1");
        g.ajouterEtudiant(e1);
        g.ajouterEtudiant(e2);
        g.ajouterEtudiant(e3);
        g.ajouterEtudiant(e4);

        // 1) Affichage
        g.afficherEtudiants();

        // 2) Tri par âge 
        g.trierParAge();
        System.out.println("\nAprès tri par âge :");
        g.afficherEtudiants();

        // 3) Recherche spécialité par numéro
        String spec = g.rechercherSpecialiteParNumero(3);
        System.out.println("\nSpécialité de l'étudiant n°3 : " + spec);

        // 4) Prénoms des étudiants de 21 ans
        List<String> prenoms21 = g.prenomsParAge(21);
        System.out.println("\nPrénoms des étudiants de 21 ans : " + prenoms21);
    }
}

