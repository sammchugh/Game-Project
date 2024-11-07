package Game;

import java.util.Scanner;
import java.util.ArrayList;

public class Game {
	public static void main(String[] args) {
		runGame();
    }
	static Room currentRoom = World.buildWorld();
	public static ArrayList<Item> inventory = new ArrayList<Item>();
	
	public static void print(Object obj) {
		System.out.println(obj.toString());
	}
	
	public static Room getCurrentRoom() {
        return currentRoom;
    }

	public static Item getItemInventory(String name) {
		for(Item i : inventory) {
			if(i.getName().equals(name)) {
				return i;
			}
		}
		return null;
	}
	
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
				
				Room nextRoom = currentRoom.getExit(command.charAt(0));
				if (nextRoom == null) {
					System.out.println("You can't go that way");
				}
				else if (nextRoom.getLock() == true) {
					System.out.println("This room is locked. You can't enter until you have a key");
				}
				else
					currentRoom = nextRoom;
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
		               boolean ItemHere = true;

		               for(Item z : inventory){
		                   if(z.getName().equals(words[1])){
		                       System.out.println(z.getDescription() + "\n");
		                       ItemHere = true;      
		                   }
		               }

		               if(ItemHere == false)
		                   System.out.println("That item is not in this room \n");
		           }
		    break;
			case "use":

                System.out.println("You are trying to use the " + words[1] + ".");
                
                if(currentRoom.getItem(words[1]) != null){
                    currentRoom.getItem(words[1]).use();
                }

                else{

                    if (getItemInventory(words[1]) == null){
                        System.out.println("There is no such item");
                    }

                    else{
                        getItemInventory(words[1]).use();
                        System.out.println();
                    }
                }
		               
		    break;
			case "open":

                System.out.println("You are trying to use the " + words[1] + ".");
                
                if(currentRoom.getItem(words[1]) != null){
                    currentRoom.getItem(words[1]).open();
                }

                else{

                    if (getItemInventory(words[1]) == null){
                        System.out.println("There is no such item");
                    }

                    else{
                        getItemInventory(words[1]).open();
                        System.out.println();
                    }
                }
            break;
			default:
				System.out.println("I don't know what that means.");
			}
		} while(!command.equals("x"));
		
		input.close();
	}
}
