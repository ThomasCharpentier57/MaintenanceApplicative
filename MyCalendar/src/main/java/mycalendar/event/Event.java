package mycalendar.event;

import mycalendar.utilisateur.Utilisateur;

import java.time.LocalDateTime;

public abstract class Event {
    protected Titre titre;
    protected Utilisateur proprietaire;
    protected LocalDateTime dateDebut;

    public Event(Titre titre, Utilisateur proprietaire, LocalDateTime dateDebut) {
        this.titre = titre;
        this.proprietaire = proprietaire;
        this.dateDebut = dateDebut;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }
}
