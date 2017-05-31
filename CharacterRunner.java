public class CharacterRunner {
	public static void main(String[] args) {
		Cleric c = new Cleric();
		Fighter f = new Fighter();
		Barbarian b = new Barbarian();
		Mage m = new Mage();
		DungeonMaster d = new DungeonMaster();
		
		Character[] arr = {c, f, b, m};
		for (Character ch : arr) {
			ch.takeDamage(1);
			ch.decreaseStat("MP", 3);
			System.out.println(ch.status() + "\n");
		}
		System.out.println(d.status() + "\n");
		
	}
}