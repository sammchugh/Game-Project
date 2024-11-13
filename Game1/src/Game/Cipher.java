package Game;

public class Cipher extends Item {
	public Cipher(String name, String description){
		super("cipher", "You will need to crack the cipher to know how to escape the house");
	}
	
	@Override
	public void crack(){

		if(Game.getItemInventory("cipher") == null){
			Game.print("You do not have the cipher to translate!");
	    }

	    else{
	        Game.print("You have successfully cracked the cipher!");
	        Game.print("The cipher says: The newspaper holds the answers you're looking for");
	     }

	}
}
