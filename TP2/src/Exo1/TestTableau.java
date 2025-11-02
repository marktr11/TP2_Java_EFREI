package Exo1;
import java.util.Arrays;
//import java.util.Scanner;


public class TestTableau {
    public static void main(String[] args) {
    
    // Déclarer un tableau contenant les nombre de pages suivantes : 120, 350, 200, 500, 175, 90, 300
    int[] tab = {120, 350, 200, 500, 175, 90, 300};
    
    // Afficher le contenu du tableau
    //    System.out.println("les nombre de pages des livres disponibles dans la bibliothèque de l’EFREI : "+ Arrays.toString(tab));
    System.out.println("Affichage des nombres de pages");
    for (int i = 0; i < tab.length;i++){
        System.out.println("Livre " + (i+1) +": " + tab[i] + " pages");  
    }
    
    //Calculer et afficher la somme totale des pages de tous les livres.
    int somme = 0;
    for (int i = 0; i < tab.length;i++){
        somme += tab[i]; 
    }
    System.out.println("Somme totale des pages: "+somme);
    
    //Trouver et afficher le nombre de pages minimum.
    int min = tab[0];
    for (int i = 0; i < tab.length;i++){
        if (tab[i]<min){
            min = tab[i];
            
        }
    }
    System.out.println("Nombre minimum: "+min);
    
    //Trouver et afficher le nombre de pages moyen.
    double moyen;
    moyen = somme / tab.length;
    System.out.println("Le nombre de pages moyen: "+moyen);
    
    //Trier le tableau (ordre croissant) puis ré-afficher après le trie.
    int [] newTab;
    Arrays.sort(tab);
    System.out.println("\nAffichage des nombres de pages (ordre croissant)");
    for (int i = 0; i < tab.length;i++){
        System.out.println("Livre " + (i+1) +": " + tab[i] + " pages");  
    }

    }   

    
}
