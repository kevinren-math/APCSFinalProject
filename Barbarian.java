public class Barbarian extends Character
{
	int con;
	int armor; 
	int attack;
	public Barbarian ()
	{
		super();
		con = 12 + diceRoll(12);
		armor = diceRoll(12); 
		attack = diceRoll(12);
		initStat("HP", con);
		initStat("MP", 0);
		initStat("Dice", 6);
		initStat("Attack", attack);
		initStat("Armor", armor); //armor
		initStat("Search", 1);
	}

	public String type()
	{
		return "Barbarian";
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
			increaseStat("Attack", 2);
			increaseStat("Armor", 2);
			
			restoreHP(2);
			resetMP();
		}
		
		if ((5 <= level) && (level <= 8))
		{
			increaseStat("HP", 3);
			increaseStat("MP", 3);
			increaseStat("Dice", 0);
			increaseStat("Attack", 3);
			increaseStat("Armor", 3);
			
			restoreHP(3);
			resetMP();
		}
		
		if (level == 9)
		{
			increaseStat("HP", 4);
			increaseStat("MP", 4);
			increaseStat("Dice", 0);
			increaseStat("Attack", 4);
			increaseStat("Armor", 4);
			
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