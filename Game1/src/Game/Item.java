package Game;

public class Item {
	private String name; 
	private String description;

	public Item(String name, String desciption) {
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
	
	
}
