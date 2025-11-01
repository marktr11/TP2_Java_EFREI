package Exo3;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;

public class Etagere {
    // Attributs
    private int code;             // code unique de l’étagère
    private String domaine;       //sujet 
    private int capacite;         // nombre max de livres
    private Livre[] livres;       // tableau des livres placés sur l’étagère
    private int nbLivres;         // compteur interne

    // Constructeur
    public Etagere(int code, String domaine, int capacite) {
        this.code = code;
        this.domaine = domaine;
        this.capacite = capacite;
        this.livres = new Livre[capacite];
        this.nbLivres = 0;
    }

    //1) Ajout d’un livre 
    public void ajouterLivre(Livre livre) {
        livres[nbLivres] = livre;
        nbLivres++;
        System.out.println(" Livre ajouté : " + livre.getTitre());
    }

    // 2) Suppression d’un livre (par code) 
    public void supprimerLivre(int code) {
        int idx = indexOfCode(code);
      if (idx == -1) { 
        System.out.println("Aucun livre avec le code " + code + " trouvé.");
        return;
    }
        
      for (int i = idx; i < nbLivres - 1; i++) {
            livres[i] = livres[i + 1];
        }
        livres[--nbLivres] = null;
    }

    // 3) Somme des pages 
    public int sommePages() {
      int somme = 0;
      for (int i = 0; i < nbLivres; i++) {
          somme += livres[i].getNbPages(); 
      }
      return somme;
    }

    //4) Recherche par titre 
    public Livre chercherLivreParTitre(String titre) {
        for (int i = 0; i < nbLivres; i++) {
            if (livres[i].getTitre().equalsIgnoreCase(titre)) {
                return livres[i];
            }
        }
        System.out.println("Livre au titre \"" + titre + "\" introuvable.");
        return null;
    }

    //5) Petits livres (< seuil pages) 
    public Livre[] chercherPetitsLivres(int seuil) {
        ArrayList<Livre> res = new ArrayList<>();
        for (int i = 0; i < nbLivres; i++) {
            if (livres[i].getNbPages() < seuil) res.add(livres[i]);
        }
        if (res.isEmpty()) {
            System.out.println("Aucun livre avec moins de " + seuil + " pages.");
        } else {
            System.out.println("Livres avec < " + seuil + " pages :");
            for (Livre l : res) System.out.println("   - " + l);
        }
        return res.toArray(new Livre[0]);
    }

    //6) Nouveaux livres (année courante) 
    public void afficherNouveauxLivres(int anneeActuelle) {
        boolean trouve = false;
        for (int i = 0; i < nbLivres; i++) {
            if (livres[i].getAnneeEdition() == anneeActuelle) {
                if (!trouve) {
                    System.out.println("Livres édités en " + anneeActuelle + " :");
                    trouve = true;
                }
                System.out.println("   - " + livres[i].getTitre() + " (code " + livres[i].getCode() + ")");
            }
        }
        if (!trouve) System.out.println("Aucun livre édité en " + anneeActuelle + ".");
    }

    //7) Changer nb de pages d’un livre (par code) 
    public void changerNbPages(int code, int nbPages) {
        int idx = indexOfCode(code);
        if (idx == -1) {
            System.out.println("Livre code " + code + " introuvable.");
            return;
        }
        livres[idx].setNbPages(nbPages);
    }

    //8) Affichage de tous les livres 
    public void afficherLivres() {
        if (nbLivres == 0) {
            System.out.println(" Aucune entrée sur l’étagère.");
            return;
        }
        System.out.println("Étager \"" + domaine + "\" (code " + code + ") — " + nbLivres + " livre(s) :");
        for (int i = 0; i < nbLivres; i++) {
            System.out.println("   - " + livres[i]);
        }
    }

    //9) Tri 

    public void trierParNombreDePages() {
        Arrays.sort(livres, 0, nbLivres, Comparator.comparingInt(Livre::getNbPages));
    }

    //10) Recherche titres par auteur 
    public String[] chercherTitresParAuteur(String auteur) {
        ArrayList<String> titres = new ArrayList<>();
        for (int i = 0; i < nbLivres; i++) {
            if (livres[i].getAuteur().equalsIgnoreCase(auteur)) {
                titres.add(livres[i].getTitre());
            }
        }
        return titres.toArray(new String[0]);
    }


}
