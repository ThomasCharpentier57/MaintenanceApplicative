package mycalendar.utilisateur;

public class Nom {
    private String nom;

    public Nom(String name) {
        this.nom = name;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return this.nom;
    }
}
