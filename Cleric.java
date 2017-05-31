public class Cleric extends Character
{
	int con;
	int heal;
	public Cleric ()
	{
		con = 8 + diceRoll(8);
		heal = diceRoll(8); 
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
	
	public int getHeal()
	{
		return heal;
	}
	
	public String status()
	{
		String str = "Type: " + type();
		str += "\n" + formatLevel();
		str += "\n" + formatStat("HP");
		str += "\n" + formatStat("MP");
		str += "\n" + formatSkill("Heal");
		str += "\n" + formatStat("Search");
		return str;
	}

	
	
}