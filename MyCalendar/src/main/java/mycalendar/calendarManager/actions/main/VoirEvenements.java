package mycalendar.calendarManager.actions.main;

import mycalendar.calendarManager.AffichageEvenementManager;
import mycalendar.calendarManager.CalendarManager;

public class VoirEvenements extends ActionPrincipale {


    public VoirEvenements(CalendarManager calendarManager) {
        super(calendarManager);
    }

    @Override
    public void execute() {
        AffichageEvenementManager affichageEvenementManager = new AffichageEvenementManager(calendarManager.getListEvenement());
        affichageEvenementManager.start();
    }

    @Override
    public String toString() {
        return "Voir les événements";
    }
}
