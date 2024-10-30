package Game;

import java.util.HashMap;

public class Room {
	private String description;
    private Room east; 
    private Room west;
    private Room north;
    private Room south;
    private Room up;
    private Room down;
    private Item i;
    private HashMap<String,Item> item = new HashMap<String,Item>();

    public Room(String description) {
        this.description = description;
    }    

    public Room getExit(char x) {
        if ( x == 'e' )
            return east;
        if ( x == 'w' )
            return west;
        if (x == 'n')
            return north; 
        if (x == 's')
            return south;
        if (x == 'u')
            return up;
        if (x == 'd')
            return down; 
        return null;
    }

    public void addExit(Room room, char direction) {
        if (direction == 'e')
            east = room;
        
        if (direction == 'w')
            west = room;

        if (direction == 'n') 
            north = room;

        if (direction == 's')
            south = room;

        if (direction == 'u')
            up = room;
        
        if (direction == 'd')
            down = room; 
    }

    public String toString() {
        return description;
    }    
    
    public Item getItem(String name) {
    	return item.get(name);
    }
    
    public void setItem(String name, Item i) {
    	item.put(name,i); 
    }
    
    public void removeItem(String name) {
    	item.remove(name);
    }
}
