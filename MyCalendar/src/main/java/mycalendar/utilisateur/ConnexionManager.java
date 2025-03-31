package mycalendar.utilisateur;

import java.util.List;
import java.util.Scanner;

public class ConnexionManager {
    private Scanner scanner;
    private List<Utilisateur> utilisateurs;
    private Utilisateur utilisateurCourant;

    public ConnexionManager() {
        scanner = new Scanner(System.in);
    }

    public Utilisateur getUtilisateurCourant() {
        return utilisateurCourant;
    }

    public StatusConnexion start(){
        System.out.println("1 - Se connecter");
        System.out.println("2 - Créer un compte");
        System.out.print("Choix : ");

        int choix = scanner.nextInt();
        scanner.nextLine();
        Utilisateur utilisateur = null;
        switch (choix) {
            case 1:
                utilisateur = connexion();
                break;
            case 2:
                utilisateur = inscription();
                break;
            default:
                System.out.println("Erreur : Vous ne pouvez que choisir 1 ou 2.");
        }

        if(utilisateur != null){
            return StatusConnexion.CONNECTER;
        }
        return StatusConnexion.DECONNECTER;
    }

    private Utilisateur connexion(){
        System.out.print("Nom d'utilisateur: ");
        Nom nom = new Nom(scanner.nextLine());
        System.out.print("Mot de passe: ");
        MotDePasse motDePasse = new MotDePasse(scanner.nextLine());

        Utilisateur utilisateur = new Utilisateur(nom, motDePasse);
        if(utilisateurs.contains(utilisateur)){
            return utilisateurs.get(utilisateurs.indexOf(utilisateur));
        }
        return null;
    }

    private Utilisateur inscription(){
        System.out.print("Nom d'utilisateur: ");
        Nom nom = new Nom(scanner.nextLine());
        System.out.print("Mot de passe: ");
        MotDePasse motDePasse = new MotDePasse(scanner.nextLine());
        scanner.nextLine();


        System.out.println("Répéter mot de passe: ");
        MotDePasse motDePasseConfirmer = new MotDePasse(scanner.nextLine());

        if (motDePasse.equals(motDePasseConfirmer)) {
            Utilisateur utilisateur = new Utilisateur(nom, motDePasse);
            utilisateurs.add(utilisateur);
            return utilisateur;
        } else {
            System.out.println("Les 2 mots de passes ne correspondent pas");
            return null;
        }
    }
}
