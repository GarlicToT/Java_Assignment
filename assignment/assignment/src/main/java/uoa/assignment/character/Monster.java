package uoa.assignment.character;

import java.util.Random;
import java.util.Scanner;


public class Monster extends GameCharacter {

	private int height;
	private int width;
	
	public Monster(String name) {
		super(name);
	}

	// 50% chance of successful defense
	public void hurtCharacter(GameCharacter character) {
		if (!character.successfulDefense()) {
			character.setHealth(character.getHealth()-20);
			System.out.println("Successful attack!");
		}
	}

	// Make the monster defend itself randomly
	public boolean successfulDefense() {
		Random rand = new Random();
		int randomNum = rand.nextInt(2);
		if (randomNum==0) {
			return false;
		}
		else {
			return true;
		}
	}

    public String decideMove() {
        String[] directions = {"up", "down", "left", "right"};
        Random random = new Random();
        String selectedDirection;

		// 50% chance of moving in a random direction
        {
            selectedDirection = directions[random.nextInt(directions.length)];
        };

        return selectedDirection;
    }

}
