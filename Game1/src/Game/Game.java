package Game;

import java.util.Scanner;
import java.util.ArrayList;

public class Game {
	public static void main(String[] args) {
		runGame();
    }
	
	static ArrayList<Item> inventory = new ArrayList<Item>();
	
	public static void runGame() {
		Room currentRoom = World.buildWorld();
		Scanner input = new Scanner(System.in);
		
		String command; // player's command
		do {
			System.out.println(currentRoom);
			System.out.print("Where do you want to go? ");
			command = input.nextLine();
			
			String[] words = command.split(" ");
			
			
			switch(words[0]) {
			case "e":
			case "w":
			case "n":
			case "s":
			case "u":
			case "d":
				currentRoom = currentRoom.getExit(command.charAt(0));
				break;
			case "x":
				System.out.println("Thanks for playing my game!");
				break;
			case "take":
				if(currentRoom.getItem(words[1])== null) {
					System.out.println("That item is not here.");
				}
				else {
					inventory.add(currentRoom.getItem(words[1]));
					currentRoom.setItem(words[1], null);
				}
				break;
			case "i":
				if(inventory.size()==0) {
					System.out.println("Inventory is empty");
				}
				else {
					for(Item i: inventory) {
						System.out.println(i);
					}
				}
				break;
			case "look":
		           if(currentRoom.getItem(words[1]) != null){
		               System.out.println(currentRoom.getItem(words[1]).getDescription() + "\n");
		           }


		           else{
		               boolean found = false;

		               for(Item c : inventory){
		                   if(c.getName().equals(words[1])){
		                       System.out.println(c.getDescription() + "\n");
		                       found = true;      
		                   }
		               }

		               if(found == false)
		                   System.out.println("That item is not in this room \n");
		           }
		               
		           break;
			default:
				System.out.println("I don't know what that means.");
			}
		} while(!command.equals("x"));
		
		input.close();
	}
}
