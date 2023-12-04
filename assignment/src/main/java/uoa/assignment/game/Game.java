package uoa.assignment.game;

import uoa.assignment.character.Monster;

public class Game {

    private Map map;
    
    Game (int height, int width) {
        // instantiate and initialise a Map object for the game
        map = new Map(height, width);
    }
    			
    public Map getMap() {
        return map;
    }
    
    public boolean nextRound (String input) {
        return true;
    }
   
}