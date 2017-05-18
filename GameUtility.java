public class GameUtility {
	public static int rand(int a, int b) {
		return (int)(Math.random() * (b - a + 1)) + a;
	}
	
	public static int diceRoll(int a) {
		return rand(1, a);
	}
}