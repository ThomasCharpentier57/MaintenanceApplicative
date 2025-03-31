package mycalendar.event.rdvPersonnel;

import mycalendar.event.DureeMinutes;
import mycalendar.event.Titre;
import mycalendar.event.Event;
import mycalendar.utilisateur.Utilisateur;

import java.time.LocalDateTime;

public class RdvPersonnel extends Event {

    public RdvPersonnel(Titre titre, Utilisateur proprietaire, LocalDateTime dateDebut, DureeMinutes dureeMinutes) {
        super(titre, proprietaire, dateDebut, dureeMinutes);
    }

    @Override
    public String toString() {
        return super.toString()+" RDV : " + this.titre + " à " + dateDebut.toString();
    }
}
