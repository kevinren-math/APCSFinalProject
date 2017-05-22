import GameUtility.*;

public class Barbarian extends Character
{
	public Barbarian ()
	{
		int con = 12 + diceRoll(12);
		int armor = diceRoll(12); 
		initStat("con", con);
		initStat("dice", 6);
		super(con, 2);	
		initStat("armor", armor); //armor
		initStat("search", 3);
	}
	


	public String type()
	{
		return "Barbarian";
	}
	
	
}