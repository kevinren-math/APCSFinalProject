import java.util.*;
import java.io.*;
public class Character {
	private Map<String, Integer> startTable;
	private Map<String, Integer> table;
	
	public Character(int hp, int mp, String type) {
		startTable = new Hashmap<>();
		startTable.put("HP", hp);
		startTable.put("MP", mp);
		table = startTable.clone();
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
	   otherwise, does not subtract MP and returns false
	*/
	public boolean decreaseStat(String stat, int damage) {
		if (damage >= table.get(stat)) {
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
	
	public String status() {
		return String.format("HP: %d/%d\nMP: %d/%d\nType: %s",
				hp, startHp, mp, startMp, type);
	}
	
	public String description() {
		return String.format("%-10s%4d%4d", type, startHp, startMp);
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
				list.add(new Character(hp, mp, type));
			}
			return list;
		} catch (IOException ex) {
			System.err.println("Cannot load file " + name + ".");
		}
		return null;
	}
}