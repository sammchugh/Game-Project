package Game;

public class Newspaper extends Item{
	public Newspaper(String name, String description){
		super("newspaper", "You will need to read the newspaper to know how to escape the house");
	}
	
	@Override
	public void read(){

		if(Game.getItemInventory("newspaper") == null){
			Game.print("You do not have the cipher to translate!");
	    }

	    else{
	        Game.print("You have successfully read the newspaper!");
	        Game.print("The newspapers says: In order to escape you will need to say 'escape' in the basement holding the toy, candle, and cipher.");
	     }

	}
}
