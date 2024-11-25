package Game;

import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.*;

public class Game {

	public static void main(String[] args) {
		textFile();
		runGame();
    }
	
	public static Scanner input = new Scanner(System.in);
	
	public static ArrayList<Item> inventory = new ArrayList<Item>();
	
	public static HashMap<String, String> rooms = new HashMap<String,String>();
	
	public static HashMap<String, Room> roomObjects = new HashMap<String, Room>();
	
	static Room currentRoom = World.buildWorld();
	
	public static void print(Object obj) {
		System.out.println(obj.toString());
	}
	
	public Room getCurrentRoom() {
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
	
	public static void textFile(){
	       try {
	           Scanner input = new Scanner(new File("TextFile.txt"));
	           while(input.hasNextLine()) {
	               String name = input.nextLine();
	               String desc = input.nextLine();

	               if(!name.equals("#") && !desc.equals("#")){
	                   rooms.put(name, desc);
	               }
	           }
	           input.close();
	       } 
	       catch (FileNotFoundException e) {
	           System.out.println("File not found!");
	       } 
	}
	
	public static void saveGame(String fileName) {
		File f = new File(fileName);
		try {
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream stream = new ObjectOutputStream(fos);
			stream.writeObject(inventory);
			stream.writeObject(currentRoom);
			stream.writeObject(roomObjects);
			stream.close();
		} catch (FileNotFoundException e) {
		System.out.println("File "+fileName+" not found.");
		} catch (IOException ex) {
		System.out.println("Bummers, man");
		}
	}
	
	public static void loadGame(String fileName) {
		File f = new File(fileName);
		try {
			FileInputStream fos = new FileInputStream(f);
			ObjectInputStream stream = new ObjectInputStream(fos);
			inventory = (ArrayList) stream.readObject();
			roomObjects = (HashMap) stream.readObject();
			currentRoom = (Room) stream.readObject();
			stream.close();
		} catch (FileNotFoundException e) {
		System.out.println("File "+fileName+" not found.");
		System.exit(0);
		} catch (IOException ex) {
		System.out.println("Bummers, man");
		} catch (ClassNotFoundException ex) {
		System.out.println("Not an object.");
		}
	}
	
	public static void runGame() {
		
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
			case "read":
				System.out.println("You are trying to read the " + words[1] + ".");
				if(currentRoom.getItem(words[1]) != null){
                    currentRoom.getItem(words[1]).read();
                }

                else{

                    if (getItemInventory(words[1]) == null){
                        System.out.println("There is no such item");
                    }

                    else{
                        getItemInventory(words[1]).read();
                        System.out.println();
                    }
                }
			break;
			case "insert":

                System.out.println("You are trying to use the " + words[1] + ".");
                
                if(currentRoom.getItem(words[1]) != null){
                    currentRoom.getItem(words[1]).insert(currentRoom);
                }

                else{

                    if (getItemInventory(words[1]) == null){
                        System.out.println("There is no such item");
                    }

                    else{
                        getItemInventory(words[1]).insert(currentRoom);
                        System.out.println();
                    }
                }
            break;	
			case "crack":
				System.out.println("You are trying to crack the " + words[1] + ".");
				if(currentRoom.getItem(words[1]) != null){
                    currentRoom.getItem(words[1]).crack();
                }

                else{

                    if (getItemInventory(words[1]) == null){
                        System.out.println("There is no such item");
                    }

                    else{
                        getItemInventory(words[1]).crack();
                        System.out.println();
                    }
                }
			break;
			
			case "save":
				saveGame(words[1]);
				break;
				
			case "load":
				loadGame(words[1]);
				break;
				
			case "talk":
				System.out.println("You are trying to talk the " + words[1] + ".");
				if(currentRoom.getNPC(words[1]) != null){
                    currentRoom.getNPC(words[1]).talk();
                }

                else{

                    if (getNPC(words[1]) == null){
                        System.out.println("There is no NPC here");
                    }

                    else{
                        getNPC(words[1]);
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

	private static Object getNPC(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
