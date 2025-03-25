package mycalendar.calendarManager.actions.affichage;

import mycalendar.event.Event;


import java.util.List;

public class AffichageTousEvenements extends ActionAffichage {


    public AffichageTousEvenements(List<Event> listEvenements) {
        super(listEvenements);
    }

    @Override
    public void execute() {
        afficherEvenements(listEvenements);
    }

    @Override
    public String toString() {
        return "Afficher TOUS les événements";
    }
}
