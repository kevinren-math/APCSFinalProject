import java.util.*;
public class CharacterCreation extends GameScript {
	public CharacterCreation() {
		
	}
	
	/* initialize the game */
	public final void selectChar() {
		List<Character> list = Character.loadFromFile(charFile);
		out.println("Enter the number of the character you select:");
		out.println("Type / Start HP / Start MP");
		for (int i = 0; i < list.size(); i++) {
			out.printf("%2d. %s\n", i+1, list.get(i).description());
		}
		int selected = s.nextInt();
		player = list.get(selected-1);
	}
}