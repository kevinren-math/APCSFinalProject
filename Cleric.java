public class Cleric extends Character
{
	public Cleric ()
	{
		int con = 8 + diceRoll(8);
		int heal = diceRoll(8); 
		int attack = diceRoll(8);
		initStat("HP", con);
		initStat("MP", 2);
		initStat("Dice", 8);
		initStat("Heal", heal); 
		initStat("Attack", attack);
		initStat("Search", 2); //investigates
	}
	
	public String type()
	{
		return "Cleric";
	}
	
	public void levelUp()
	{
		
	}
	

	
	public String status()
	{
		String str = "Type: " + type();
		str += "\n" + formatLevel();
		str += "\n" + formatStat("HP");
		str += "\n" + formatStat("MP");
		str += "\n" + formatSkill("Attack");
		str += "\n" + formatSkill("Heal");
		str += "\n" + formatStat("Search");
		return str;
	}

	
	
}