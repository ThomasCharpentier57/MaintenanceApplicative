package mycalendar.calendarManager;

import mycalendar.event.Event;
import mycalendar.event.periodique.Periodique;
import mycalendar.utilisateur.Utilisateur;

import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class AffichageEvenementManager {
    List<Event> tousLesEvenements;
    private Scanner scanner;

    public AffichageEvenementManager(List<Event> listEvenements) {
        scanner = new Scanner(System.in);
        this.tousLesEvenements = listEvenements;
    }

    public void start(Utilisateur utilisateur) {
        System.out.println("\n=== Menu de visualisation d'Événements ===");
        System.out.println("1 - Afficher TOUS les événements");
        System.out.println("2 - Afficher les événements d'un MOIS précis");
        System.out.println("3 - Afficher les événements d'une SEMAINE précise");
        System.out.println("4 - Afficher les événements d'un JOUR précis");
        System.out.println("5 - Retour");
        System.out.print("Votre choix : ");

        String choix = scanner.nextLine();

        switch (choix) {
            case "1":
                afficherEvenements(tousLesEvenements);
                break;
            case "2":
                afficherEventMoisPrecis();
                break;
            case "3":
                afficherEventSemainePrecis();
                break;
            case "4":
                afficherEventJourPrecis();
                break;
            case "5":
                break;
            default:
                System.out.println("Erreur : Le choix doit être compris entre 1 et 5.");
        }
        System.out.println("Retour au menu principal");

    }

    private void afficherEvenements(List<Event> listEvent) {
        if(listEvent.isEmpty()){
            System.out.println("Aucun événements");
        } else {
            System.out.println("Liste des évènements");
            for (Event event : listEvent) {
                System.out.println("- "+ event);
            }
        }
    }

    private List<Event> eventsDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        List<Event> result = new ArrayList<>();
        for (Event e : tousLesEvenements) {
            LocalDateTime dateDebut = e.getDateDebut();
            if (e instanceof Periodique) {
                LocalDateTime temp = dateDebut;
                while (temp.isBefore(fin)) {
                    if (!temp.isBefore(debut)) {
                        result.add(e);
                        break;
                    }
                    Periodique eventPeriodique = (Periodique) e;
                    temp = temp.plusDays(eventPeriodique.getFrequenceJour().get());
                }
            } else if (!dateDebut.isBefore(debut) && !dateDebut.isAfter(fin)) {
                result.add(e);
            }
        }
        return result;
    }

    private void afficherEventMoisPrecis(){
        System.out.print("Entrez l'année (AAAA) : ");
        int anneeMois = scanner.nextInt();
        System.out.print("Entrez le mois (1-12) : ");
        int mois = scanner.nextInt();

        LocalDateTime debutMois = LocalDateTime.of(anneeMois, mois, 1, 0, 0);
        LocalDateTime finMois = debutMois.plusMonths(1).minusSeconds(1);

        afficherEvenements(eventsDansPeriode(debutMois, finMois));
    }

    private void afficherEventSemainePrecis(){
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

    private void afficherEventJourPrecis(){
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


}
