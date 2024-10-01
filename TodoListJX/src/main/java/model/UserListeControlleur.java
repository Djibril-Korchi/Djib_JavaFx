package model;

public class UserListeControlleur {
    private int ref_user;
    private int ref_liste;

    public int getRef_user() {
        return ref_user;
    }

    public void setRef_user(int ref_user) {
        this.ref_user = ref_user;
    }

    public int getRef_liste() {
        return ref_liste;
    }

    public void setRef_liste(int ref_liste) {
        this.ref_liste = ref_liste;
    }

    @Override
    public String toString() {
        return "UserListeControlleur{" +
                "ref_user=" + ref_user +
                ", ref_liste=" + ref_liste +
                '}';
    }
}
