package uoa.assignment.character;

public abstract class GameCharacter {
    
	private String name ="";
	
	private int health = 100; 
	
	public int row;
	public int column;
	
	// initialize the character with a name
	public GameCharacter (String name) {
		this.name = name;
	}
	
	public abstract void hurtCharacter (GameCharacter character);
	
	public abstract boolean successfulDefense ();
	
	// return the name of the character
	public String sayName() {
		return name;
	}

	// return the health of the character
	public int getHealth() {
		return health;
	}

	// set the health of the character
	public void setHealth(int health) {
		this.health = health;
	}
}

