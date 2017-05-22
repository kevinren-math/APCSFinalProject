import java.util.*;
import java.io.*;
public class Character {
	private Map<String, Integer> startTable;
	private Map<String, Integer> table;
	private final int MAXLEVEL = 9;
	
	/* default constructor */
	public Character() {
		startTable = new HashMap<>();
		table = new HashMap<>();
		initStat("Lvl", 1);
	}
	
	public void initStat(String stat, int val) {
		startTable.put(stat, val);
		put(stat, val);
	}
	
	/* returns true if still alive after taking some damage */
	public boolean takeDamage(int damage) {
		if (damage >= get("HP")) {
			put("HP", 0);
			return false;
		} else {
			put("HP", get("HP") - damage);
			return true;
		}
	}
	
	public void restoreHP(int health) {
		int hp = get("HP") + health;
		int startHp = getInit("HP");
		if (hp > startHp)
			hp = startHp;
		put("HP", hp);
	}
	
	/* if able to subtract stat, will do so and returns true
	   otherwise, does not subtract stat and returns false
	*/
	public boolean decreaseStat(String stat, int damage) {
		if (damage > get(stat)) {
			return false;
		} else {
			put(stat, get(stat) - damage);
			return true;
		}
	}
	
	public void increaseStat(String stat, int health) {
		int hp = get(stat) + health;
		int startHp = getInit(stat);
		if (hp > startHp)
			hp = startHp;
		put(stat, hp);
	}
	
	/* get stat */
	public int get(String stat) {
		return table.get(stat);
	}
	
	/* get inital stat */
	public int getInit(String stat) {
		return startTable.get(stat);
	}
	
	/* put stat */
	public void put(String stat, int x) {
		table.put(stat, x);
	}
	
	/* put initial stat */
	public void putInit(String stat, int x) {
		startTable.put(stat, x);
	}
	
	/* This should be overriden by subclasses */
	public String type() {
		return "Character";
	}
	
	public String status() {
		String str = "Type: " + type();
		str += "\n" + formatStat("HP");
		str += "\n" + formatStat("MP");
		for (String s : table.keySet())
			if (!s.equals("MP") && !s.equals("HP"))
				str += "\n" + formatStat(s);
		return str;
	}
	
	public String formatStat(String stat) {
		return String.format("%s: %d/%d", stat, get(stat), getInit(stat));
	}
	
	public String formatLevel() {
		return String.format("%s: %d", "Lvl", get("Lvl"));
	}
	
	public void increaseXP(int xp) {
		int totXP = get("XP") + xp;
		int startXP = getInit("XP");
		int level = get("Lvl");
		while (totXP >= startXP && level < MAXLEVEL) { //Level up
			totXP -= startXP;
			startXP++;
			level++;
		}
		put("XP", totXP);
		putInit("XP", startXP);
		put("Lvl", level);
	}
	
	//set MP to full amount
	public void resetMP() {
		put("MP", getInit("MP"));
	}
	
	public static List<Character> loadFromFile(String name) {
		//Format: startHP startMP type
		try {
			BufferedReader br = new BufferedReader(new FileReader(name));
			String str;
			List<Character> list = new ArrayList<>();
			StringTokenizer st;
			while ((str = br.readLine()) != null) {
				st = new StringTokenizer(str);
				String type = st.nextToken();
				//int hp = Integer.parseInt(st.nextToken());
				//int mp = Integer.parseInt(st.nextToken());
				if (type.equals("Cleric"))
					list.add(new Cleric());
				else if (type.equals("Mage"))
					list.add(new Mage());
				else if (type.equals("Fighter"))
					list.add(new Fighter());
				else if (type.equals("Barbarian"))
					list.add(new Barbarian());
				else
					System.err.println("Unrecognized type " + type);
			}
			return list;
		} catch (IOException ex) {
			System.err.println("Cannot load file " + name + ".");
		}
		return null;
	}
	
	/* Utility methods */
	public static int rand(int a, int b) {
		return (int)(Math.random() * (b - a + 1)) + a;
	}
	
	public static int diceRoll(int a) {
		return rand(1, a);
	}
}