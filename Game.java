import java.util.*;
import java.io.*;

public class Game {
	
	List<GameScript> scripts;
	int curIndex;
	GameScript curScript;
	
	public Game(String file) {
		loadFromFile(file);
	}
	
	public void loadFromFile(file) {
		try {
			
		} catch (IOException) {
			
		}
	}
	
	public void game() {
		while (true) {
			Status st = curScript.game();
			if (st == Status.DIE) {
				curScript.die();
				return;
			} else if (st == Status.QUIT) {
				return;
			} else {
				curIndex++;
				if (curIndex == scripts.size())
					return;
				else
					curScript = scripts.get(curIndex);
			}
		}
	}
}