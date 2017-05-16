import java.util.*;
import java.io.*;
public class Character {
	private Hashtable<String, Integer> startTable;
	private Hashtable<String, Integer> table;
	
	public Character(int theHp, int theMp, String theType) {
		startHp = theHp;
		hp = theHp;
		startMp = theMp;
		mp = theMp;
		type = theType;
	}
	
	/* returns true if still alive after taking some damage */
	public boolean takeDamage(int damage) {
		if (damage >= hp) {
			hp = 0;
			return false;
		} else {
			hp -= damage;
			return true;
		}
	}
	
	public void restoreHp(int health) {
		hp += health;
		if (hp > startHp)
			hp = startHp;
	}
	
	/* if able to subtract MP, will do so and returns true
	   otherwise, does not subtract MP and returns false
	*/
	public boolean subtractMp(int damage) {
		if (damage > mp) {
			return false;
		} else {
			mp -= damage;
			return true;
		}
	}
	
	public void restoreMp(int health) {
		mp += health;
		if (mp > startMp)
			mp = startMp;
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