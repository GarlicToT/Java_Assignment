package uoa.assignment.game;

import java.util.Scanner;

import uoa.assignment.character.GameCharacter;
import uoa.assignment.character.Player;
import uoa.assignment.character.Monster;

public class GameLogic {

    public static void moveCharacter(String input, Map gameMap, GameCharacter character) {
        // check if the input is a valid direction
        if (input.equals("up") || input.equals("down") || input.equals("left") || input.equals("right")) {
            switch (input) {
                case "up":
                    moveUp(gameMap, character);
                    break;
                case "down":
                    moveDown(gameMap, character);
                    break;
                case "left":
                    moveLeft(gameMap, character);
                    break;
                case "right":
                    moveRight(gameMap, character);
                    break;
            }
        } else {
            System.out.println("Use only keywords up, down, left, right");
        }
    }

    private static void moveUp(Map gameMap, GameCharacter character) {
		String characterSymbol = character instanceof Player ? "*" : "%";
		int row = character.row;
		int column = character.column;
		if (row > 0) {
			gameMap.layout[row][column] = ".";
			character.row = row - 1;
			gameMap.layout[row - 1][column] = characterSymbol;
		}else{
			System.out.println("You can't move up");
		}
    }

    private static void moveDown(Map gameMap, GameCharacter character) {
		String characterSymbol = character instanceof Player ? "*" : "%";
		int row = character.row;
		int column = character.column;
		if (row < gameMap.layout.length - 1) {
			gameMap.layout[row][column] = ".";
			character.row = row + 1;
			gameMap.layout[row + 1][column] = characterSymbol;
		}else{
			System.out.println("You can't move down");
		}
    }

    private static void moveLeft(Map gameMap, GameCharacter character) {
		String characterSymbol = character instanceof Player ? "*" : "%";
		int row = character.row;
		int column = character.column;
		if (column > 0) {
			gameMap.layout[row][column] = ".";
			character.column = column - 1;
			gameMap.layout[row][column - 1] = characterSymbol;
		}else{
			System.out.println("You can't move left");
		}
    } 

    private static void moveRight(Map gameMap, GameCharacter character) {
		String characterSymbol = character instanceof Player ? "*" : "%";
        int row = character.row;
		int column = character.column;
		if (column < gameMap.layout[row].length - 1) {
			gameMap.layout[row][column] = ".";
			character.column = column + 1;
			gameMap.layout[row][column + 1] = characterSymbol;
		}else{
			System.out.println("You can't move right");
		}
    }
}