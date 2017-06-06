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
	
	public int getResult3()
	{
		int response = 20;
		int roll1 = diceRoll(response);
		int roll2 = diceRoll(response);
		if (roll1 < roll2) //Best Possible Choice
		{
			return 0;
		}
		
	
		else if (roll1 > roll2) // Worst Possible Choice
		{
			return 1;
		}
		
		else //if (roll1 == roll2) //The Meh Choice
		{
			return 2;
		} 
	}
	
	public int getResult2()
	{
		int response = 20;
		int roll1 = diceRoll(response);
		int roll2 = diceRoll(response);
		if (roll1 < roll2) //Best Possible Choice
		{
			return 0;
		}
		
	
		else //if (roll1 >= roll2) // Worst Possible Choice
		{
			return 1;
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