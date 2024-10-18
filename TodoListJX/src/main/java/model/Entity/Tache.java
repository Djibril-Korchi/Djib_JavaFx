package model.Entity;

public class Tache {
    private int idTache;
    private String nom;
    private int etat;
    private int ref_liste;
    private int ref_type;

    public int getIdTache() {
        return idTache;
    }

    public void setIdTache(int idTache) {
        this.idTache = idTache;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public int getRef_liste() {
        return ref_liste;
    }

    public void setRef_liste(int ref_liste) {
        this.ref_liste = ref_liste;
    }

    public int getRef_type() {
        return ref_type;
    }

    public void setRef_type(int ref_type) {
        this.ref_type = ref_type;
    }

    @Override
    public String toString() {
        return "TacheControlleur{" +
                "idTache=" + idTache +
                ", nom='" + nom + '\'' +
                ", etat=" + etat +
                ", ref_liste=" + ref_liste +
                ", ref_type=" + ref_type +
                '}';
    }
}
