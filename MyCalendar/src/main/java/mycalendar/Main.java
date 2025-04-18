package mycalendar;

import mycalendar.calendarManager.CalendarManager;
import mycalendar.utilisateur.ConnexionManager;
import mycalendar.utilisateur.StatusConnexion;


public class    Main {
    public static void main(String[] args) {
        ConnexionManager connexionManager = new ConnexionManager();
        StatusConnexion statusConnexion = StatusConnexion.DECONNECTER;
        CalendarManager calendarManager = new CalendarManager();

        while (true) {

            if (statusConnexion == StatusConnexion.DECONNECTER) {

                System.out.println("  _____         _                   _                __  __");
                System.out.println(" / ____|       | |                 | |              |  \\/  |");
                System.out.println(
                        "| |       __ _ | |  ___  _ __    __| |  __ _  _ __  | \\  / |  __ _  _ __    __ _   __ _   ___  _ __");
                System.out.println(
                        "| |      / _` || | / _ \\| '_ \\  / _` | / _` || '__| | |\\/| | / _` || '_ \\  / _` | / _` | / _ \\| '__|");
                System.out.println(
                        "| |____ | (_| || ||  __/| | | || (_| || (_| || |    | |  | || (_| || | | || (_| || (_| ||  __/| |");
                System.out.println(
                        " \\_____| \\__,_||_| \\___||_| |_| \\__,_| \\__,_||_|    |_|  |_| \\__,_||_| |_| \\__,_| \\__, | \\___||_|");
                System.out.println(
                        "                                                                                   __/ |");
                System.out.println(
                        "                                                                                  |___/");

                statusConnexion = connexionManager.start();
            }

            while (statusConnexion == StatusConnexion.CONNECTER) {
                calendarManager.start(connexionManager.getUtilisateurCourant());
                statusConnexion = calendarManager.getStatusConnexion();
            }
        }
    }
}
