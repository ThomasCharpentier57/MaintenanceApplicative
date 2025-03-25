package mycalendar.calendarManager.actions.affichage;

import mycalendar.event.Event;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class AffichageParMois extends ActionAffichage {
    private Scanner scanner;

    public AffichageParMois(List<Event> listEvenements) {
        super(listEvenements);
        scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        System.out.print("Entrez l'année (AAAA) : ");
        int anneeMois = scanner.nextInt();
        System.out.print("Entrez le mois (1-12) : ");
        int mois = scanner.nextInt();

        LocalDateTime debutMois = LocalDateTime.of(anneeMois, mois, 1, 0, 0);
        LocalDateTime finMois = debutMois.plusMonths(1).minusSeconds(1);

        afficherEvenements(eventsDansPeriode(debutMois, finMois));
    }

    @Override
    public String toString() {
        return "Afficher les événements d'un MOIS précis";
    }
}
