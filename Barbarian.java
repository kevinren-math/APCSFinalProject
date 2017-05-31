public class Barbarian extends Character
{
	int con;
	int armor; 
	int attack;
	public Barbarian ()
	{
		super();
		con = diceRoll(12);
		armor = diceRoll(12); 
		attack = diceRoll(12);
		initStat("HP", con);
		initStat("MP", 0);
		initStat("Dice", 6);
		initStat("Attack", attack);
		initStat("Armor", armor); //armor
		initStat("Search", 3);
	}

	public String type()
	{
		return "Barbarian";
	}
	
	public void levelUp()
	{
		int level = get("Lvl");
		
		
		
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