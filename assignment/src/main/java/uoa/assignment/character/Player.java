package uoa.assignment.character;

import java.util.Random;

public class Player extends GameCharacter{

	public Player(String name) {
		super(name);
	}

	public void hurtCharacter(GameCharacter character) {
		if (!character.successfulDefense()) {
			character.setHealth(character.getHealth()-50);
			System.out.println("Successful attack!");
		}
	}

	// 30% chance of successful defense
	public boolean successfulDefense() {
		Random rand = new Random();
		int randomNum = rand.nextInt(10);
		if (randomNum < 7) {
			return false;
		}
		else {
			return true;
		}
	}
}
