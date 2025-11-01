//Marouane NOUARA
package Exo2;


import java.util.ArrayList;
import java.util.Collections;

public class Bibliotheque{
    public static void main(String[] args) {
        // Déclaration de l'ArrayList et ajout des nombres de pages
        ArrayList<Integer> pages = new ArrayList<>();
        pages.add(120);
        pages.add(230);
        pages.add(500);
        pages.add(75);
        pages.add(150);
        pages.add(200);
        pages.add(300);

        // Affichage du contenu de la liste
        System.out.println("Nombre de pages des livres : " + pages);

        // Calcul et affichage de la somme totale des pages
        int somme = 0;
        for (int p : pages) {
            somme += p;
        }
        System.out.println("Somme totale des pages : " + somme);

        // Trouver et afficher le nombre de pages minimum
        int minPages = Collections.min(pages);
        System.out.println("Nombre de pages minimum : " + minPages);

        // Trier et afficher la liste
        Collections.sort(pages);
        System.out.println("Liste triée des nombres de pages : " + pages);
    }
}

