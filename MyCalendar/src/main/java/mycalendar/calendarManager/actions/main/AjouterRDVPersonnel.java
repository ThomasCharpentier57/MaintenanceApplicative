package mycalendar.calendarManager.actions.main;

import mycalendar.calendarManager.CalendarManager;
import mycalendar.event.DureeMinutes;
import mycalendar.event.Titre;
import mycalendar.event.rdvPersonnel.RdvPersonnel;
import mycalendar.utilisateur.Utilisateur;

import java.time.LocalDateTime;
import java.util.Scanner;

public class AjouterRDVPersonnel extends ActionPrincipale {
    private Scanner scanner;
    private Utilisateur utilisateur;

    public AjouterRDVPersonnel(CalendarManager calendarManager) {
        super(calendarManager);
        this.scanner = new Scanner(System.in);
        this.utilisateur = calendarManager.getUtilisateur();
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

        RdvPersonnel rdvPersonnel = new RdvPersonnel(titre, this.utilisateur, date, new DureeMinutes(duree));
        calendarManager.ajouterEvenement(rdvPersonnel);
        System.out.println("Événement ajouté.");
    }

    @Override
    public String toString() {
        return "Ajouter un rendez-vous perso";
    }
}
