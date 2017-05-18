import java.util.*;
import java.io.*;
public abstract class GameScript {
	
	/* Innate game characteristics */
	Character player;
	final Scanner s;
	final PrintStream out;
	
	/* Standard variables */
	public final String STATS = "S";
	public final String QUIT = "Q";
	public final String charFile = "characters.txt";
	
	public GameScript() {
		s = new Scanner(System.in);
		out = System.out;
	}
	
	/* main gameplay loop */
	public abstract String prompt(); //ask the character what he/she wants to do
	public abstract String state(); //current state of character (e.g. stats)
	
	/* returns COMPLETE if passes, DIE if dies */
	public Status game() {
		while (true) {
			System.out.println(prompt());
			String res = s.nextLine();
			if (res.equals(STATS)) {
				out.println(state());
			} else if (res.equals(QUIT)) {
				return Status.QUIT;
			} else {
				Status st = respond(res);
				if (st == Status.DIE)
					return Status.DIE;
				else if (st == Status.COMPLETE)
					return Status.COMPLETE;
			}
		}
	}
	
	public abstract Status respond(String str);
	
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
	COMPLETE, SURVIVE, DIE, QUIT;
}