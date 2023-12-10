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
        GameLogic.printMoveMessage(map.characters[0], input);

        // Move the monsters
        for (int i=1; i<map.characters.length; i++) {
            if (map.characters[i] instanceof Monster && map.characters[i].getHealth() > 0) {
                Monster monster = (Monster) map.characters[i];
                String monsterMove = monster.decideMove();
                GameLogic.moveCharacter(monsterMove, map, monster);
                GameLogic.printMoveMessage(monster, monsterMove);
            }
        }

        // Check if the game should end (e.g., player reached a goal, collided with a monster, etc.)
        if (gameOverCondition()) {
            System.out.println("Game Over!");
            return false; // End the game
        }
    
        return true; // Continue to the next round
    }
    
    private boolean gameOverCondition() {
        return map.characters[0].row == 0 && map.characters[0].column == 0;
    }
    
   
}