package uoa.assignment.game;

import uoa.assignment.character.GameCharacter;
import uoa.assignment.character.Monster;
import uoa.assignment.character.Player;

public class Map {

    public String [][] layout;
    public GameCharacter characters [] ;

    // populate the 2D array with full stop characters ‘.’
    private void initialiseArray() {
        for (int i=0; i<layout.length; i++) {
            for (int j=0; j<layout[i].length; j++) {
                layout[i][j] = ".";
            }
        }
    }

    Map (int height, int width) {
        // initialize a 2D array layout based on the input parameters
        layout = new String [height][width];
        // populate the 2D array with full stop characters ‘.’
        initialiseArray();
        // initialize the variable characters in class Map to hold four objects of type GameCharacter
        characters = new GameCharacter [4];
        characters[0] = new Player("Player");
        characters[1] = new Monster("Monster1");
        characters[2] = new Monster("Monster2");
        characters[3] = new Monster("Monster3");

        // Set positions in the layout for Player and Monsters
        characters[0].row = height-1;
        characters[0].column = width-1;
        characters[1].row = 0;
        characters[1].column = width-1;
        characters[2].row = height-1;
        characters[2].column = 0;
        characters[3].row = 0;
        characters[3].column = 0;

    // Place the characters in the layout
    for (GameCharacter character : characters) {
        layout[character.row][character.column] = getCharacterSymbol(character);
    }
}

private void setCharacterPosition(GameCharacter character, int row, int column) {
    // Ensure the target position is within the boundaries of the map
    if (row >= 0 && row < layout.length && column >= 0 && column < layout[row].length) {
        character.row = row;
        character.column = column;
    } else {
        // Handle an invalid position (you may choose to throw an exception or take other actions)
        System.out.println("Invalid starting position for character: " + character.sayName());
    }
}

    private String getCharacterSymbol(GameCharacter character) {
        return character instanceof Player ? "*" : "%";
    }

    public void printLayout() {
        for (int i=0; i<layout.length; i++) {
            for (int j=0; j<layout[i].length; j++) {
                System.out.print(layout[i][j]);
            }
            // print a new line after each row
            System.out.println();
        }
    }

}