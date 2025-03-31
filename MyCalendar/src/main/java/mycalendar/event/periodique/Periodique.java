package mycalendar.event.periodique;

import mycalendar.event.DureeMinutes;
import mycalendar.event.Titre;
import mycalendar.event.Event;
import mycalendar.utilisateur.Utilisateur;

import java.time.LocalDateTime;

public class Periodique extends Event {
    private FrequenceJour frequenceJour;

    public Periodique(Titre titre, Utilisateur proprietaire, LocalDateTime dateDebut, DureeMinutes dureeMinutes, FrequenceJour frequenceJour) {
        super(titre, proprietaire, dateDebut, dureeMinutes);
        this.frequenceJour = frequenceJour;
    }

    @Override
    public String toString() {
        return super.toString()+" Événement périodique : " + this.titre + " tous les " + this.frequenceJour;
    }

    public FrequenceJour getFrequenceJour() {
        return frequenceJour;
    }
}
