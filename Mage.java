import GameUtility.*;

public class Mage extends Character
{
	public Mage ()
	{
		int con = 6 + diceRoll(6);
		int ability = diceRoll(6);
		initStat("con", con);
		initStat("dice", 6);
		super(con, 2);	
		initStat("ability", ability); //attack
		initStat("search", 1);
	}
	
	public String type()
	{
		return "Mage";
	}
	
	public void 
	
	
}