//import GameUtility.*;

public class Mage extends Character
{
	public Mage ()
	{
		int con = 6 + diceRoll(6);
		int ability = diceRoll(6);
		initStat("HP", con);
		initStat("MP", 2);
		initStat("Dice", 6);	
		initStat("Ability", ability); //attack
		initStat("Search", 1);
	}
	
	public String type()
	{
		return "Mage";
	}
	
	
}