package trivia;

import java.util.Random;
import java.util.Scanner;

// DON'T TOUCH THIS CLASS. DON'T REFACTOR THIS CLASS.
// ONLY RUN IT TO MANUALLY PLAY THE GAME YOURSELF TO UNDERSTAND THE PROBLEM
public class PlayGame {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        IGame aGame = new Game();
        aGame.start();


        boolean winner = false;
        do {
            int roll = readRoll();
            aGame.roll(roll);

            System.out.print(">> Was the answer correct? [y/n] ");
            boolean correct = readYesNo();
            if (correct) {
                winner = aGame.handleCorrectAnswer();
            } else {
                aGame.handleWrongAnswer();
            }

        } while (!winner);
        System.out.println(">> Game won!");
    }

    private static boolean readYesNo() {
        String yn = scanner.nextLine().trim().toUpperCase();
        if (!yn.matches("[YN]")) {
            System.err.println("y or n please");
            return readYesNo();
        }
        return yn.equalsIgnoreCase("Y");
    }

    private static int readRoll() {
        System.out.print(">> Throw a die and input roll, or [ENTER] to generate a random roll: ");
        String rollStr = scanner.nextLine().trim();
        if (rollStr.isEmpty()) {
            int roll = new Random().nextInt(6) + 1;
            System.out.println(">> Random roll: " + roll);
            return roll;
        }
        if (!rollStr.matches("\\d+")) {
            System.err.println("Not a number: '" + rollStr + "'");
            return readRoll();
        }
        int roll = Integer.parseInt(rollStr);
        if (roll < 1 || roll > 6) {
            System.err.println("Invalid roll");
            return readRoll();
        }
        return roll;
    }
}
