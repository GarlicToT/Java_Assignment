package uoa.assignment.character;

public abstract class GameCharacter {
    
	private String name ="";
	
	private int health; 
	
	public int row;
	public int column;
	
	//  initialise health to value 100 by default
	public GameCharacter (String name) {
		this.name = name;
		this.health = 100; 
		//complete
	}
	
	public abstract void hurtCharacter (GameCharacter character);
	
	public abstract boolean successfulDefense ();
	
	public String sayName() {
    	return name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
		//complete
	}
}

