public class Mage extends Character
{
	int con;
	int ability;
	int heal;
	public Mage ()
	{
		con = 6 + diceRoll(6);
		ability = diceRoll(6);
		heal = diceRoll(6);
		initStat("HP", con);
		initStat("MP", 3);
		initStat("Dice", 6);	
		initStat("Heal", heal);
		initStat("Ability Power", ability); //attack
		initStat("Search", 1);
	}
	
	public String type()
	{
		return "Mage";
	}
	

	public String status()
	{
		String str = "Type: " + type();
		str += "\n" + formatLevel();
		str += "\n" + formatStat("HP");
		str += "\n" + formatStat("MP");
		str += "\n" + formatSkill("Ability Power");
		str += "\n" + formatSkill("Heal");
		str += "\n" + formatStat("Search");
		return str;
	}
	
	
}