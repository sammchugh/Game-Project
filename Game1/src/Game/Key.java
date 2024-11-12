package Game;

public class Key extends Item{
	public Key(String name, String description){
		super("key", "old gold key");
	}
	
	@Override
	public void insert() {
		Room currentRoom;
		if(currentRoom.getExit('w') == null){
	           Game.print("You don't have the key for this room.");
	    }
		else if(currentRoom.getExit('w').getRoomName().equals("Study")) {
			Game.print("Your key opened the door");
			Game.currentRoom.getExit('w').setLock(false);
		}	
	    else
	           Game.print("This item is not the key to unlock this room");

	}
}
