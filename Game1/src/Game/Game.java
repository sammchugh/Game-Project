package Game;

import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.*;
import java.util.Arrays;


public class Game {

	public static void main(String[] args) {
		textFile();
		gui = new Display();
		Game.print(currentRoom);
    }
	
	
	public static Scanner input = new Scanner(System.in);
	
	public static ArrayList<Item> inventory = new ArrayList<Item>();
	
	public static HashMap<String, String> rooms = new HashMap<String,String>();
	
	public static HashMap<String, Room> roomObjects = new HashMap<String, Room>();
	
	static Room currentRoom = World.buildWorld();
	
	private static Display gui = new Display();
	
	public static void print(Object obj) {
		gui.textArea.append(obj.toString()+"\n");
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
	           Game.print("File not found!");
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
	
	public static void processCommand(String command) {
			
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
					Game.print("You can't go that way");
				}
				else if (nextRoom.getLock() == true) {
					Game.print("This room is locked. You can't enter until you have a key");
				}
				else {
					currentRoom = nextRoom;
					Game.print(currentRoom);	
				}
				break;
				
			case "x":
				Game.print("Thanks for playing my game!");
				break;
			case "take":
				if(currentRoom.getItem(words[1])== null) {
					Game.print("That item is not here.");
				}
				else {
					inventory.add(currentRoom.getItem(words[1]));
					currentRoom.setItem(words[1], null);
				}
				break;
			case "i":
				if(inventory.size()==0) {
					Game.print("Inventory is empty");
				}
				else {
					for(Item i: inventory) {
						Game.print(i);
					}
				}
				break;
			case "look":
		           if(currentRoom.getItem(words[1]) != null){
		               Game.print(currentRoom.getItem(words[1]).getDescription() + "\n");
		           }


		           else{
		               boolean ItemHere = true;

		               for(Item z : inventory){
		                   if(z.getName().equals(words[1])){
		                       Game.print(z.getDescription() + "\n");
		                       ItemHere = true;      
		                   }
		               }

		               if(ItemHere == false)
		                   Game.print("That item is not in this room \n");
		           }
		    break;
			case "use":

                Game.print("You are trying to use the " + words[1] + ".");
                
                if(currentRoom.getItem(words[1]) != null){
                    currentRoom.getItem(words[1]).use();
                }

                else{

                    if (getItemInventory(words[1]) == null){
                        Game.print("There is no such item");
                    }

                    else{
                        getItemInventory(words[1]).use();
                        Game.print("\n");
                    }
                }
		               
		    break;
			case "open":

                Game.print("You are trying to use the " + words[1] + ".");
                
                if(currentRoom.getItem(words[1]) != null){
                    currentRoom.getItem(words[1]).open();
                }

                else{

                    if (getItemInventory(words[1]) == null){
                        Game.print("There is no such item");
                    }

                    else{
                        getItemInventory(words[1]).open();
                        Game.print("\n");
                    }
                }
            break;
			case "read":
				Game.print("You are trying to read the " + words[1] + ".");
				if(currentRoom.getItem(words[1]) != null){
                    currentRoom.getItem(words[1]).read();
                }

                else{

                    if (getItemInventory(words[1]) == null){
                        Game.print("There is no such item");
                    }

                    else{
                        getItemInventory(words[1]).read();
                        Game.print("\n");
                    }
                }
			break;
			case "insert":

                Game.print("You are trying to use the " + words[1] + ".");
                
                if(currentRoom.getItem(words[1]) != null){
                    currentRoom.getItem(words[1]).insert(currentRoom);
                }

                else{

                    if (getItemInventory(words[1]) == null){
                        Game.print("There is no such item");
                    }

                    else{
                        getItemInventory(words[1]).insert(currentRoom);
                        Game.print("\n");
                    }
                }
            break;	
			case "crack":
			    if (currentRoom.getItem(words[1]) != null) {
			        currentRoom.getItem(words[1]).crack();
			    } else {
			        if (getItemInventory(words[1]) == null) {
			            Game.print("There is no such item");
			        } else {
			            getItemInventory(words[1]).crack();
			            Game.print("\n");
			        }
			    }
			    break;
			
			case "escape":
				Game.print("You are trying to preform the ritual.");
				if(currentRoom.getRoomName() == "Basement") {
					if(getItemInventory("toy") != null && getItemInventory("candle") != null && getItemInventory("cipher") != null) {
						currentRoom.getExit('s').getExit('d').getExit('s').setLock(false);
						Game.print("You won the game! You can now leave the house to freedom!");
					}
				}
				else 
					Game.print("You can not preform the banishment ritual to leave yet");
					
			break;
			
			case "save":
				saveGame(words[1]);
				break;
				
			case "load":
				loadGame(words[1]);
				break;
				
			case "talk":
				Game.print("You are trying to talk the " + words[1] + ".");
				if(currentRoom.getNPC(words[1]) != null){
                    currentRoom.getNPC(words[1]).talk();
                }

                else{

                    if (getNPC(words[1]) == null){
                        Game.print("There is no NPC here");
                    }

                    else{
                        getNPC(words[1]);
                        Game.print("\n");
                    }
                }
				break;
				
			default:
				Game.print("I don't know what that means.");
			}
	}

	private static Object getNPC(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
