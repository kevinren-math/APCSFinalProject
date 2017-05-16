import java.util.Scanner;
public class MissionScript extends GameScript extends TextReader
{
	static Scanner kb;
	public static void main(String[]args)
	{
		kb = new Scanner(System.in);
		MissionScript();
	}
	public MissionScript() 
	{
		super();
		kb = new Scanner(System.in);
		System.out.println("You wake up at the mouth of a large cave high on a mountain. As you wake up you see a fire at the top of one of the legendary kings watchtower. The watchtowers are a mystery to everyone as no one knows who built them. You decide to go and investigate what is going on. As you walk down the mountian you hear a rustling from one of the bushes next to you. What do you do?");
		String response = kb.nextLine();
		if(response.getResponse() == 0)
			System.out.println("That is not a valid response please try again");
			
		
	}
	
	
}