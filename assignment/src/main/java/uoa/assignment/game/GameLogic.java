package uoa.assignment.game;

import java.util.Scanner;
import java.util.Random;

import uoa.assignment.character.GameCharacter;
import uoa.assignment.character.Player;
import uoa.assignment.character.Monster;

public class GameLogic {

	public static void moveCharacter(String input, Map gameMap, GameCharacter character) {
        // check if the input is a valid direction
        if (input.equals("up") || input.equals("down") || input.equals("left") || input.equals("right")) {
            String selectedDirection = input;

            if (character instanceof Monster) {
                if (hasMonster(gameMap, character, selectedDirection)) {
                    return;
                }
            }
                        
            // Move the character in the valid direction
            switch (selectedDirection) {
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

    private static boolean hasMonster(Map gameMap, GameCharacter character, String direction) {
        int newRow = character.row;
        int newColumn = character.column;

        switch (direction) {
            case "up":
                newRow--;
                break;
            case "down":
                newRow++;
                break;
            case "left":
                newColumn--;
                break;
            case "right":
                newColumn++;
                break;
            default:
                return false;
        }
        // Check if the target position is already occupied by another character
        for (GameCharacter otherCharacter : gameMap.characters) {
            if (otherCharacter != character && otherCharacter.row == newRow && otherCharacter.column == newColumn) {
                if (otherCharacter instanceof Monster) {
                    System.out.println("Monster already there so can't move");
                    return true;
                }
            }
        }
        return false;
    }

    // Add a method to check if the selected direction is valid
    private static boolean isValidDirection(Map gameMap, GameCharacter character, String direction) {
        int newRow = character.row;
        int newColumn = character.column;

        switch (direction) {
            case "up":
                newRow--;
                break;
            case "down":
                newRow++;
                break;
            case "left":
                newColumn--;
                break;
            case "right":
                newColumn++;
                break;
            default:
                return false;
        }

        // Check if the target position is within the boundaries of the map
        if (newRow < 0 || newRow >= gameMap.layout.length || newColumn < 0 || newColumn >= gameMap.layout[newRow].length) {
            return false;
        }

        return true;
    }

    private static void moveUp(Map gameMap, GameCharacter character) {
		String characterSymbol = character instanceof Player ? "*" : "%";
		int row = character.row;
		int column = character.column;
		if (row > 0) {
			gameMap.layout[row][column] = ".";
			character.row = row - 1;
			gameMap.layout[row - 1][column] = characterSymbol;
            printMoveMessage(character, "up");
		}else{
			System.out.println("You can't go up. You lose a move.");
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
            printMoveMessage(character, "down");
		}else{
			System.out.println("You can't go down. You lose a move.");
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
            printMoveMessage(character, "left");
		}else{
			System.out.println("You can't go left. You lose a move.");
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
            printMoveMessage(character, "right");
		}else{
			System.out.println("You can't go right. You lose a move.");
		}
    }

	private static String getCharacterSymbol(GameCharacter character) {
        return character instanceof Player ? "*" : "%";
    }

    public static void printMoveMessage(GameCharacter character, String direction) {
		// if (character instanceof Player) {
		// 	System.out.println("Player is moving " + direction);
		// } else {
			System.out.println(character.sayName() + " is moving " + direction);
		// }
	}	
	
}