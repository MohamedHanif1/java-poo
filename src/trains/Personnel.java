
package trains;

public class Personnel {
    private String matricule;
    private String nom;
    private String prenom;

    public Personnel(String matricule, String nom, String prenom) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
    }
    public Personnel(Personnel personnel) {
        this.matricule = personnel.matricule;
        this.nom = personnel.nom;
        this.prenom = personnel.prenom;
    }
    

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
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

    @Override
    public String toString() {
        return "matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom;
    }
    
    
    
}
