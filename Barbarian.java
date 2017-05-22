import GameUtility.*;

public class Cleric extends Character
{
	public Cleric ()
	{
		int Con = 8 + diceRoll(8);
		initStat("Con", Con);
		super(Con, 2);	
		initStat("Wis", 2);
		initStat("Search", 2);
	}
	


	public String type()
	{
		return "Cleric";
	}
	
	public LevelUP()
	{
	}
	
	
}