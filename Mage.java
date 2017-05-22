import GameUtility.*;

public class Cleric extends Character
{
	public Cleric ()
	{
		int Con = 10 + diceRoll(10);
		int Atk = diceRoll(10);
		initStat("Con", Con);
		initStat("Dice", 10);
		super(Con, 2);	
		initStat("Attack", Atk);
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