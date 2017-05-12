import java.util.*;
import java.io.*;
public class GameRunner {
	public static void main(String[] args) throws IOException {
		String charFile = "characters.txt";
		List<Character> list = Character.loadFromFile(charFile);
		System.out.println("Enter the number of the character you select:");
		System.out.println("Type / Start HP / Start MP");
		for (int i = 0; i < list.size(); i++) {
			System.out.printf("%2d. %s\n", i+1, list.get(i).description());
		}
	}
}