package Game;

import java.util.HashMap;
import java.io.Serializable;

public class Room implements Serializable {
    private Room east; 
    private Room west;
    private Room north;
    private Room south;
    private Room up;
    private Room down;
    private Item i;
    private NPC npc;
    private HashMap<String,Item> item = new HashMap<String,Item>();
    private HashMap<String, NPC> bots = new HashMap<String,NPC>();
    private boolean lock;
    private String name;
    private static final long serialVersionUID = 1L;


    public Room(String n) {
        name = n;
        Game.roomObjects.put(n, this);
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
        String s = this.getDescription(name);
        return s;
    }    
    
    public String getDescription(String n) {
    	for (String s:Game.rooms.keySet()) {		
    		if(s.equals(n)) {
    			return Game.rooms.get(s);
    		}
    	}
    	return null;
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
    
    public boolean getLock() {
    	return lock;
    }
    
    public void setLock(boolean b) {
    	lock = b;
    }
    
    public String getRoomName() {
    	return name;
    }
    
    public void setRoomName(String n) {
    	name = n;
    }
    
    public void addNPC(String name, NPC npc) {
    	bots.put(name, npc);
    }
    
    public NPC getNPC(String name) {
    	return bots.get(name);
    }
    
}
