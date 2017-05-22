public class Barbarian extends Character
{
	public Barbarian ()
	{
		int con = 12 + diceRoll(12);
		int armor = diceRoll(12); 
		initStat("HP", con);
		initStat("MP", 2);
		initStat("Dice", 6);
		initStat("Armor", armor); //armor
		initStat("Search", 3);
	}
	


	public String type()
	{
		return "Barbarian";
	}
	
	
}