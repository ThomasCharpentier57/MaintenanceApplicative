package mycalendar.event;

import mycalendar.utilisateur.Utilisateur;

import java.time.LocalDateTime;

public abstract class Event {
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

    public LocalDateTime getDateDebut() {
        return this.dateDebut;
    }
}
