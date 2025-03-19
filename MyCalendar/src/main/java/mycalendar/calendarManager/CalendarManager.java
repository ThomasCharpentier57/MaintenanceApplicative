package mycalendar.calendarManager;

import mycalendar.event.Event;
import mycalendar.event.Titre;
import mycalendar.event.periodique.FrequenceJour;
import mycalendar.event.periodique.Periodique;
import mycalendar.event.rdvPersonnel.RdvPersonnel;
import mycalendar.event.reunion.Lieu;
import mycalendar.event.reunion.Participant;
import mycalendar.event.reunion.Reunion;
import mycalendar.utilisateur.Nom;
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
                ajouterEventPeriodique();
                break;
            case "5":
                return deconnexion();
            default:
        }
        return StatusConnexion.CONNECTER;
    }

    private void ajouterEventPeriodique(){
        System.out.print("Titre de l'événement : ");
        Titre titre = new Titre(scanner.nextLine());
        System.out.print("Année (AAAA) : ");
        int annee = scanner.nextInt();
        System.out.print("Mois (1-12) : ");
        int mois = scanner.nextInt();
        System.out.print("Jour (1-31) : ");
        int jour = scanner.nextInt();
        System.out.print("Heure début (0-23) : ");
        int heure = scanner.nextInt();
        System.out.print("Minute début (0-59) : ");
        int minute = scanner.nextInt();

        LocalDateTime date = LocalDateTime.of(annee, mois, jour, heure, minute);

        System.out.print("Frequence (en jours) : ");
        FrequenceJour frequence = new FrequenceJour(scanner.nextInt());
        listEvenement.add(new Periodique(titre, this.utilisateur, date, frequence));

        System.out.println("Événement ajouté.");
    }

    private void ajouterEventRdvPersonnel(){
        System.out.print("Titre de l'événement : ");
        Titre titre = new Titre(scanner.nextLine());
        System.out.print("Année (AAAA) : ");
        int annee = scanner.nextInt();
        System.out.print("Mois (1-12) : ");
        int mois = scanner.nextInt();
        System.out.print("Jour (1-31) : ");
        int jour = scanner.nextInt();
        System.out.print("Heure début (0-23) : ");
        int heure = scanner.nextInt();
        System.out.print("Minute début (0-59) : ");
        int minute = scanner.nextInt();

        LocalDateTime date = LocalDateTime.of(annee, mois, jour, heure, minute);

        listEvenement.add(new RdvPersonnel(titre, this.utilisateur, date));
        System.out.println("Événement ajouté.");
    }

    private void ajouterEventReunion(){
        System.out.print("Titre de l'événement : ");
        Titre titre = new Titre(scanner.nextLine());
        System.out.print("Année (AAAA) : ");
        int annee = scanner.nextInt();
        System.out.print("Mois (1-12) : ");
        int mois = scanner.nextInt();
        System.out.print("Jour (1-31) : ");
        int jour = scanner.nextInt();
        System.out.print("Heure début (0-23) : ");
        int heure = scanner.nextInt();
        System.out.print("Minute début (0-59) : ");
        int minute = scanner.nextInt();

        LocalDateTime date = LocalDateTime.of(annee, mois, jour, heure, minute);

        System.out.println("Lieu :");
        Lieu lieu = new Lieu(scanner.nextLine());

        Reunion reunion = new Reunion(titre, this.utilisateur, date);
        reunion.ajouterParicipant(new Participant(this.utilisateur));

        boolean encore = true;
        System.out.println("Ajouter un participant ? (oui / non)");
        while (scanner.nextLine().equals("oui"))
        {
            System.out.print("Participants : " + reunion.getParticipants());
            System.out.println("Nom du participant :");
            reunion.ajouterParicipant(new Participant(new Nom(scanner.nextLine())));
        }

        listEvenement.add(reunion);
        System.out.println("Événement ajouté.");
    }

    private StatusConnexion deconnexion(){
        System.out.println("Déconnexion ! Voulez-vous continuer ? (O/N)");
        return StatusConnexion.DECONNECTER;
    }
}
