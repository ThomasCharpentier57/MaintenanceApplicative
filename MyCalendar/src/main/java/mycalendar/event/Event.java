package mycalendar.event;

import mycalendar.event.periodique.Periodique;
import mycalendar.utilisateur.Utilisateur;

import java.time.LocalDateTime;

public abstract class Event {
    protected EventId id;
    protected Titre titre;
    protected Utilisateur proprietaire;
    protected LocalDateTime dateDebut;
    protected DureeMinutes dureeMinutes;

    protected Event(Titre titre, Utilisateur proprietaire, LocalDateTime dateDebut, DureeMinutes dureeMinutes) {
        this.titre = titre;
        this.proprietaire = proprietaire;
        this.dateDebut = dateDebut;
        this.dureeMinutes = dureeMinutes;
    }

    public EventId getId() {
        return id;
    }

    public void setId(EventId eventId) {
        if (this.id != null) {
            this.id = eventId;
        } else {
            System.out.println("Cette évènement possède déjà un ID");
        }
    }

    public LocalDateTime getDateDebut() {
        return this.dateDebut;
    }

    public DureeMinutes getDureeMinutes() {
        return dureeMinutes;
    }

    @Override
    public String toString() {
        return "ID : " + this.getId().getId();
    }

    public static boolean conflit(Event event1, Event event2) {
        LocalDateTime fin1 = event1.dateDebut.plusMinutes(event1.dureeMinutes.getMinutes());
        LocalDateTime fin2 = event2.dateDebut.plusMinutes(event2.dureeMinutes.getMinutes());

        if (event1 instanceof Periodique || event2 instanceof Periodique) {
            return false;
        }

        if (event1.dateDebut.isBefore(fin2) && fin1.isAfter(event2.dateDebut)) {
            return true;
        }
        return false;

    }
}
