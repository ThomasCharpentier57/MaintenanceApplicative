package mycalendar.event;

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
        if(this.id != null){
            this.id = eventId;
        } else {
            System.out.println("Cette évènement possède déjà un ID");
        }
    }

    public LocalDateTime getDateDebut() {
        return this.dateDebut;
    }

    @Override
    public String toString() {
        return "ID : "+this.getId().getId();
    }
}
