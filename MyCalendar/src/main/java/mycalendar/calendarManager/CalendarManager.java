package mycalendar.calendarManager;

import mycalendar.calendarManager.actions.main.ActionPrincipale;
import mycalendar.calendarManager.actions.main.*;
import mycalendar.event.DureeMinutes;
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
    private final List<ActionPrincipale> listActions;
    private final Scanner scanner;
    private Utilisateur utilisateur;
    private StatusConnexion statusConnexion;

    public CalendarManager() {
        listActions = List.of(
                new VoirEvenements(this),
                new AjouterRDVPersonnel(this),
                new AjouterReunion(this),
                new AjouterPeriodique(this),
                new Deconnexion(this)
        );
        listEvenement = new ArrayList<Event>();
        scanner = new Scanner(System.in);
    }

    public void start(Utilisateur utilisateur) {
        this.statusConnexion = StatusConnexion.CONNECTER;
        this.utilisateur = utilisateur;
        System.out.println("Bonjour, " + utilisateur);
        System.out.println("=== Menu Gestionnaire d'Événements ===");
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

    public List<Event> getListEvenement() {
        return listEvenement;
    }

    public void ajouterEvenement(Event event) {
        listEvenement.add(event);
    }

    public StatusConnexion getStatusConnexion() {
        return statusConnexion;
    }

    public void setStatusConnexion(StatusConnexion statusConnexion) {
        this.statusConnexion = statusConnexion;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }
}
