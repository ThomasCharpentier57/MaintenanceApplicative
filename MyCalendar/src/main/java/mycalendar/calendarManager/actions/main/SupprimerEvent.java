package mycalendar.calendarManager.actions.main;

import mycalendar.calendarManager.CalendarManager;
import mycalendar.event.EventId;
import mycalendar.event.Titre;

import java.util.Scanner;

public class SupprimerEvent extends ActionPrincipale{
    private Scanner scanner;


    public SupprimerEvent(CalendarManager calendarManager) {
        super(calendarManager);
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        System.out.println("Supprimer un event");
        System.out.print("Entrer le numéro de l'évènement");
        EventId eventId = new EventId(scanner.nextInt());
        calendarManager.supprimerEvenement(eventId);
    }
}
