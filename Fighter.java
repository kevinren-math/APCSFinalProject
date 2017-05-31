public class Fighter extends Character
{
	int con;
	int attack;
	int armor;
	public Fighter ()
	{
		con = 10 + diceRoll(10);
		attack = diceRoll(10);
		armor = diceRoll(10);
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
	
	public int getAttack()
	{
		return attack;
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