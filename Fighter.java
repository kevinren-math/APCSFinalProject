public class Fighter extends Character
{
	public Fighter ()
	{
		super();
		int con = 10 + diceRoll(10);
		int attack = diceRoll(10);
		initStat("HP", con);
		initStat("MP", 2);
		initStat("Dice", 10);
		initStat("Attack", attack); //attack
		initStat("Search", 1);
	}
	


	public String type()
	{
		return "Fighter";
	}
	
	public String status()
	{
		String str = "Type: " + type();
		str += "\n" + formatStat("Lvl");
		str += "\n" + formatStat("HP");
		str += "\n" + formatStat("MP");
		str += "\n" + formatStat("Attack");
		str += "\n" + formatStat("Search");
		return str;
	}

	
	
}