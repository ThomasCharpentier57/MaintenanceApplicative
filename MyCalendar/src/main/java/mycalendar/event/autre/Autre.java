package mycalendar.event.autre;

import mycalendar.event.DureeMinutes;
import mycalendar.event.Event;
import mycalendar.event.Titre;
import mycalendar.utilisateur.Utilisateur;

import java.time.LocalDateTime;

public class Autre extends Event {

    public Autre(Titre titre, Utilisateur proprietaire, LocalDateTime dateDebut, DureeMinutes dureeMinutes) {
        super(titre, proprietaire, dateDebut, dureeMinutes);
    }

    @Override
    public String toString() {
        return super.toString()+" Évènement autres : "+titre+", qui aura lieu le "+ dateDebut;
    }
}
