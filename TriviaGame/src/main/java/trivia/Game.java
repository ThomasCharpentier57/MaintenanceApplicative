package trivia;

import java.util.ArrayList;
import java.util.Scanner;

public class Game implements IGame {
    public static final int CASES = 12;
    public static final int MINIMUM_PLAYERS = 2;
    public static final int MAXIMUM_PLAYERS = 6;

    ArrayList<Player> players = new ArrayList<>();
    QuestionManager questionManager;
    Player currentPlayer;
    private boolean started = false;


    public Game() {
        questionManager = new QuestionManager();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("*** Welcome to Trivia Game ***\n");
        System.out.println("Enter number of players:"+MINIMUM_PLAYERS+"-"+MAXIMUM_PLAYERS);
        int playerCount = Integer.parseInt(scanner.nextLine());
        if (playerCount < MINIMUM_PLAYERS || playerCount > MAXIMUM_PLAYERS) throw new IllegalArgumentException("No player "+MINIMUM_PLAYERS+".."+MAXIMUM_PLAYERS);
        System.out.println("Reading names for " + playerCount + " players:");

        for (int i = 1; i <= playerCount; i++) {
            System.out.print("Player " + i + " name: ");
            String playerName;
            do {
                playerName = scanner.nextLine();
            } while (!this.add(playerName));

        }

        currentPlayer = players.get(0);

        started = true;
        System.out.println("\n\n--Starting game--");
    }

    public boolean add(String playerName) {
        if(started) {
            System.out.println("Game already started");
            return false;
        }

        Player newPlayer = new Player(playerName);
        if (players.contains(newPlayer)) {
            System.out.println(playerName + " already exists");
            return false;
        }

        players.add(newPlayer);
        System.out.println(playerName + " was added");
        System.out.println("They are player number " + players.size());
        return true;

    }

    public void roll(int roll) {
        System.out.println(currentPlayer + " is the current player");
        System.out.println("They have rolled a " + roll);

        if (currentPlayer.isInPenaltyBox()) {
            boolean isGettingOutOfPenaltyBox = roll % 2 != 0;
            System.out.println(currentPlayer + " is " + (isGettingOutOfPenaltyBox ? "" : "not ") + "getting out of the penalty box");
            if (isGettingOutOfPenaltyBox) {
                currentPlayer.setInPenaltyBox(false);
                movePlayer(roll);
                questionManager.askQuestion(currentPlayer.getPlace());
            }
        } else {
            movePlayer(roll);
            questionManager.askQuestion(currentPlayer.getPlace());
        }
    }

    public void movePlayer(int roll) {
        currentPlayer.setPlace(currentPlayer.getPlace() + roll);
        if (currentPlayer.getPlace() > Game.CASES)
            currentPlayer.setPlace(currentPlayer.getPlace() - Game.CASES);

        System.out.println(currentPlayer.getName()
                + "'s new location is "
                + currentPlayer.getPlace());
    }

    public void nextPlayer() {
        if (players.indexOf(currentPlayer) + 1 == players.size()) {
            currentPlayer = players.get(0);
        } else {
            currentPlayer = players.get(players.indexOf(currentPlayer) + 1);
        }
    }

    public boolean handleCorrectAnswer() {
        if (currentPlayer.isInPenaltyBox()) {
            nextPlayer();
            return false;
        } else {
            return correctAnswer();
        }
    }

    public boolean correctAnswer() {
        System.out.println("Answer was correct!!!!");
        currentPlayer.incrementPurse();
        System.out.println(currentPlayer
                + " now has "
                + currentPlayer.getPurse()
                + " Gold Coins.");

        boolean winner = currentPlayer.didPlayerWin();
        if (!winner) {
            nextPlayer();
        }
        return winner;
    }

    public void handleWrongAnswer() {
        System.out.println("Question was incorrectly answered");
        System.out.println(currentPlayer + " was sent to the penalty box");
        currentPlayer.setInPenaltyBox(true);
        nextPlayer();
    }
}