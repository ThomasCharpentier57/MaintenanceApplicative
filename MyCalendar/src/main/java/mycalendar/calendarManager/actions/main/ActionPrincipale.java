package mycalendar.calendarManager.actions.main;

import mycalendar.calendarManager.CalendarManager;
import mycalendar.utilisateur.Nom;

public abstract class ActionPrincipale {
    protected Nom nom;
    protected CalendarManager calendarManager;

    public ActionPrincipale(CalendarManager calendarManager) {
        this.calendarManager = calendarManager;
    }

    public abstract void execute();

}
