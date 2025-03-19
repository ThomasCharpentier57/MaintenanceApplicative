package mycalendar.event.reunion;

import mycalendar.utilisateur.Nom;
import mycalendar.utilisateur.Utilisateur;

public class Participant {
    private Nom nom;

    public Participant(Nom nom) {
        this.nom = nom;
    }

    public Participant(Utilisateur utilisateur) {
        this.nom = new Nom(utilisateur.toString());
    }
}
