public class Mage extends Character
{
	public Mage ()
	{
		int con = 6 + diceRoll(6);
		int ability = diceRoll(6);
		initStat("HP", con);
		initStat("MP", 2);
		initStat("Dice", 6);	
		initStat("Ability Power", ability); //attack
		initStat("Search", 1);
	}
	
	public String type()
	{
		return "Mage";
	}
	
	public String status()
	{
		String str = "Type: " + type();
		str += "\n" + formatStat("Lvl");
		str += "\n" + formatStat("HP");
		str += "\n" + formatStat("MP");
		str += "\n" + formatStat("Ability Power");
		str += "\n" + formatStat("Search");
		return str;
	}
	
	
}