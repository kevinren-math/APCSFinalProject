public class Barbarian extends Character
{
	public Barbarian ()
	{
		int con = 12 + diceRoll(12);
		int armor = diceRoll(12); 
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
	
	public String status()
	{
		String str = "Type: " + type();
		str += "\n" + formatLevel();
		str += "\n" + formatStat("HP");
		str += "\n" + formatStat("MP");
		str += "\n" + formatStat("Armor");
		str += "\n" + formatStat("Search");
		return str;
	}
	
}