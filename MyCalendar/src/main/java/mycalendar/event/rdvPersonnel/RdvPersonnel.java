package mycalendar.event.rdvPersonnel;

import mycalendar.event.Titre;
import mycalendar.event.Event;
import mycalendar.utilisateur.Utilisateur;

import java.time.LocalDateTime;

public class RdvPersonnel extends Event {

    public RdvPersonnel(Titre titre, Utilisateur proprietaire, LocalDateTime dateDebut) {
        super(titre, proprietaire, dateDebut);
    }

    @Override
    public String toString() {
        return "RDV : " + this.titre + " à " + dateDebut.toString();
    }
}
