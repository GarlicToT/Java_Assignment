package uoa.assignment.game;
import java.util.Scanner;

public class RunGame {

	private static boolean gameOver = false;

	public static void main(String[] args) {

		int height = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]); 

        // Instantiate and initialize a Map object for the game
        Game game = new Game(height, width);

        // Print the initial layout to the console
        game.getMap().printLayout();

		int round = 1;

		Scanner scanner = new Scanner(System.in);

        while (!gameOver) {
			// Print the round number to the console
			System.out.println("Round " + round);
			// Print the layout to the console
			System.out.println("Enter a move (up, down, left, right):");
			// Read the input from the console
			String input = scanner.nextLine();
			// Call the nextRound method of class Game
			gameOver = game.nextRound(input);
			// Increment the round number
			round++;
		}
		scanner.close();
	}

}
