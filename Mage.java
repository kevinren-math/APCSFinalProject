public class Mage extends Character
{
	int con;
	int ability;
	public Mage ()
	{
		super();
		con = 6 + diceRoll(6);
		ability = diceRoll(6);
		initStat("HP", con);
		initStat("MP", 3);
		initStat("Dice", 6);	
		initStat("Ability Power", ability); //attack
		initStat("Search", 1);
	}
	
	public String type()
	{
		return "Mage";
	}
	
	public int getAbility()
	{
		return ability;
	}

	
	public String status()
	{
		String str = "Type: " + type();
		str += "\n" + formatLevel();
		str += "\n" + formatStat("HP");
		str += "\n" + formatStat("MP");
		str += "\n" + formatSkills("Ability Power");
		str += "\n" + formatStat("Search");
		return str;
	}
	
	
}