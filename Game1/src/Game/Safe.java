package Game;

public class Safe extends Item{
	   public Safe(String name, String description){
	       super("safe", "A black safe");
	   }

	   @Override
	   public void open(){

	       if(getItemInventory("combination") == null){
	           Game.print("The safe is locked and you don't have the combination");
	       }

	       else{
	           Game.print("Using the combination, you open the safe and find a diamond inside! Naturally, you pocket the diamond.");
	           Item diamond = new Item("diamond", "A sparkley diamond");
	           inventory.add(diamond);
	       }


	   }
	   
	}

