import GameUtility.*;

public class Fighter extends Character
{
	public Fighter ()
	{
		int con = 10 + diceRoll(10);
		int attack = diceRoll(10);
		initStat("con", con);
		initStat("dice", 10);
		super(con, 2);	
		initStat("attack", attack); //attack
		initStat("search", 1);
	}
	


	public String type()
	{
		return "Fighter";
	}

	
	
}