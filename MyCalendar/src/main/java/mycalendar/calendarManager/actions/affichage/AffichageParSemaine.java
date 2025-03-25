package mycalendar.calendarManager.actions.affichage;

import mycalendar.event.Event;


import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class AffichageParSemaine extends ActionAffichage {
    private Scanner scanner;

    public AffichageParSemaine(List<Event> listEvenements) {
        super(listEvenements);
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        System.out.print("Entrez l'année (AAAA) : ");
        int anneeSemaine = scanner.nextInt();
        System.out.print("Entrez le numéro de semaine (1-52) : ");
        int semaine = scanner.nextInt();

        LocalDateTime debutSemaine = LocalDateTime.now()
                .withYear(anneeSemaine)
                .with(WeekFields.of(Locale.FRANCE).weekOfYear(), semaine)
                .with(WeekFields.of(Locale.FRANCE).dayOfWeek(), 1)
                .withHour(0).withMinute(0);
        LocalDateTime finSemaine = debutSemaine.plusDays(7).minusSeconds(1);


        afficherEvenements(eventsDansPeriode(debutSemaine, finSemaine));
    }


    @Override
    public String toString() {
        return "Afficher les événements d'une SEMAINE précise";
    }
}
