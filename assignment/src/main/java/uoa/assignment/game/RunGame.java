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
		
			// Check if the input is "exit"
			if (input.equalsIgnoreCase("exit")) {
				System.out.println("Game Over!");
				gameOver = true;
			} else {
				// Call the nextRound method of class Game
				boolean roundResult = game.nextRound(input);
		
				// Print the layout after each round
				game.getMap().printLayout();
		
				// Check if the game is over
				if (!roundResult) {
					System.out.println("Game Over!");
					gameOver = true;
				}
			}
		
			// Increment the round number
			round++;
		}
		

		scanner.close();
	}

}
