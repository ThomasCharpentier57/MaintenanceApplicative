package mycalendar.calendarManager.actions.main;

import mycalendar.calendarManager.CalendarManager;
import mycalendar.utilisateur.StatusConnexion;

public class Deconnexion extends ActionPrincipale {


    public Deconnexion(CalendarManager calendarManager) {
        super(calendarManager);
    }

    @Override
    public void execute() {
        System.out.println("Déconnexion en cours");
        calendarManager.setStatusConnexion(StatusConnexion.DECONNECTER);
    }

    @Override
    public String toString() {
        return "Se déconnecter";
    }
}
