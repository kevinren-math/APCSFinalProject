import GameUtility.*;

public class Fighter extends Character
{
	public Fighter ()
	{
		int Con = 8 + diceRoll(10);
		initStat("Con", Con);
		initStat("Dice", 10);
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