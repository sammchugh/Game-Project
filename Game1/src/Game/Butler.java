package Game;

public class Butler extends NPC {
	public Butler() {
		super("butler", "An old unwell butler");
	}
	
	int talkCount = 0;
	@Override
	public void talk() {
		if (talkCount == 0) {
			say("Greetings, I'm the butler of the Haunted House. Would you like me to introduce you?");
			String[] options = {
					"To the ghosts? no way!",
					"Okay, maybe a brief introduction."			
			};
			getResponse(options);
			talkCount++;
		}
	
		else if (talkCount == 1) {
			say("Will you be staying... for an eternity?");
			String[] options = {
					"No, no, I'm just stopping by",
					"You know what? I kinda like it here"			
			};
			getResponse(options);
			talkCount++;
		}
		else {
			say("Stay for a while");
			talkCount++;
		}
	}
	
	@Override
	public void response(int option) {
		if(talkCount == 0) {
			switch(option) {
				case 1:
					say("That's a shamed they were excited to meet you.");
					break;
				case 2:
					say("Lovely, here we have the Jones Family. Zoe and Zack, the children. Frank and Sue, the parents.");
					Game.print("The butler points to an old picture on the wall.");
					break;
			}		
		}
		else if (talkCount == 1) {
			switch(option) {
			case 1:
				say("Okay, here you'll need this then.");
				Game.print("The butler hands you a lighter");
				Item lighter = new Item("lighter", "a black lighter");
				Game.inventory.add(lighter);
				break;
			case 2:
				say("We're glad to have a new soul here.");
				Game.print("The butler vanishes slowly into this air.");
				break;
			}
		}
	}
}
