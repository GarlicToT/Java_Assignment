/*Modify the variable characters in class Map to hold four objects of type GameCharacter. Modify 
the constructor for the class Map so that it will initialize a 2D array layout based on the input 
parameters (integers height and width) passed to the constructor. Parameter height specifies the 
length of the main array and width specifies the length of the nested arrays (i.e., the result is a 2D 
array that is an array of arrays). 

Within class Map, create a private method initialiseArray() that will populate the 2D array with 
full stop characters ‘.’ every time a new instance of class Map is created. Within the same class,
complete the public method printLayout() that will print the 2D layout array to the console. 
Example output of the printLayout() method, assuming 3x6 2D array:
......
......
......*/

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
        characters[0] = new Player("Player1");
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

        // // Place the characters in the layout
        // for (int i=0; i<characters.length; i++) {
        //     layout[characters[i].row][characters[i].column] = characters[i].sayName();
        // }

        // Place the characters in the layout
        for (int i=0; i<characters.length; i++) {
            if (i==0) {
                layout[characters[i].row][characters[i].column] = "*";
            }
            else {
                layout[characters[i].row][characters[i].column] = "%";
            }
        }

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