package Exo4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Groupe {
    private String nomGroupe;       // le nom du groupe d’étudiants (ex: "Groupe A", "Informatique 2")
    private List<Etudiant> etudiants; // la liste contenant tous les objets Etudiant appartenant à ce groupe

    // Constructeur : initialise le nom du groupe et crée une liste vide d’étudiants
    public Groupe(String nomGroupe) {
        this.nomGroupe = nomGroupe;
        this.etudiants = new ArrayList<>(); // au début, aucun étudiant dans le groupe
    }

    // ajouter un étudiant au groupe
    public void ajouterEtudiant(Etudiant e) {
        if (e == null) { // vérifie que l’objet passé n’est pas nul pour éviter les erreurs
            System.out.println("Étudiant null, non ajouté.");
            return; //void
        }
        etudiants.add(e); // ajoute l’étudiant à la liste
    }

    // 1) Affichage des étudiants 
    public void afficherEtudiants() {
        if (etudiants.isEmpty()) { // si la liste est vide, aucun étudiant à afficher
            System.out.println("Aucun étudiant dans le groupe " + nomGroupe + ".");
            return;
        }
        // affiche le nom du groupe et le nombre d’étudiants qu’il contient
        System.out.println("Groupe " + nomGroupe + " (" + etudiants.size() + " étudiant(s)) :");
        // pour chaque étudiant du groupe, on affiche ses informations via toString()
        for (Etudiant e : etudiants) {
            System.out.println(" - " + e);  // appelle e.toString()
        }
    }

    // 2) Trier par âge (du plus jeune au plus âgé)
    public void trierParAge() {
        // Utilise un comparateur pour trier la liste selon l’attribut "age" de chaque étudiant
        // Comparator.comparingInt() permet de comparer des entiers simplement
        Collections.sort(etudiants, Comparator.comparingInt(Etudiant::getAge));
    }

    // 3) Rechercher par spécialité (via numéro d'étudiant)
    //    Retourne la spécialité si trouvé, sinon null et message
    public String rechercherSpecialiteParNumero(int numEtudiant) {
        // Parcourt la liste des étudiants et cherche celui dont le numéro correspond
        for (Etudiant e : etudiants) {
            if (e.getNumEtudiant() == numEtudiant) {
                // si trouvé, on retourne directement sa spécialité
                return e.getSpecialite();
            }
        }
        // Si aucun étudiant n’a ce numéro, on affiche un message d’erreur et retourne null
        System.out.println("Étudiant n(" + numEtudiant + ") introuvable dans le groupe " + nomGroupe + ".");
        return null;
    }

    // 4) Afficher/retourner les prénoms par âge 
    public List<String> prenomsParAge(int age) {
        List<String> prenoms = new ArrayList<>(); // liste pour stocker les prénoms correspondants
        // On parcourt tous les étudiants du groupe
        for (Etudiant e : etudiants) {
            if (e.getAge() == age) { // si l’âge correspond
                prenoms.add(e.getPrenom()); // on ajoute le prénom à la liste
            }
        }
        // retourne la liste des prénoms (peut être vide si aucun étudiant de cet âge)
        return prenoms;
    }

    // getters
    public String getNomGroupe() { return nomGroupe; }
    public List<Etudiant> getEtudiants() { return etudiants; }
    
    // setter ?????? où sont les setters
}
