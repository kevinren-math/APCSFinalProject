import java.util.Scanner;
public class MissionScript extends GameScript
{
	static Scanner kb;
	boolean first, second;
	TextReader tr;
	public static void main(String[]args)
	{
		kb = new Scanner(System.in);
		MissionScript mission = new MissionScript();
		mission.prompt();
	}
	
	public MissionScript() {
		first = false;
		second = false;
		tr = new TextReader();
	}
	
	public void prompt()
	{
		super.prompt();
		if (!first && !second) {
			System.out.println("You wake up in vast plain in the middle of nowhere. As you look around you see the plain extends for 100s of miles and on the horizon all around you, you see mountains peaks. As you try and orient yourself and figure out how you got there you see a dark spot in the sky above you coming closer towards you. As it gets closer you realize that it is a large dragon. What do you do?");
		}		
		
		if(first)
		{
			System.out.println("The dragon is now on the ground and creates a circle of fire around itself, trapping all of your party members inside of it. As the area around you heats up you know that you must kill the dragon soon if you have any hope of escape. What do you do?");
			
		}
		else if(second)
		{
			System.out.println("Your attacks causes the dragon the stay in the air. The dragon scorches the area underneath it and you and your party are forced to scatter away. The dragon lands on the scorched area which is now on fire. If you go on the scorched earth you will take DOT ");
			
		}
	}
	
