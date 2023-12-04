package uoa.assignment.character;

import java.util.Random;

public class Monster extends GameCharacter {
	
	public  Monster(String name) {
		super(name);
	}

	// 50% chance of successful defense
	public void hurtCharacter(GameCharacter character) {
		if (!character.successfulDefense()) {
			character.setHealth(character.getHealth()-20);
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


	// The monster moves randomly, with equal probability of moving up, down, left or right
	public String decideMove () {
		Random rand = new Random();
		int randomNum = rand.nextInt(4);
		if (randomNum == 0) {
			return "up";
		}
		else if (randomNum == 1) {
			return "down";
		}
		else if (randomNum == 2) {
			return "left";
		}
		else {
			return "right";
		}
	}
}
