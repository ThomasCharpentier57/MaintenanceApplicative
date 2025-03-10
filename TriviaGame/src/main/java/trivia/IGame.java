package trivia;

public interface IGame {

	void start()

	boolean add(String playerName);

	void roll(int roll);

	boolean handleCorrectAnswer();

	void handleWrongAnswer();

}