	public Status respond(String response) {
		Response r = tr.getResponse(response);
		if (!first && !second) {
			switch (r) {
				case None:
					System.out.println("That is not a valid response please try again");
					break; 
				case Defend:
					//DungeonMaster.get();
					if(DungeonMaster.getResult2() == 0)
					{
						System.out.println("You are able to get your shields up in time but the dragon is able to smash through them knocking you and your group back(all take damage). The dragon lands on the ground and lets out a terrifying roar.");
						first = true;
					}
					else //if(DungeonMaster.getResult2() == 1)
					{
						System.out.println("You are able to get your defenses up and are able to blocks the dragon's fire breath. The dragon then lands on the ground and lets out a terrifying roar.");
						first = true;
					}
					break;
				case Heal:
					System.out.println("You let out a healing aura that gives a slight buff to everyone's health.");
					first = true;
					break;
				case HealCleric:
					System.out.println("You target heal the cleric granting a large health buff.");
					first = true;
					break;
				case HealFighter:
					System.out.println("You target heal the fighter granting a large health buff.");
					first = true;
					break;
				case HealBarbarian:
					System.out.println("You target heal the barbarian granting a large health buff.");
					first = true;
					break;
				case HealMage:
					System.out.println("You target heal the mage granting a large health buff.");
					first = true;
					break;
				case Investigate:
					System.out.println("You are able to deduce that the dragon is big and scary, but it has a missing eye.");
					first = true;
					break;
				case Attack:
					//DungeonMaster.get();
					if(true)
					{
						System.out.println(" You charge the dragon with your spear, but before you can throw it the dragon swipes you aside causing you to go tumbling away(take large amount of damage)");
						second = true;
					}
					else
					{
						System.out.println("You charge the dragon with a sword and as the dragon comes in to attack you, you are able to roll under it and slash at its backside(dragon takes damage)");
						second = true;
					}
					break;
				case Status:
					System.out.println(GameScript.player[GameScript.turn].status());
					break;
				default:
					System.out.println("how did you get to this part of the code? Must be a bug");
					break;
			}
		} else if (first) {
			switch (r) {
				case Defend:
					//DungeonMaster.get();
					if(DungeonMaster.getResult3() == 0)
					{
						System.out.println("The dragon lets out a large fire breath that pushes you back into the ring of fire(take massive damage). As you get burnt you rush out of the flames take off your armor(loose all armor stat)");
					}
					else if(DungeonMaster.getResult3() == 1)
					{
						System.out.println("The dragon takes a swipe at you and gets its claw stuck in your shield ripping it out of your hand(lose ¼ of armor)");
					}
					else if (DungeonMaster.getResult3() == 2)
					{
						System.out.println("You are able to dodge the dragon’s attack and the attacks have left the dragon vulnerable so you are able to get a few attacks on the dragons sides(dragon takes slight damage)");					
					}
					break;
				case Investigate:
					//DungeonMaster.get();
					if(true)
					{
						System.out.println("You see that the dragon is even bigger and scarier than you thought before, right as he lights you on fire(take massive damage and DOT)");
					}
					else
					{
						System.out.println(" You notice that there is a dark spot on the back of the dragon's neck. This could be a potential weak spot in the dragon");
					}
					break;
				case Heal:
					System.out.println("you let out an aura of healing(heal all or cancel DOT effects)");
					break;
				case HealCleric:
					System.out.println("You target heal the cleric granting a large health buff.");
					first = true;
					break;
				case HealMage:
					System.out.println("You target heal the mage granting a large health buff.");
					first = true;
					break;
				case HealFighter:
					System.out.println("You target heal the fighter granting a large health buff.");
					first = true;
					break;
				case HealBarbarian:
					System.out.println("You target heal the barbarian granting a large health buff.");
					first = true;
					break;
				case Attack:
					//DungeonMaster.get();
					if(true)
					{
						System.out.println("You rush the dragon and are able to attack its leg(dragon takes damage) but as you try to retreat you are slashed by spikes on its tail(take damage)");
					}
					else
					{
						System.out.println("You charge at the dragon and are able to dodge its attacks and reach its wing. Before the dragon can pull its wing away you are able to use your weapon to smash it, disabling the dragon(dragon takes massive damage)");
					}
					break;
				case Status:
					System.out.println(GameScript.player[GameScript.turn].status());
					break;
			}
		} else if (second) {
			switch (r) {
				case Defend:
					//DungeonMaster.get();
					if(true)
					{
						System.out.println(" The dragon inhales pulling you into the scorched earth burning you(take massive damage). As you get burnt you rush out of the flames take off your armor as it is on fire(loose all armor stat)");
					}
					else if(true)
					{
						System.out.println("The dragon takes a swipe at you and gets its claw stuck in your shield ripping it out of your hand(loose ¼ of armor)");
					}
					else
					{
						System.out.println("You are able to dodge away from the dragons attack and the attacks have left the dragon vulnerable so you are able to get a few attacks on the dragons sides(dragon takes slight damage+you take DOT)");					
					}
					break;
				case Investigate:
					//DungeonMaster.get();
					if(true)
					{
						System.out.println("You see that the dragon is even bigger and scarier than you thought before, right as he lights you on fire(take massive damage and DOT)");
					}
					else
					{
						System.out.println(" You notice that there is a dark spot on the back of the dragon's neck. This could be a potential weak spot in the dragon");
					}
					break;
				case Heal:
					System.out.println("you let out an aura of healing(heal all or cancel DOT effects)");
					break;
				case HealCleric:
					System.out.println("You target heal the cleric granting a large health buff.");
					first = true;
					break;
				case HealMage:
					System.out.println("You target heal the mage granting a large health buff.");
					first = true;
					break;
				case HealFighter:
					System.out.println("You target heal the fighter granting a large health buff.");
					first = true;
					break;
				case HealBarbarian:
					System.out.println("You target heal the barbarian granting a large health buff.");
					first = true;
					break;
				case Attack:
					//DungeonMaster.get();
					if(true)
					{
						System.out.println("You rush the dragon and are able to attack its leg(dragon takes damage) but as you try to retreat you are slashed by spikes on its tail(take damage+DOT)");
					}
					else
					{
						System.out.println("You charge at the dragon and are able to dodge its attacks and reach its wing. Before the dragon can pull its wing away you are able to use your weapon to smash it, disabling the dragon(dragon takes massive damage+you take DOT)");
					}
				break;
			}
		}
		return Status.SURVIVE;
	}
	
	public void die() {
		//Die
	}
}