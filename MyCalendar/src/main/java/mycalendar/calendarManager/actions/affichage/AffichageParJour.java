package mycalendar.calendarManager.actions.affichage;

import mycalendar.event.Event;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class AffichageParJour extends ActionAffichage {
    Scanner scanner = new Scanner(System.in);

    public AffichageParJour(List<Event> listEvenements) {
        super(listEvenements);
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        System.out.print("Entrez l'année (AAAA) : ");
        int anneeJour = scanner.nextInt();
        System.out.print("Entrez le mois (1-12) : ");
        int moisJour = scanner.nextInt();
        System.out.print("Entrez le jour (1-31) : ");
        int jour = scanner.nextInt();

        LocalDateTime debutJour = LocalDateTime.of(anneeJour, moisJour, jour, 0, 0);
        LocalDateTime finJour = debutJour.plusDays(1).minusSeconds(1);

        afficherEvenements(eventsDansPeriode(debutJour, finJour));
    }

    @Override
    public String toString() {
        return "Afficher les événements d'un JOUR précis";
    }
}
