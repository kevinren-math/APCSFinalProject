import java.util.*;
import java.io.*;
public class Character {
	private Map<String, Integer> startTable;
	private Map<String, Integer> table;
	
	public Character(int hp, int mp) {
		startTable = new HashMap<>();
		table = new HashMap<>();
		initStat("HP", hp);
		initStat("MP", mp);
	}
	
	public void initStat(String stat, int val) {
		startTable.put(stat, val);
		table.put(stat, val);
	}
	
	/* returns true if still alive after taking some damage */
	public boolean takeDamage(int damage) {
		if (damage >= table.get("HP")) {
			table.put("HP", 0);
			return false;
		} else {
			table.put("HP", table.get("HP") - damage);
			return true;
		}
	}
	
	public void restoreHp(int health) {
		int hp = table.get("HP") + health;
		int startHp = startTable.get("HP");
		if (hp > startHp)
			hp = startHp;
		table.put("HP", hp);
	}
	
	/* if able to subtract stat, will do so and returns true
	   otherwise, does not subtract stat and returns false
	*/
	public boolean decreaseStat(String stat, int damage) {
		if (damage > table.get(stat)) {
			return false;
		} else {
			table.put(stat, table.get(stat) - damage);
			return true;
		}
	}
	
	public void increaseStat(String stat, int health) {
		int hp = table.get(stat) + health;
		int startHp = startTable.get(stat);
		if (hp > startHp)
			hp = startHp;
		table.put(stat, hp);
	}
	
	/* This should be overriden by subclasses */
	public String type() {
		return "Character";
	}
	
	public String status() {
		String str;
		for (String s : table.keySet())
			str += String.format("%s: %d/%d\n", s, table.get(s), startTable.get(s));
		str += "Type: " + type();
		return str;
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
				int hp = Integer.parseInt(st.nextToken());
				int mp = Integer.parseInt(st.nextToken());
				if (type.equals("Cleric"))
					list.add(new Cleric(hp, mp));
				else if (type.equals("Mage"))
					list.add(new Mage(hp, mp));
				else if (type.equals("Fighter"))
					list.add(new Fighter(hp, mp));
				else if (type.equals("Barbarian"))
					list.add(new Barbarian(hp, mp));
				else
					System.err.println("Unrecognized type " + type);
			}
			return list;
		} catch (IOException ex) {
			System.err.println("Cannot load file " + name + ".");
		}
		return null;
	}
}