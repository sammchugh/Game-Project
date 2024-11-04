package Game;

public class World {
	// Builds the game world.
    // Returns the room the player starts in.
    public static Room buildWorld() {
        Room livingRoom = new Room("You are in the Lingering Spirit's Living Room.");
        Room kitchen = new Room("You are in the Butcher's Kitchen.");
        Room stairs = new Room("You are in the Creaking Stairwell");
        Room study = new Room("You are in the Study of Whispers");
        Room nursery = new Room("You are in the Dollmaker's Nursey");
        Room basement = new Room("You are in the Forgotten Screams Basement");
        
        Item candle = new Item("candle", "This candle will be your only light source through the game.");
        Item toy = new Item("toy", "You will need this toy to stay safe");
        Item book = new Item("book", "You will need this book to know the secrets of each room");
        Item newspaper = new Item("newspaper", "This old newspaper contains the secrets to the house");
        Item cipher = new Item("cipher", "You will need to crack the cipher to escape the house");
        Item picture = new Item("picture", "This old picture will help you identify the people that used to live in the house");

        livingRoom.addExit(kitchen, 'e'); // kitchen to the right of LR
        livingRoom.addExit(study, 'w'); // study to the left of LR
        livingRoom.addExit(stairs, 'u'); // stairs above living room
        
        kitchen.addExit(basement, 'd'); // basement under K
        kitchen.addExit(livingRoom, 'w'); // LR to the left of K
        
        study.addExit(livingRoom, 'e'); // LR to the right of study
        
        basement.addExit(kitchen, 'u'); // kitchen above basement
        
        stairs.addExit(livingRoom, 'd'); // living room under stairs
        stairs.addExit(nursery, 'n'); // nursery north of stairs
        
        nursery.addExit(stairs, 's'); // stairs south of nursery
        
        livingRoom.setItem("candle",candle);
        livingRoom.setItem("newspaper", newspaper);
        livingRoom.setItem("cipher", cipher);
        study.setItem("book", book);
        nursery.setItem("toy",toy);
        stairs.setItem("picture", picture);
        
        Safe safe = new Safe("safe", "It's an impressive safe!");
        nursery.setItem("safe",safe);
        
        Combination combination = new Combination("1234","This is the combination to the safe. ");
        stairs.setItem("combination",combination);
        

        
        return livingRoom;
     
    }
}
