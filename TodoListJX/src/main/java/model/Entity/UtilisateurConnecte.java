package model.Entity;

public final class UtilisateurConnecte extends User {

    private static UtilisateurConnecte INSTANCE;


    private UtilisateurConnecte(User utilisateur) {
        super(utilisateur.getIdUser(), utilisateur.getNom(), utilisateur.getPrenom(), utilisateur.getEmail(), utilisateur.getMdp());
    }


    public static boolean initInstance(User utilisateur) {
        if (INSTANCE == null) {
            INSTANCE = new UtilisateurConnecte(utilisateur);
            return true;
        }
        return false;
    }


    public static UtilisateurConnecte getInstance() {
        return INSTANCE;
    }


    public static boolean clearInstance() {
        if (INSTANCE != null) {
            INSTANCE = null;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "UtilisateurConnecte{" +
                "idUser=" + getIdUser() +
                ", nom='" + getNom() + '\'' +
                ", prenom='" + getPrenom() + '\'' +
                ", email='" + getEmail() + '\'' +
                '}';
    }
}
