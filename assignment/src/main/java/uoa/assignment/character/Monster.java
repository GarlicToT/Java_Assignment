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

        // 随机选择一个可以移动的方向
        {
            selectedDirection = directions[random.nextInt(directions.length)];
        };

        return selectedDirection;
    }

}
