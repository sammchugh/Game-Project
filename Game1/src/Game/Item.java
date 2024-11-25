package Game;

import java.io.Serializable;

public class Item implements Serializable{
	private String name; 
	private String description;

	public Item(String name, String description) {
		this.name = name;
		this.description = description; 
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDescription(String description) {
		this.description = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String toString() {
		return name;
	}
	
	public void open() {
		Game.print("You can't open that!");
	}
	
	public void use() {
		Game.print("You can't use that!");
	}
	
	public void read() {
		Game.print("You can't read that!");
	}
	
	public void insert(Room lock) {
		Game.print("You can't insert that!");
	}
	
	public void light() {
		Game.print("You can't light that!");
	}
	
	public void crack() {
		Game.print("You can't crack that, you can only crack the cipher");
	}
	
	public void talk() {
		Game.print("You can't talk to that NPC");
	}
}
