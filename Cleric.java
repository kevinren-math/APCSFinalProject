public class Cleric extends Character
{
	public Cleric ()
	{
		int con = 8 + diceRoll(8);
		int heal = diceRoll(8); 
		int attack = diceRoll(2);
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
		increaseStat("Lvl", 1);
		
		int level = get("Lvl");
		
		if ((1 <= level) && (level <= 4))
		{
			increaseStat("HP", 2);
			increaseStat("MP", 2);
			increaseStat("Dice", 1);
			increaseStat("Heal", 2);
			increaseStat("Attack", 2);
			restoreHP(2);
			resetMP();
		}
		
		if ((5 <= level) && (level <= 8))
		{
			increaseStat("HP", 3);
			increaseStat("MP", 3);
			increaseStat("Dice", 0);
			increaseStat("Heal", 3);
			increaseStat("Attack", 3);
			
			restoreHP(3);
			resetMP();
		}
		
		if (level == 9)
		{
			increaseStat("HP", 4);
			increaseStat("MP", 4);
			increaseStat("Dice", 0);
			increaseStat("Heal", 4);
			increaseStat("Attack", 4);
			
			restoreHP(4);
			resetMP();
		}
		
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