package mycalendar.calendarManager;

import mycalendar.calendarManager.actions.affichage.*;
import mycalendar.event.Event;
import mycalendar.event.periodique.Periodique;

import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class AffichageEvenementManager {
    private List<ActionAffichage> listActions;
    private List<Event> tousLesEvenements;
    private Scanner scanner;

    public AffichageEvenementManager(List<Event> listEvenements) {
        listActions = List.of(
            new AffichageTousEvenements(listEvenements),
            new AffichageParMois(listEvenements),
            new AffichageParSemaine(listEvenements),
            new AffichageParJour(listEvenements),
            new Retour(listEvenements)
        );
        scanner = new Scanner(System.in);
        this.tousLesEvenements = listEvenements;
    }

    public void start() {
        System.out.println("\n=== Menu de visualisation d'Événements ===");
        for (int i = 0; i < listActions.size(); i++) {
            System.out.println(i+" - "+listActions.get(i));
        }
        System.out.print("Votre choix : ");

        int choix = scanner.nextInt();
        while (choix < 0 || choix >= listActions.size()) {
            System.out.println("Votre choix est introuvable, il doit être contenu entre 0 et "+(listActions.size()-1));
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
        }
        listActions.get(choix).execute();

    }

}
