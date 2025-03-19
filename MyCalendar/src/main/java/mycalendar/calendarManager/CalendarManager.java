package mycalendar.calendarManager;

import mycalendar.event.Event;
import mycalendar.utilisateur.StatusConnexion;
import mycalendar.utilisateur.Utilisateur;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalendarManager {
    private List<Event> listEvenement;
    private Scanner scanner;
    private Utilisateur utilisateur;

    public CalendarManager() {
        listEvenement = new ArrayList<Event>();
        scanner = new Scanner(System.in);
    }

    public StatusConnexion start(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;

        System.out.println("Bonjour, " + utilisateur);
        System.out.println("=== Menu Gestionnaire d'Événements ===");
        System.out.println("1 - Voir les événements");
        System.out.println("2 - Ajouter un rendez-vous perso");
        System.out.println("3 - Ajouter une réunion");
        System.out.println("4 - Ajouter un évènement périodique");
        System.out.println("5 - Se déconnecter");
        System.out.print("Votre choix : ");

        String choix = scanner.nextLine();

        switch (choix) {
            case "1":
                AffichageEvenementManager affichageEvenementManager = new AffichageEvenementManager(listEvenement);
                affichageEvenementManager.start(utilisateur);
                break;
            case "2":
                ajouterEventRdvPersonnel();
                break;
            case "3":
                ajouterEventReunion();
                break;
            case "4":
                ajouterEventReunion();
                break;
            case "5":
                return deconnexion();
            default:
        }
        return StatusConnexion.CONNECTER;
    }

    private void ajouterEventPeriodique(){
        System.out.print("Titre de l'événement : ");
        String titre3 = scanner.nextLine();
        System.out.print("Année (AAAA) : ");
        int annee3 = Integer.parseInt(scanner.nextLine());
        System.out.print("Mois (1-12) : ");
        int moisRdv3 = Integer.parseInt(scanner.nextLine());
        System.out.print("Jour (1-31) : ");
        int jourRdv3 = Integer.parseInt(scanner.nextLine());
        System.out.print("Heure début (0-23) : ");
        int heure3 = Integer.parseInt(scanner.nextLine());
        System.out.print("Minute début (0-59) : ");
        int minute3 = Integer.parseInt(scanner.nextLine());
        System.out.print("Frequence (en jours) : ");
        int frequence = Integer.parseInt(scanner.nextLine());

        listEvenement.add(null);

        System.out.println("Événement ajouté.");
    }

    private void ajouterEventRdvPersonnel(){
        System.out.print("Titre de l'événement : ");
        String titre = scanner.nextLine();
        System.out.print("Année (AAAA) : ");
        int annee = Integer.parseInt(scanner.nextLine());
        System.out.print("Mois (1-12) : ");
        int moisRdv = Integer.parseInt(scanner.nextLine());
        System.out.print("Jour (1-31) : ");
        int jourRdv = Integer.parseInt(scanner.nextLine());
        System.out.print("Heure début (0-23) : ");
        int heure = Integer.parseInt(scanner.nextLine());
        System.out.print("Minute début (0-59) : ");
        int minute = Integer.parseInt(scanner.nextLine());
        System.out.print("Durée (en minutes) : ");
        int duree = Integer.parseInt(scanner.nextLine());

        listEvenement.add(null);
        System.out.println("Événement ajouté.");
    }

    private void ajouterEventReunion(){
        System.out.print("Titre de l'événement : ");
        String titre2 = scanner.nextLine();
        System.out.print("Année (AAAA) : ");
        int annee2 = Integer.parseInt(scanner.nextLine());
        System.out.print("Mois (1-12) : ");
        int moisRdv2 = Integer.parseInt(scanner.nextLine());
        System.out.print("Jour (1-31) : ");
        int jourRdv2 = Integer.parseInt(scanner.nextLine());
        System.out.print("Heure début (0-23) : ");
        int heure2 = Integer.parseInt(scanner.nextLine());
        System.out.print("Minute début (0-59) : ");
        int minute2 = Integer.parseInt(scanner.nextLine());
        System.out.print("Durée (en minutes) : ");
        int duree2 = Integer.parseInt(scanner.nextLine());
        System.out.println("Lieu :");
        String lieu = scanner.nextLine();

        String participants = "";

        boolean encore = true;
        System.out.println("Ajouter un participant ? (oui / non)");
        while (scanner.nextLine().equals("oui"))
        {
            System.out.print("Participants : " + participants);
            participants += ", " + scanner.nextLine();
        }

        listEvenement.add(null);

        System.out.println("Événement ajouté.");
    }

    private StatusConnexion deconnexion(){
        System.out.println("Déconnexion ! Voulez-vous continuer ? (O/N)");
        return StatusConnexion.DECONNECTER;
    }
}
