package uoa.assignment.character;

import java.util.Random;

public class Monster extends GameCharacter {
	
	public  Monster(String name) {
		super(name);
	}

	// 50% chance of successful defense
	public void hurtCharacter(GameCharacter character) {
		if (successfulDefense() == false) {
			character.setHealth(character.getHealth() - 50);
		}
	}

	// if random number is 0, return false, else return true
	public boolean successfulDefense() {
		if (new Random().nextInt(2) == 0) {
			return false;
		}
		return true;
	}


	
	public String decideMove () {
		
		return "move";
	}

}
