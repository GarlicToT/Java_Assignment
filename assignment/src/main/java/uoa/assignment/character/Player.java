package uoa.assignment.character;

import java.util.Random;

public class Player extends GameCharacter{

	public Player(String name) {
		super(name);
	}

	public void hurtCharacter(GameCharacter character) {
		if (!successfulDefense()) {
			character.setHealth(character.getHealth()-20);
		}
	}

	// 30% chance of successful defense
	public boolean successfulDefense() {
		Random rand = new Random();
		int randomNum = rand.nextInt(10);
		if (randomNum < 3) {
			return false;
		}
		else {
			return true;
		}
	}
}
