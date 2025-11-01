package Exo4;


public class Etudiant {
    private int numEtudiant; //un identifiant unique pour l'étudiant (de type entier).
    private String nom; //le nom de l'étudiant (de type chaîne de caractères).
    private String prenom; //le prénom de l'étudiant (de type chaîne de caractères).
    private int age; //l'âge de l'étudiant (de type entier).
    private String specialite; //la spécialité de l'étudiant (de type chaîne de caractères).
    private double moyenne; //la moyenne des notes de l'étudiant (de type décimal)
    
    public Etudiant(){
        this.numEtudiant = 999999;
        this.nom = "Inconnu";
        this.prenom = "Inconnu";
        this.age = 999999;
        this.specialite = "Inconnu";
        this.moyenne = 999999;
    }
    public Etudiant(int numEtudiant, String nom, String prenom, int age, String specialite, double moyenne){
        this.numEtudiant = numEtudiant;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.specialite = specialite;
        this.moyenne = moyenne;
    }
    
    @Override
    public String toString(){
        return this.nom + " " + this.prenom + 
       " (numéro étudiant : " + this.numEtudiant + ") - " +
       this.age + " ans. Étudiant(e) spécialisé(e) en " + 
       this.specialite + ". Moyenne générale : " + this.moyenne;

    }
    
    // getters et setters
    public int getNumEtudiant() {
    return numEtudiant;
    }
    
    public void setNumEtudiant(int numEtudiant) {
        this.numEtudiant = numEtudiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public double getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(double moyenne) {
        this.moyenne = moyenne;
    }

}
