package mycalendar.event;

import jdk.jshell.execution.Util;
import mycalendar.Titre;
import mycalendar.utilisateur.Utilisateur;

import java.time.LocalDateTime;

public abstract class EventType {
    protected Titre titre;
    protected Utilisateur proprietaire;
    protected LocalDateTime dateDebut;

    public EventType(Titre titre, Utilisateur proprietaire, LocalDateTime dateDebut) {
        this.titre = titre;
        this.proprietaire = proprietaire;
        this.dateDebut = dateDebut;
    }
}
