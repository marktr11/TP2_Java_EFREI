package Exo4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Groupe {
    private String nomGroupe;
    private List<Etudiant> etudiants;

    public Groupe(String nomGroupe) {
        this.nomGroupe = nomGroupe;
        this.etudiants = new ArrayList<>();
    }

    // ajouter un étudiant au groupe
    public void ajouterEtudiant(Etudiant e) {
        if (e == null) {
            System.out.println("Étudiant null, non ajouté.");
            return;
        }
        etudiants.add(e);
    }

    // 1) Affichage des étudiants 
    public void afficherEtudiants() {
        if (etudiants.isEmpty()) {
            System.out.println("Aucun étudiant dans le groupe " + nomGroupe + ".");
            return;
        }
        System.out.println("Groupe " + nomGroupe + " (" + etudiants.size() + " étudiant(s)) :");
        for (Etudiant e : etudiants) {
            System.out.println(" - " + e);  // appelle e.toString()
        }
    }

    // 2) Trier par âge (du plus jeune au plus âgé)
    public void trierParAge() {
        Collections.sort(etudiants, Comparator.comparingInt(Etudiant::getAge));
    }

    // 3) Rechercher par spécialité (via numéro d'étudiant)
    //    Retourne la spécialité si trouvé, sinon null et message
    public String rechercherSpecialiteParNumero(int numEtudiant) {
        for (Etudiant e : etudiants) {
            if (e.getNumEtudiant() == numEtudiant) {
                return e.getSpecialite();
            }
        }
        System.out.println("Étudiant n(" + numEtudiant + ") introuvable dans le groupe " + nomGroupe + ".");
        return null;
    }

    // 4) Afficher/retourner les prénoms par âge 
    public List<String> prenomsParAge(int age) {
        List<String> prenoms = new ArrayList<>();
        for (Etudiant e : etudiants) {
            if (e.getAge() == age) {
                prenoms.add(e.getPrenom());
            }
        }
        return prenoms; // peut être vide si aucun étudiant de cet âge
    }

    // getters
    public String getNomGroupe() { return nomGroupe; }
    public List<Etudiant> getEtudiants() { return etudiants; }
}
