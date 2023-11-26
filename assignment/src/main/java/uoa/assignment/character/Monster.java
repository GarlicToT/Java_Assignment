package uoa.assignment.character;

import java.util.Random;

public class Monster extends GameCharacter {

	public  Monster(String name) {
		super(name);
	}


	public void hurtCharacter(GameCharacter character) {
		if (successfulDefense() == false) {
			character.setHealth(character.getHealth() - 50);
		}
	}

	
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
