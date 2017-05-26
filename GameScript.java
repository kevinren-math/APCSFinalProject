import java.util.*;
import java.io.*;
public abstract class GameScript {
	
	/* Innate game characteristics */
	static Character player;
	final Scanner s;
	final PrintStream out;
	
	/* Standard variables */
	public final String STATS = "S";
	public final String QUIT = "Q";
	
	public GameScript() {
		s = new Scanner(System.in);
		out = System.out;
	}
	
	/* main gameplay loop */
	
	/* ask the character what he/she wants to do */
	public abstract void prompt();
	
	/* current state of character (e.g. stats) */
	public void state() {
		out.println(player.status());
	}
	
	/* returns COMPLETE if passes, DIE if dies */
	public Status game() {
		while (true) {
			prompt();
			String res = s.nextLine();
			if (res.equals(STATS)) {
				state();
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
	
	/* respond to selection */
	public abstract Status respond(String str);
	
	/* lose a level */
	public abstract void die();
}

enum Status {
	COMPLETE, SURVIVE, DIE, QUIT;
}