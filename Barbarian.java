public class Barbarian extends Character
{
	int con;
	int armor; 
	public Barbarian ()
	{
		con = 12 + diceRoll(12);
		armor = diceRoll(12); 
		initStat("HP", con);
		initStat("MP", 0);
		initStat("Dice", 6);
		initStat("Armor", armor); //armor
		initStat("Search", 3);
	}

	public String type()
	{
		return "Barbarian";
	}
	
	public int getArmor()
	{
		return armor;
	}
	
	public String status()
	{
		String str = "Type: " + type();
		str += "\n" + formatLevel();
		str += "\n" + formatStat("HP");
		str += "\n" + formatStat("MP");
		str += "\n" + formatSkills("Armor");
		str += "\n" + formatStat("Search");
		return str;
	}
	
}