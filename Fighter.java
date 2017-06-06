public class Fighter extends Character
{
	public Fighter ()
	{
		int con = 10 + diceRoll(10);
		int attack = diceRoll(10);
		int armor = diceRoll(10);
		initStat("HP", con);
		initStat("MP", 1);
		initStat("Dice", 10);
		initStat("Attack", attack); //attack
		initStat("Armor", armor);
		initStat("Search", 1);
	}
	
	public String type()
	{
		return "Fighter";
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
		str += "\n" + formatSkill("Armor");
		str += "\n" + formatStat("Search");
		return str;
	}

	
	
}