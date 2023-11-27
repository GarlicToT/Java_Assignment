package uoa.assignment.character;


/*) Modify the constructor of GameCharacter class so that the field name is populated by the 
parameter value representing name of the character, e.g., new GameCharacter (“Player”). Within 
the GameCharacter class, complete the public method sayName() that returns the name of the 
character as a string */


public abstract class GameCharacter {
    
	private String name ="";
	
	private int health = 100; 
	
	public int row;
	public int column;
	
	//  initialise health to value 100 by default
	public GameCharacter (String name) {
		this.name = name;
	}
	
	public abstract void hurtCharacter (GameCharacter character);
	
	public abstract boolean successfulDefense ();
	
	// return the name of the character
	public String sayName() {
		return name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
}

