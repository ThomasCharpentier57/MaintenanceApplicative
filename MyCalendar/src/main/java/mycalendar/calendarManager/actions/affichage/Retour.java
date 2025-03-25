package mycalendar.calendarManager.actions.affichage;

import mycalendar.event.Event;

import java.util.List;

public class Retour extends ActionAffichage {

    public Retour(List<Event> listEvenements) {
        super(listEvenements);
    }

    @Override
    public void execute() {
        System.out.println("Retour au menu principal");
    }

    @Override
    public String toString() {
        return "Retour";
    }
}
