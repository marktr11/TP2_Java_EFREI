package Exo3;

public class Livre {
    // Attributs
    private String titre;
    private int code;
    private String auteur;
    private int nbPages;
    private int anneeEdition;

    //  Constructeur
    public Livre(String titre, int code, String auteur, int nbPages, int anneeEdition) {
        this.titre = titre;
        this.code = code;
        this.auteur = auteur;
        this.nbPages = nbPages;
        this.anneeEdition = anneeEdition;
    }

    //  Getters et Setters
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public int getNbPages() {
        return nbPages;
    }

    public void setNbPages(int nbPages) {
        this.nbPages = nbPages;
    }

    public int getAnneeEdition() {
        return anneeEdition;
    }

    public void setAnneeEdition(int anneeEdition) {
        this.anneeEdition = anneeEdition;
    }

    //  Méthode toString() pour afficher les infos du livre
    @Override
    public String toString() {
        return "Livre [code=" + code +
               ", titre=" + titre +
               ", auteur=" + auteur +
               ", nbPages=" + nbPages +
               ", anneeEdition=" + anneeEdition + "]";
    }
}
