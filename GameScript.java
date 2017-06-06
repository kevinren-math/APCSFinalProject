import java.util.*;
import java.io.*;
public abstract class GameScript {
	
	/* Innate game characteristics */
	static final int NUM_PLAYERS = 2;
	static Character[] player;
	final Scanner s;
	final PrintStream out;
	static int turn; //0 is Player 1, 1 is Player 2
	
	/* Standard variables */
	public final String STATS = "S";
	public final String QUIT = "Q";
	
	public GameScript() {
		s = new Scanner(System.in);
		out = System.out;
		turn = 0;
	}
	
	/* main gameplay loop */
	
	/* ask the character what he/she wants to do */
	public void prompt() {
		out.println("Player " + (turn+1) + "'s turn.");
	}
	
	/* current state of character (e.g. stats) */
	public void state() {
		out.println(player[turn].status());
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
				turn = (turn + 1) % NUM_PLAYERS;
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