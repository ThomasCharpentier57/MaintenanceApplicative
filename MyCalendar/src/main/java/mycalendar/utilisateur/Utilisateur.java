package mycalendar.utilisateur;

import java.util.Objects;

public class Utilisateur {
    private Nom nom;
    private MotDePasse motDePasse;

    public Utilisateur(Nom nom, MotDePasse motDePasse) {
        this.nom = nom;
        this.motDePasse = motDePasse;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Utilisateur that = (Utilisateur) o;
        return Objects.equals(nom, that.nom) && Objects.equals(motDePasse, that.motDePasse);
    }

    @Override
    public String toString() {
        return this.nom;
    }
}
