package Exo3;


public class BibliothequeTest {
    public static void main(String[] args) {
        //---------------------------- Tableau ----------------------
        
        //  livres 
        Livre l1 = new Livre("1984", 101, "George Orwell", 328, 1949);
        Livre l2 = new Livre("Le Petit Prince", 102, "Antoine de Saint-Exupéry", 96, 1943);
        Livre l3 = new Livre("Les Misérables", 103, "Victor Hugo", 1488, 1862);
        Livre l4 = new Livre("L'Étranger", 104, "Albert Camus", 185, 1942);

        //  Création d'une étagère
        Etagere etagere = new Etagere(1, "Littérature", 5); 

        //Ajout de livres
        etagere.ajouterLivre(l1);
        etagere.ajouterLivre(l2);
        etagere.ajouterLivre(l3);
        etagere.ajouterLivre(l4);

        // Affichage des livres 
        System.out.println("\nListe des livres sur l’étagère :");
        etagere.afficherLivres();

        // Suppression d’un livre
        System.out.println("\nSuppression du livre avec code 102 :");
        etagere.supprimerLivre(102);
        etagere.afficherLivres();

        //  4) Somme des pages 
        int totalPages = etagere.sommePages();
        System.out.println("\nNombre total de pages : " + totalPages);

        // 5) Recherche par titre 
        System.out.println("\nRecherche du livre '1984' :");
        Livre recherche = etagere.chercherLivreParTitre("1984");
        if (recherche != null) System.out.println("Trouvé → " + recherche);

        //  6) Petits livres (<200 pages - seuil) 
        System.out.println("\nLivres avec moins de 200 pages :");
        etagere.chercherPetitsLivres(200);

        //  7) Nouveaux livres (édition 1949) 
        System.out.println("\n");
        etagere.afficherNouveauxLivres(1949);
        
        // 8) Modifier le nombre de pages d'un livre en fonction de son code.
        etagere.changerNbPages(104, 300);
        // Petits livres (<200 pages - seuil) après modifier le nombre de pages
        System.out.println("\nLivres avec moins de 200 pages :");
        etagere.chercherPetitsLivres(200);
        
        
        
        
        //---------------------------- ArrayList ----------------------
        
    }
}
