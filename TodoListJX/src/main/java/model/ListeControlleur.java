package model;

public class ListeControlleur {
    private int idListe;
    private String nom;

    public int getIdListe() {
        return idListe;
    }

    public void setIdListe(int idListe) {
        this.idListe = idListe;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "ListeControlleur{" +
                "idListe=" + idListe +
                ", nom='" + nom + '\'' +
                '}';
    }
}