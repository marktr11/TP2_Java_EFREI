package Exo3;

import java.util.ArrayList;
import java.util.Comparator;

public class EtagereV2 {
    private int code; //Un code unique pour identifier l'étagère (entier).
    private String domaine; //Le domaine des livres sur cette étagère (chaîne de caractères).
    private int capacite; //nombre max de livres à mettre dans cette étagère
    private ArrayList<Livre> livres; // Un tableau de livres placés sur cette étagère.
    private int nbLivres;         // compteur interne
    
    // Constructeur
    public EtagereV2(int code, String domaine, int capacite) {
        this.code = code;
        this.domaine = domaine;
        this.capacite = capacite;
        this.livres = new ArrayList<Livre>(capacite);
        this.nbLivres = 0;
    }

    //1) Ajout d’un livre 
    public void ajouterLivre2(Livre livre) {
        livres.add(livre);
        nbLivres++;
        System.out.println("Livre ajouté à l'ÉtagèreV2 : " + livre.getTitre());
    }

    // 2) Suppression d’un livre (par code) 
    
    // Recherche l'indice d'un livre par son code
    // Retourne -1 si aucun livre trouvé
    private int indexOfCode2(int code) {
        for (int i = 0; i < livres.size(); i++) {
            if (livres.get(i) != null && livres.get(i).getCode() == code) { 
                //livres.get(i) est l'objet livre à l'indice i 
                // puis on cherche le code de l'objet livre en utilisant la methode getCode()-getter
                return i;
            }
        }

        return -1;
    }

    public void supprimerLivre2(int code) {
        int idx = indexOfCode2(code);
        if (idx == -1) { 
        System.out.println("Aucun livre avec le code " + code + " trouvé.");
        return;
        }
        livres.remove(idx);
      
        --nbLivres; // on retire le livre à l'indice idx et on decremente le nombre de livres
        // pareil que this.nbLivres = this.nbLivres - 1;
    }

    // 3) Somme des pages 
    public int sommePages2() {
      int somme = 0;
      for (int i = 0; i < nbLivres; i++) {
          somme += livres.get(i).getNbPages(); 
      }
      return somme;
    }

    //4) Recherche par titre 
    public Livre chercherLivreParTitre2(String titre) {
        for (int i = 0; i < nbLivres; i++) {
            if (livres.get(i).getTitre().equalsIgnoreCase(titre)) {
                return livres.get(i);// toString() de l'objet livre 
            }
        }
        System.out.println("Livre au titre \"" + titre + "\" introuvable.");
        return null;
    }

    //5) Petits livres (< seuil pages) 
    
    //Recherche tous les livres ayant un nombre de pages inférieur au seuil donné.
    public ArrayList<Livre> chercherPetitsLivres2(int seuil) {
        // Création d'une ArrayList temporaire pour stocker les résultats
        ArrayList<Livre> res = new ArrayList<>();
        
        // Parcours de tous les livres de l'étagère
        for (int i = 0; i < livres.size(); i++) {
            // Si le livre a moins de pages que le seuil, on l'ajoute à la liste résultat
            if (livres.get(i).getNbPages() < seuil) {
                res.add(livres.get(i)); // On ajoute l'objet livre à la liste res
            }
        }
        
        // Affichage des résultats ou d'un message si aucun livre trouvé
        if (res.isEmpty()) {
            System.out.println("Aucun livre avec moins de " + seuil + " pages.");
        } else {
            System.out.println("Livres avec < " + seuil + " pages :");
            for (Livre l : res) System.out.println("   - " + l);
        }
    
        return res;
    }

    //6) Nouveaux livres (année courante) 
    public void afficherNouveauxLivres2(int anneeActuelle) {
        boolean trouve = false; // Variable pour savoir si on a trouvé au moins un livre
        
        // Parcours de tous les livres de l'étagère
        for (int i = 0; i < livres.size(); i++) {
            // Si le livre a été édité dans l'année recherchée
            if (livres.get(i).getAnneeEdition() == anneeActuelle) {
                // Affiche le titre seulement la première fois qu'on trouve un livre
                if (!trouve) { // le but de cette condition est de ne pas afficher le titre de chaque livre mais seulement une fois.
                    System.out.println("Livres édités en " + anneeActuelle + " :");
                    trouve = true; // On marque qu'on a trouvé au moins un livre
                }
                // Affiche les informations du livre trouvé
                System.out.println("   - " + livres.get(i).getTitre() + " (code " + livres.get(i).getCode() + ")");
            }
        }
        
        // Si aucun livre n'a été trouvé, on affiche un message approprié
        if (!trouve) {
            System.out.println("Aucun livre édité en " + anneeActuelle + ".");
        }
    }

    //7) Changer nb de pages d’un livre (par code) 
    public void changerNbPages2(int code, int nbPages) {
        int idx = indexOfCode2(code);
        if (idx == -1) {
            System.out.println("Livre code " + code + " introuvable.");
            return;
        }
        livres.get(idx).setNbPages(nbPages);
    }

    //8) Affichage de tous les livres 
    public void afficherLivres2() {
        if (nbLivres == 0) {
            System.out.println(" Aucune entrée sur l’étagère.");
            return;
        }
        System.out.println("Étager \"" + domaine + "\" (code " + code + ") — " + nbLivres + " livre(s) :");
        for (int i = 0; i < nbLivres; i++) {
            System.out.println("   - " + livres.get(i));
        }
    }

    //9) Tri 
    /**
     * Trie tous les livres de l'étagère par ordre croissant de nombre de pages.
     */
    public void trierParNombreDePages2() {
        // Tri de l'ArrayList en utilisant un Comparator basé sur le nombre de pages
        // Comparator.comparingInt(Livre::getNbPages) compare les livres par leur nombre de pages
        livres.sort(Comparator.comparingInt(Livre::getNbPages));
    }

    //10) Recherche titres par auteur 
    public String[] chercherTitresParAuteur2(String auteur) {
        ArrayList<String> titres = new ArrayList<>();
        for (int i = 0; i < nbLivres; i++) {
            if (livres.get(i).getAuteur().equalsIgnoreCase(auteur)) {
                titres.add(livres.get(i).getTitre());
            }
        }
        return titres.toArray(new String[0]);
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
