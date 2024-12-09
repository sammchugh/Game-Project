package Game;

public class World {
	// Builds the game world.
    // Returns the room the player starts in.
    public static Room buildWorld() {
        Room livingRoom = new Room("Living Room");
        Room kitchen = new Room("Kitchen");
        Room stairs = new Room("Stairwell");
        Room study = new Room("Study");
        Room nursery = new Room("Nursery");
        Room basement = new Room("Basement");
        Room freedom = new Room("Freedom");
        
        livingRoom.setLock(false);
        kitchen.setLock(false);
        stairs.setLock(false);
        study.setLock(true);
        nursery.setLock(false);
        basement.setLock(false);
        freedom.setLock(true);
        
        
        
        Item toy = new Item("toy", "You will need this toy to stay safe");
        Item book = new Item("book", "You will need this book to know the secrets of each room");
        Item picture = new Item("picture", "This old picture will help you identify the people that used to live in the house");
        
        livingRoom.addExit(kitchen, 'e'); // kitchen to the right of LR
        livingRoom.addExit(study, 'w'); // study to the left of LR
        livingRoom.addExit(stairs, 'u'); // stairs above living room
        livingRoom.addExit(freedom, 's');
        
        kitchen.addExit(basement, 'd'); // basement under K
        kitchen.addExit(livingRoom, 'w'); // LR to the left of K
        
        study.addExit(livingRoom, 'e'); // LR to the right of study
        
        basement.addExit(kitchen, 'u'); // kitchen above basement
        
        stairs.addExit(livingRoom, 'd'); // living room under stairs
        stairs.addExit(nursery, 'n'); // nursery north of stairs
        
        nursery.addExit(stairs, 's'); // stairs south of nursery
        
        study.setItem("book", book);
        nursery.setItem("toy",toy);
        stairs.setItem("picture", picture);
        
        Safe safe = new Safe("safe", "It's an impressive safe!");
        nursery.setItem("safe",safe);
        
        Combination combination = new Combination("1234","This is the combination to the safe. ");
        stairs.setItem("combination",combination);
        
        Key key = new Key("key", "old gold key");
        kitchen.setItem("key", key);
        
        Candle candle = new Candle("candle", "ritual candle, you will be able to send near by spirits back to hell if you light the candle around them.");
        study.setItem("candle", candle);
        
        Cipher cipher = new Cipher("cipher", "You will need to crack the cipher to know how to escape the house");
        stairs.setItem("cipher", cipher);
        
        Newspaper newspaper = new Newspaper("newspaper", "You will need to read the newspaper to know how to escape the house");
        basement.setItem("newspaper", newspaper);
        
        Child child = new Child("child", "A very pale young girl with dark circles under her eyes.");
        nursery.addNPC("child",child);
        
        Butler butler = new Butler("butler", "An old unwell butler");
        livingRoom.addNPC("butler", butler);
        
        return livingRoom;
    }
}
