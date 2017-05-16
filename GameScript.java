import java.util.*;
public abstract class GameScript {
	
	/* Innate game characteristics */
	Character player;
	final Scanner s;
	final PrintStream out;
	
	/* Standard variables */
	public final String STATS = "S";
	public final String QUIT = "Q";
	public final charFile = "characters.txt";
	
	public GameScript() {
		s = new Scanner(System.in);
		out = System.out;
		selectChar();
	}
	
	/* main gameplay loop */
	public abstract String prompt();
	public abstract String state();
	
	/* returns true if survives, false if dies */
	public Status game() {
		while (true) {
			System.out.println(prompt());
			String res = s.nextLine();
			if (res.equals(STATS)) {
				out.println(state());
			} else if (res.equals(QUIT)) {
				return Status.QUIT;
			} else {
				if (!respond(res))
					return Status.DIE;
			}
		}
		return Status.SURVIVE;
	}
	
	public abstract boolean respond(String str);
	
	public int rand(int a, int b) {
		return (int)(Math.random() * (b - a + 1)) + a;
	}
	
	public int diceRoll(int a) {
		return rand(1, a);
	}
	
	/* lose a level */
	public abstract void die();
}

enum Status {
	SURVIVE, DIE, QUIT;
}