//import static GameUtility.*;

public class Cleric extends Character
{
	public Cleric ()
	{
		int con = 8 + diceRoll(8);
		int wis = diceRoll(8); 
		initStat("HP", con);
		initStat("MP", 2);
		initStat("Dice", 8);
		initStat("Wis", wis); //damage
		initStat("Search", 2); //investigates
	}
	
	public String type()
	{
		return "Cleric";
	}

	
	
}