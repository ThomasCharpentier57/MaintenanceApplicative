package mycalendar.event.reunion;

import mycalendar.event.Titre;
import mycalendar.event.Event;
import mycalendar.utilisateur.Utilisateur;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Reunion extends Event {
    private List<Participant> participants;
    private Lieu lieu;


    public Reunion(Titre titre, Utilisateur proprietaire, LocalDateTime dateDebut) {
        super(titre, proprietaire, dateDebut);
        participants = new ArrayList<Participant>();
    }

    public void ajouterParicipant(Participant p) {
        participants.add(p);
    }

    @Override
    public String toString() {
        return "Réunion : " + this.titre + " à " + this.lieu + " avec " + participants;
    }
}
