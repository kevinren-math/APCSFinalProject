import java.util.*;
public abstract class GameScript {
	
	/* Innate game characteristics */
	Character player;
	Scanner s;
	PrintStream out;
	
	/* Standard variables */
	public final String STATS = "S";
	public final String QUIT = "Q";
	public final charFile = "characters.txt";
	
	public GameScript() {
		s = new Scanner(System.in);
		out = System.out;
		selectChar();
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
	
	/* main gameplay loop */
	public abstract String prompt();
	public abstract String state();
	
	public void game() {
		while (true) {
			System.out.println(prompt());
			String res = s.nextLine();
			if (res.equals(STATS)) {
				out.println(state());
			} else if (res.equals(QUIT)) {
				break;
			} else {
				respond(res);
			}
		}
	}
	
	public abstract void respond(String str);
	
	public int rand(int a, int b) {
		return (int)(Math.random() * (b - a + 1)) + a;
	}
	
	/* ending */
	public abstract void end();
}