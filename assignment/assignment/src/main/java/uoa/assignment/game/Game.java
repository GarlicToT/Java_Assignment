package uoa.assignment.game;

import uoa.assignment.character.Monster;
import uoa.assignment.character.Player;

public class Game {

    private Map map;
    
    Game (int height, int width) {
        // instantiate and initialise a Map object for the game
        map = new Map(height, width);
    }
    			
    public Map getMap() {
        return map;
    }

    public boolean nextRound(String input) {
        // Handle the input and update the game state
        GameLogic.moveCharacter(input, map, map.characters[0]); // Assuming characters[0] is the player

        // Move the monsters
        for (int i=1; i<map.characters.length; i++) {
            if (map.characters[i] instanceof Monster && map.characters[i].getHealth() > 0) {
                Monster monster = (Monster) map.characters[i];
                String monsterMove = monster.decideMove();
                GameLogic.moveCharacter(monsterMove, map, monster);
                // GameLogic.printMoveMessage(monster, monsterMove);
            }
        }

        // Print each character's health
        System.out.println();
        for (int i=0; i<getMap().characters.length; i++) {
            System.out.println("Health " + getMap().characters[i].sayName() + ":" + getMap().characters[i].getHealth());
        }
        System.out.println();


        // Check if the game should end (e.g., player reached a goal, collided with a monster, etc.)
        if (gameWin()) {
            System.out.println("YOU HAVE WON!");
            return true; // End the game
        }else if (gameLose()) {
            System.out.println("YOU HAVE DIED!");
            return true; // End the game
        } 
    
        return false; // Continue to the next round
    }
    
    private boolean gameWin() {
        // if all monsters are dead, the game is over
        for (int i=1; i<map.characters.length; i++) {
            if (map.characters[i] instanceof Monster && map.characters[i].getHealth() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean gameLose() {
        // if the player is dead, the game is over
        if (map.characters[0].getHealth() <= 0) {
            return true;
        }
        return false;
    }
   
}