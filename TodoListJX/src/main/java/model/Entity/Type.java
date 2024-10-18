package model.Entity;

public class Type {
    private int idType;
    private String nom;
    private String code_coulleur;

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCode_coulleur() {
        return code_coulleur;
    }

    public void setCode_coulleur(String code_coulleur) {
        this.code_coulleur = code_coulleur;
    }

    @Override
    public String toString() {
        return "TypeControlleur{" +
                "idType=" + idType +
                ", nom='" + nom + '\'' +
                ", code_coulleur='" + code_coulleur + '\'' +
                '}';
    }
}
