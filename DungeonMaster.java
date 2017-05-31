public class DungeonMaster extends Character 
{
	public DungeonMaster() {
		super();
		
		Barbarian barbarian = new Barbarian();
		int armor = barbarian.get("Armor") * 3 / 2;
		initStat("Armor", armor);
		
		Cleric cleric = new Cleric();
		int heal = cleric.get("Heal") * 3 / 2;
		initStat("Heal", heal);
		
		Fighter fighter = new Fighter();
		int attack = fighter.get("Attack") * 3 / 2;
		initStat("Attack", attack);
		
		Mage mage = new Mage();
		int ability = mage.get("Ability Power") * 3 / 2;
		initStat("Ability Power", ability);
	}
	
	public int getResult(String character, String response)
	{
		if (diceRoll(response) < character.diceRoll(response) //Best Possible Choice
		{
			return 0;
		}
		
	
		else if (diceRoll(response) > character.diceRoll(response)) // Worst Possible Choice
		{
			return 1;
		}
		
		else if (diceRoll(response) == character.diceRoll(response)) //The Meh Choice
		{
			return 2;
		}

		
	}
	
	public String status()
	{
		String str = "Type: " + type();
		str += "\n" + formatSkill("Heal");
		str += "\n" + formatSkill("Armor");
		str += "\n" + formatSkill("Attack");
		str += "\n" + formatSkill("Ability Power");
		return str;
	}

	
	
	
}