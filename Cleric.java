import GameUtility.*;

public class Cleric extends Character
{
	public Cleric ()
	{
		int con = 8 + diceRoll(8);
		int wis = diceRoll(8); 
		initStat("con", con);
		initStat("dice", 8);
		super(con, 2);	
		initStat("wis", wis); //damage
		initStat("search", 2); //investigates
	}
	
	public String type()
	{
		return "Cleric";
	}

	
	
}