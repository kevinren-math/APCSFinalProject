import java.util.*;
public class CharacterCreation extends GameScript {
	//public final String CHAR_FILE = "characters.txt";
	private final List<Character> list;
	
	public CharacterCreation() {
		list = new ArrayList<Character>();
		list.add(new Barbarian());
		list.add(new Cleric());
		list.add(new Fighter());
		list.add(new Mage());
	}
	
	/* initialize the game */
	public void prompt() {
		out.println("Enter the number of the character you select:");
		for (int i = 0; i < list.size(); i++) {
			out.printf("%2d. %s\n", i+1, list.get(i).initStats());
		}
	}
	
	public void state() {
		out.println("First select a character!");
	}
	
	public Status respond(String str) {
		int selected = Integer.parseInt(str) - 1;
		if (0 <= selected && selected < list.size()) {
			player = list.get(selected);
			out.println("You selected " + player.type() + "!");
			return Status.COMPLETE;
		} else {
			out.println("Please enter a number between 1 and " + list.size()
				+ " inclusive.");
			return Status.SURVIVE;
		}
	}
	
	public void die() {}
}