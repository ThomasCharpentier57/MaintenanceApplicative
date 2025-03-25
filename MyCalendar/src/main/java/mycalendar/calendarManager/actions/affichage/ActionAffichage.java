package mycalendar.calendarManager.actions.affichage;

import mycalendar.event.Event;
import mycalendar.event.periodique.Periodique;
import mycalendar.utilisateur.Nom;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class ActionAffichage {
    protected Nom nom;
    protected List<Event> listEvenements;

    public ActionAffichage(List<Event> listEvenements) {
        this.listEvenements = listEvenements;
    }

    public abstract void execute();

    protected void afficherEvenements(List<Event> listEvent) {
        if(listEvent.isEmpty()){
            System.out.println("Aucun événements");
        } else {
            System.out.println("Liste des évènements");
            for (Event event : listEvent) {
                System.out.println("- "+ event);
            }
        }
    }

    protected List<Event> eventsDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        List<Event> result = new ArrayList<>();
        for (Event e : this.listEvenements) {
            LocalDateTime dateDebut = e.getDateDebut();
            if (e instanceof Periodique) {
                LocalDateTime temp = dateDebut;
                while (temp.isBefore(fin)) {
                    if (!temp.isBefore(debut)) {
                        result.add(e);
                        break;
                    }
                    Periodique eventPeriodique = (Periodique) e;
                    temp = temp.plusDays(eventPeriodique.getFrequenceJour().get());
                }
            } else if (!dateDebut.isBefore(debut) && !dateDebut.isAfter(fin)) {
                result.add(e);
            }
        }
        return result;
    }


}

