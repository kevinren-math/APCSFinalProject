public class DungeonMaster extends Character 
{
	public DungeonMaster() {
		super();
		
		Barbarian barbarian = new Barbarian();
		int armor = (barbarian.get("armor")) + ((barbarian.get("armor"))/2);
		initStat("Armor", armor);
		
		Cleric cleric = new Cleric();
		int heal = (cleric.getHeal()) + ((cleric.getHeal())/2);
		initStat("Heal", heal);
		
		Fighter fighter = new Fighter();
		int attack = (fighter.getAttack()) + ((fighter.getAttack())/2);
		initStat("Attack", attack);
		
		Mage mage = new Mage();
		int ability = (mage.getAbility()) + ((mage.getAbility())/2) ;
		initStat("Ability Power", ability);
	}
	
	public String status()
	{
		String str = "Type: " + type();
		str += "\n" + formatSkills("Heal");
		str += "\n" + formatSkills("Armor");
		str += "\n" + formatSkills("Attack");
		str += "\n" + formatSkills("Ability Power");
		return str;
	}

	
	
	
}