//import static GameUtility.*;

public class Cleric extends Character
{
	public Cleric ()
	{
		int con = 8 + diceRoll(8);
		int heal = diceRoll(8); 
		initStat("HP", con);
		initStat("MP", 2);
		initStat("Dice", 8);
		initStat("Heal", heal); 
		initStat("Search", 2); //investigates
	}
	
	public String type()
	{
		return "Cleric";
	}
	
	public String status()
	{
		String str = "Type: " + type();
		str += "\n" + "Lvl";
		str += "\n" + formatStat("HP");
		str += "\n" + formatStat("MP");
		str += "\n" + formatStat("Heal");
		str += "\n" + formatStat("Search");
		return str;
	}

	
	
}