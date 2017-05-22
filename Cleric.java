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
	
	public String status(){
		String str = "Type: " + type();
		str += String.format("\n%s: %d/%d", "HP", get("HP"), getInit("HP"));
		str += String.format("\n%s: %d/%d", "MP", get("MP"), getInit("MP"));
		str += 
		
		
		
		for (String s : table.keySet())
			if (!s.equals("MP") && !s.equals("HP"))
				str += String.format("\n%s: %d/%d", s, get(s), getInit(s));
		return str;
	}

	
	
}