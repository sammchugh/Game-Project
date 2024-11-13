package Game;

public class Candle extends Item{
	public Candle(String name, String description){
		super("candle", "ritual candle, you will be able to send near by spirits back to hell if you light the candle around them.");
	}
	@Override
	   public void light(){

	       if(Game.getItemInventory("candle") == null){
	           Game.print("You do not have the candle to light");
	       }

	       else{
	           Game.print("You have successfully lit the candle!");
	           Item fire = new Item("fire", "candle flame");
	           Game.inventory.add(fire);
	       }


	   }
}
