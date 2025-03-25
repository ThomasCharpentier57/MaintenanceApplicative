package mycalendar.calendarManager.actions.main;

import mycalendar.calendarManager.CalendarManager;
import mycalendar.event.DureeMinutes;
import mycalendar.event.Titre;
import mycalendar.event.reunion.Lieu;
import mycalendar.event.reunion.Participant;
import mycalendar.event.reunion.Reunion;
import mycalendar.utilisateur.Nom;
import mycalendar.utilisateur.Utilisateur;

import java.time.LocalDateTime;
import java.util.Scanner;

public class AjouterReunion extends ActionPrincipale {
    private Scanner scanner;
    private Utilisateur proprietaire;

    public AjouterReunion(CalendarManager calendarManager) {
        super(calendarManager);
        this.scanner = new Scanner(System.in);
        this.proprietaire = calendarManager.getUtilisateur();
    }

    @Override
    public void execute() {
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
        System.out.print("Durée en minutes : ");
        int duree = scanner.nextInt();

        LocalDateTime date = LocalDateTime.of(annee, mois, jour, heure, minute);

        System.out.println("Lieu :");
        Lieu lieu = new Lieu(scanner.nextLine());

        Reunion reunion = new Reunion(titre, this.proprietaire, date, new DureeMinutes(duree), lieu);
        reunion.ajouterParicipant(new Participant(this.proprietaire));

        System.out.println("Ajouter un participant ? (oui / non)");
        while (scanner.nextLine().equals("oui"))
        {
            System.out.print("Participants : " + reunion.getParticipants());
            System.out.println("Nom du participant :");
            reunion.ajouterParicipant(new Participant(new Nom(scanner.nextLine())));
            System.out.println("Ajouter un participant ? (oui / non)");
        }

        calendarManager.ajouterEvenement(reunion);
        System.out.println("Événement ajouté.");
    }

    @Override
    public String toString() {
        return "Ajouter une réunion";
    }
}
