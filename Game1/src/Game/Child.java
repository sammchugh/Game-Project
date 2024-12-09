package Game;

public class Child extends NPC{
	public Child(String name, String desc) {
		super("child", "A very pale young girl with dark circles under her eyes.");
	}
	
	int talkCount = 0;
	@Override
	public void talk() {
		if (talkCount == 0) {
			say("Gamer, will you play with me?");
			String[] options = {
					"Okay... what do you want to play?",
					"No, I don't play with strange little girls."			
			};
			getResponse(options);
			talkCount++;
		}
	
		else if (talkCount == 1) {
			say("This is my room and these are my toys, I won't let you take them!");
			String[] options = {
					"I need to take one of your toy to leave this place",
					"I would never take you toys."			
			};
			getResponse(options);
			talkCount++;
		}
		else {
			say("Come find me!");
			talkCount++;
		}
	}
	
	@Override
	public void response(int option) {
		if(talkCount == 0) {
			switch(option) {
				case 1:
					say("Let's play find and seek. I'll hide first");
					Game.print("The girl disappears...");
					break;
				case 2:
					say("I was just trying to be nice. Now you'll pay the price.");
					break;
			}		
		}
		else if (talkCount == 1) {
			switch(option) {
			case 1:
				say("I will not let you take them from me.");
				Game.print("The girl lunges at you. You manage to run away.");
				Game.print("You are now in the Living Room again :(");
				Game.currentRoom = Game.currentRoom.getExit('s').getExit('d');
				
				break;
			case 2:
				say("I'll be watching you...");
				Game.print("Ghost girl goes to brush her doll's hair.");
				break;
			}
		}
	}
}
