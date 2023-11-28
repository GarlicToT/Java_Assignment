/*hurtCharacter(GameCharacter character) removes 20 health points if the character did not defend 
successfully (i.e., when character. successfulDefence() returns false).
successfulDefence() returns likelihood that the player manages to defend itself. Outcome is 
chosen randomly, and there is 30% chance of successful defence. */

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
